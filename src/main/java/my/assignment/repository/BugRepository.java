package my.assignment.repository;

import my.assignment.entity.BugEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BugRepository extends JpaRepository<BugEntity, Long> {
}
