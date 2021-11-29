package my.assignment.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import my.assignment.entity.StoryEntity;
import my.assignment.model.Story;
import my.assignment.repository.StoryRepository;
import my.assignment.service.StoryService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@AllArgsConstructor
@Service
public class StoryServiceImpl implements StoryService {


    private final StoryRepository storyRepository;

    private final MapperFacade mapperFacade;

    @Override
    public Story createOrUpdateStory(Story story) {
        var entity = mapperFacade.map(story, StoryEntity.class);
        var savedEntity = storyRepository.save(entity);
        return mapperFacade.map(savedEntity, Story.class);
    }

    @Override
    public void deleteStory(UUID id) {
        storyRepository.deleteById(id);
    }
}
