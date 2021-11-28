package my.assignment.service;

import my.assignment.model.Developer;

import java.util.UUID;

public interface DeveloperService {
    Developer createOrUpdateDeveloper(Developer developer);

    void deleteDeveloper(UUID id);

    void assignToBug(UUID developerId, UUID bugId);

    void assignToStory(UUID developerId, UUID storyId);
}
