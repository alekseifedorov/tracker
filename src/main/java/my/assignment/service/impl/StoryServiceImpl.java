package my.assignment.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import my.assignment.model.Story;
import my.assignment.repository.StoryRepository;
import my.assignment.service.StoryService;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class StoryServiceImpl implements StoryService {


    private final StoryRepository storyRepository;

    private final MapperFacade mapperFacade;

    @Override
    public Story createOrUpdateStory(Story title) {
        return null;
    }

    @Override
    public void deleteStory(String title) {

    }
}
