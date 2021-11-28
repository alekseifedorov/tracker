package my.assignment.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import my.assignment.model.*;
import my.assignment.service.CalculatorEngine;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.IntStream;

@Slf4j
@AllArgsConstructor
@Service
public class CalculatorEngineImpl implements CalculatorEngine {

    // From spec: As long as no new stories are created, the distribution should remain the same.
    // It might be stored, for example, in Redis
    private Map<CalculationRequest, Plan> previousResults = new HashMap<>();

    public static final int MAX_STORY_POINTS_PER_WEEK = 10;

    @Override
    public Plan calculatePlan(CalculationRequest request) {
        if (CollectionUtils.isEmpty(request.getDevelopers()) || CollectionUtils.isEmpty(request.getStories())) {
            throw new IllegalArgumentException("List of stories or developers must not be empty");
        }

        if (previousResults.containsKey(request)) {
            return previousResults.get(request);
        }

        var developers = new ArrayList<>(request.getDevelopers());
        request.getStories().forEach(story -> {
                    var developer = developers.stream().min(Comparator.comparing(Developer::getPoints)).get();
                    story.setDeveloper(developer);
                    developer.setPoints(developer.getPoints() + story.getPoints());
                    developer.getStories().add(story);
                }
        );

        int numberOfWeeks = developers.stream()
                .max(Comparator.comparing(Developer::getPoints)).get().getPoints() / MAX_STORY_POINTS_PER_WEEK + 1;
        var plan = new Plan();
        IntStream.range(0, numberOfWeeks).forEach(i -> plan.getWeeks().add(new Week()));

        request.getDevelopers().forEach(developer -> {
            int developerCurrentPoints = 0;
            for (int i = 0; i < developer.getStories().size(); i++) {
                developerCurrentPoints = addStoryToCurrentWeek(plan, developerCurrentPoints,
                        developer.getStories().get(i));
            }
        });

        return plan;
    }

    private int addStoryToCurrentWeek(Plan plan, int developerCurrentPoints, Story currentStory) {
        var storyPoints = currentStory.getPoints();
        while (storyPoints > 0) {
            int pointsOnCurrentWeek = getPointsOnCurrentWeek(developerCurrentPoints, storyPoints);
            plan.getWeeks().get(developerCurrentPoints + pointsOnCurrentWeek / MAX_STORY_POINTS_PER_WEEK + 1)
                    .getStories()
                    .add(currentStory);
            storyPoints -= pointsOnCurrentWeek;
            developerCurrentPoints += pointsOnCurrentWeek;
        }
        return developerCurrentPoints;
    }

    private int getPointsOnCurrentWeek(int developerCurrentPoints, int storyPoints) {
        int spentOnCurrentWeek = MAX_STORY_POINTS_PER_WEEK - developerCurrentPoints % MAX_STORY_POINTS_PER_WEEK;
        return spentOnCurrentWeek + storyPoints <= MAX_STORY_POINTS_PER_WEEK ? storyPoints :
                MAX_STORY_POINTS_PER_WEEK - spentOnCurrentWeek;
    }
}
