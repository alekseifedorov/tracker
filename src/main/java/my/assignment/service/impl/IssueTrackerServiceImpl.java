package my.assignment.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import my.assignment.model.*;
import my.assignment.repository.DeveloperRepository;
import my.assignment.repository.StoryRepository;
import my.assignment.service.CalculatorEngine;
import my.assignment.service.IssueTrackerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@AllArgsConstructor
@Service
public class IssueTrackerServiceImpl implements IssueTrackerService {


    private final MapperFacade mapperFacade;

    private final CalculatorEngine calculatorEngine;

    private final StoryRepository storyRepository;

    private final DeveloperRepository developerRepository;

    @Override
    @Transactional(readOnly = true)
    public Plan calculatePlan() {
        var stories = mapperFacade.mapAsList(storyRepository.findAll(), Story.class);
        var developers = mapperFacade.mapAsList(developerRepository.findAll(), Developer.class);
        return calculatorEngine.calculatePlan(CalculationRequest.builder()
                .stories(stories)
                .developers(developers)
                .build());
    }
}
