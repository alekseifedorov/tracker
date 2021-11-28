package my.assignment.service;

import my.assignment.model.Bug;

public interface BugService {
    Bug createOrUpdateBug(Bug bug);

    void deleteBug(String title);
}
