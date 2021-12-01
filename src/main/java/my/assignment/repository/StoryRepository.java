package my.assignment.repository;

import my.assignment.entity.StoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface StoryRepository extends JpaRepository<StoryEntity, UUID> {
    List<StoryEntity> findByDeveloperId(@Param("developerId") UUID developerId);
}
