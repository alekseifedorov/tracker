package my.assignment.repository;

import my.assignment.entity.StoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeveloperRepository extends JpaRepository<StoryEntity, Long> {
}
