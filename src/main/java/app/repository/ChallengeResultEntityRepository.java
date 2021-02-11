package app.repository;

import app.entity.ChallengeResultEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChallengeResultEntityRepository extends JpaRepository<ChallengeResultEntity, Long> {
}
