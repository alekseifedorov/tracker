package my.assignment.repository;

import my.assignment.entity.DeveloperEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DeveloperRepository extends JpaRepository<DeveloperEntity, UUID> {
}
