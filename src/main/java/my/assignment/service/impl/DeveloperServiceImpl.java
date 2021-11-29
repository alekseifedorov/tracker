package my.assignment.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import my.assignment.entity.DeveloperEntity;
import my.assignment.model.Developer;
import my.assignment.repository.BugRepository;
import my.assignment.repository.DeveloperRepository;
import my.assignment.repository.StoryRepository;
import my.assignment.service.DeveloperService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.UUID;

@Slf4j
@AllArgsConstructor
@Service
public class DeveloperServiceImpl implements DeveloperService {

    private final BugRepository bugRepository;

    private final StoryRepository storyRepository;

    private final DeveloperRepository developerRepository;

    private final MapperFacade mapperFacade;

    @Override
    public Developer createOrUpdateDeveloper(Developer developer) {
        var entity = mapperFacade.map(developer, DeveloperEntity.class);
        var savedEntity = developerRepository.save(entity);
        return mapperFacade.map(savedEntity, Developer.class);
    }

    @Override
    public void deleteDeveloper(UUID id) {
        developerRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void assignToBug(UUID developerId, UUID bugId) {
        var developer = developerRepository.findById(developerId)
                .orElseThrow(() -> new EntityNotFoundException("Developer not found [" + developerId + "]"));
        var bug = bugRepository.findById(bugId)
                .orElseThrow(() -> new EntityNotFoundException("Bug not found [" + bugId + "]"));
        bug.setDeveloper(developer);
    }

    @Override
    @Transactional
    public void assignToStory(UUID developerId, UUID storyId) {
        var developer = developerRepository.findById(developerId)
                .orElseThrow(() -> new EntityNotFoundException("Developer not found [" + developerId + "]"));
        var story = storyRepository.findById(storyId)
                .orElseThrow(() -> new EntityNotFoundException("Story not found [" + storyId + "]"));
        story.setDeveloper(developer);
    }
}
