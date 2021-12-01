package my.assignment.service.impl;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import my.assignment.model.*;
import my.assignment.service.CalculatorEngine;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.IntStream;

@Slf4j
@NoArgsConstructor
@Service
public class CalculatorEngineImpl implements CalculatorEngine {

    public static final int MAX_STORY_POINTS_PER_WEEK = 10;

    @Override
    public Plan calculatePlan(CalculationRequest request) {
        log.info("Calculating is starting...");
        if (CollectionUtils.isEmpty(request.getDevelopers()) || CollectionUtils.isEmpty(request.getStories())) {
            throw new IllegalArgumentException("List of stories or developers must not be empty");
        }

        var developers = new ArrayList<>(request.getDevelopers());
        request.getStories().forEach(story -> {
                    var developer = developers.stream().min(Comparator.comparing(Developer::getPoints)).get();
                    story.setDeveloper(developer);
                    developer.setPoints(developer.getPoints() + story.getPoints());
                    developer.getStories().add(story);
                }
        );

        int numberOfWeeks = getNumberOfWeeks(developers);
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

    private int getNumberOfWeeks(ArrayList<Developer> developers) {
        return developers.stream().max(Comparator.comparing(Developer::getPoints))
                .map(Developer::getPoints).orElse(0) / MAX_STORY_POINTS_PER_WEEK + 1;
    }

    private int addStoryToCurrentWeek(Plan plan, int developerCurrentPoints, Story currentStory) {
        var storyPoints = currentStory.getPoints();
        while (storyPoints > 0) {
            int pointsOnCurrentWeek = getPointsOnCurrentWeek(developerCurrentPoints, storyPoints);
            doAddStoryToCurrentWeek(plan, developerCurrentPoints, pointsOnCurrentWeek, currentStory);
            developerCurrentPoints += pointsOnCurrentWeek;
            storyPoints -= pointsOnCurrentWeek;
        }
        return developerCurrentPoints;
    }

    private void doAddStoryToCurrentWeek(Plan plan, int developerCurrentPoints, int storyPartPoints,
                                         Story currentStory) {
        var storyPart = StoryPart.builder()
                .story(currentStory)
                .startDayOfWeek(developerCurrentPoints % MAX_STORY_POINTS_PER_WEEK)
                .points(storyPartPoints)
                .build();
        plan.getWeeks().get(developerCurrentPoints / MAX_STORY_POINTS_PER_WEEK)
                .getStories()
                .add(storyPart);
    }

    private int getPointsOnCurrentWeek(int developerCurrentPoints, int storyPoints) {
        int alreadySpentOnCurrentWeek = developerCurrentPoints % MAX_STORY_POINTS_PER_WEEK;
        return alreadySpentOnCurrentWeek + storyPoints <= MAX_STORY_POINTS_PER_WEEK ? storyPoints :
                MAX_STORY_POINTS_PER_WEEK - alreadySpentOnCurrentWeek;
    }
}
