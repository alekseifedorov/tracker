package my.assignment.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import my.assignment.model.Bug;
import my.assignment.model.Developer;
import my.assignment.model.Plan;
import my.assignment.model.Story;
import my.assignment.service.CalculatorEngine;
import my.assignment.service.IssueTrackerService;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class IssueTrackerServiceImpl implements IssueTrackerService {


    private final MapperFacade mapperFacade;

    private final CalculatorEngine calculatorEngine;

    @Override
    public Plan calculatePlan() {
        return calculatorEngine.calculatePlan(null);
    }

    @Override
    public Bug createOrUpdateBug(Bug bug) {
        return null;
    }

    @Override
    public void deleteBug(String id) {

    }

    @Override
    public Story createOrUpdateStory(Story story) {
        return null;
    }

    @Override
    public void deleteStory(String id) {

    }

    @Override
    public void deleteDeveloper(String id) {

    }

    @Override
    public Developer createOrUpdateDeveloper(Developer developer) {
        return null;
    }
}
