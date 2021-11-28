package my.assignment.service;

import my.assignment.model.Bug;
import my.assignment.model.Developer;
import my.assignment.model.Plan;
import my.assignment.model.Story;

public interface IssueTrackerService {

    Plan calculatePlan();

    Bug createOrUpdateBug(Bug bug);

    void deleteBug(String id);

    Story createOrUpdateStory(Story story);

    void deleteStory(String id);

    void deleteDeveloper(String id);

    Developer createOrUpdateDeveloper(Developer developer);
}
