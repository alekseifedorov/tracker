package my.assignment.service;

import my.assignment.model.Story;

public interface StoryService {
    Story createOrUpdateStory(Story title);

    void deleteStory(String title);
}
