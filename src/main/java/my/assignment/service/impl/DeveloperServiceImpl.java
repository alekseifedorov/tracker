package my.assignment.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import my.assignment.model.Developer;
import my.assignment.model.Plan;
import my.assignment.repository.DeveloperRepository;
import my.assignment.service.DeveloperService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@AllArgsConstructor
@Service
public class DeveloperServiceImpl implements DeveloperService {


    private final DeveloperRepository developerRepository;

    private final MapperFacade mapperFacade;

    @Override
    public Developer createOrUpdateDeveloper(Developer developer) {
        return null;
    }

    @Override
    public void deleteDeveloper(UUID id) {

    }

    @Override
    public void assignToBug(UUID developerId, UUID bugId) {

    }

    @Override
    public void assignToStory(UUID developerId, UUID storyId) {

    }
}
