package my.assignment.service;

import my.assignment.model.Developer;
import my.assignment.model.ShortDeveloper;

import java.util.List;
import java.util.UUID;

public interface DeveloperService {
    Developer createOrUpdateDeveloper(Developer developer);

    void deleteDeveloper(UUID id);

    void assignToBug(UUID developerId, UUID bugId);

    void assignToStory(UUID developerId, UUID storyId);

    List<ShortDeveloper> getAll();
}
