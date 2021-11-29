package my.assignment.service;

import my.assignment.model.Bug;

import java.util.UUID;

public interface BugService {
    Bug createOrUpdateBug(Bug bug);

    void deleteBug(UUID id);
}
