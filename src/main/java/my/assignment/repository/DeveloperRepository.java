package my.assignment.repository;

import my.assignment.entity.DeveloperEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface DeveloperRepository extends JpaRepository<DeveloperEntity, UUID> {
    @Query("SELECT DISTINCT d FROM DeveloperEntity d LEFT JOIN FETCH d.stories")
    List<DeveloperEntity> findAllWithStories();
}
