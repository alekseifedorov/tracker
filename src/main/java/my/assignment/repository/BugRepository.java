package my.assignment.repository;

import my.assignment.entity.BugEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BugRepository extends JpaRepository<BugEntity, UUID> {
}
