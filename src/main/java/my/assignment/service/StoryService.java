package my.assignment.service;

import my.assignment.model.Story;

import java.util.List;
import java.util.UUID;

public interface StoryService {
    Story createOrUpdateStory(Story story);

    void deleteStory(UUID id);

    List<Story> getAll();
}
