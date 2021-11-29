package my.assignment.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import my.assignment.entity.BugEntity;
import my.assignment.model.Bug;
import my.assignment.repository.BugRepository;
import my.assignment.service.BugService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@AllArgsConstructor
@Service
public class BugServiceImpl implements BugService {

    private final BugRepository bugRepository;

    private final MapperFacade mapperFacade;

    @Override
    public Bug createOrUpdateBug(Bug bug) {
        var entity = mapperFacade.map(bug, BugEntity.class);
        var savedEntity = bugRepository.save(entity);
        return mapperFacade.map(savedEntity, Bug.class);
    }

    @Override
    public void deleteBug(UUID id) {
        bugRepository.deleteById(id);
    }
}
