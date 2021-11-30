package my.assignment.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import my.assignment.entity.DeveloperEntity;
import my.assignment.model.*;
import my.assignment.repository.DeveloperRepository;
import my.assignment.repository.StoryRepository;
import my.assignment.service.CalculatorEngine;
import my.assignment.service.IssueTrackerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@AllArgsConstructor
@Service
public class IssueTrackerServiceImpl implements IssueTrackerService {


    private final MapperFacade mapperFacade;

    private final CalculatorEngine calculatorEngine;

    private final StoryRepository storyRepository;

    private final DeveloperRepository developerRepository;

    // From spec: As long as no new stories are created, the distribution should remain the same.
    // It might be stored, for example, in Redis
    private Map<CalculationRequest, Plan> previousResults = new HashMap<>();

    @Override
    @Transactional
    public Plan calculatePlan() {
        var stories = mapperFacade.mapAsList(storyRepository.findAll(), Story.class);
        var developers = mapperFacade.mapAsList(developerRepository.findAll(), Developer.class);

        CalculationRequest request = CalculationRequest.builder()
                .stories(stories)
                .developers(developers)
                .build();


        var plan = previousResults.computeIfAbsent(request, r -> calculatorEngine.calculatePlan(request));
        //assignment is done in the planning
        assignDevelopersToStories(plan);

        return plan;
    }

    private void assignDevelopersToStories(Plan plan) {
        plan.getWeeks().forEach(week ->
                week.getStories().stream()
                        .map(StoryPart::getStory)
                        .forEach(story -> {
                            var storyEntity = storyRepository.getById(story.getId());
                            storyEntity.setDeveloper(DeveloperEntity.builder().id(story.getDeveloper().getId()).build());
                            storyRepository.save(storyEntity);
                        })
        );
    }
}
