package my.assignment.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import my.assignment.model.Bug;
import my.assignment.repository.BugRepository;
import my.assignment.service.BugService;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class BugServiceImpl implements BugService {


    private final BugRepository bugRepository;

    private final MapperFacade mapperFacade;

    @Override
    public Bug createOrUpdateBug(Bug bug) {
        return null;
    }

    @Override
    public void deleteBug(String title) {

    }
}
