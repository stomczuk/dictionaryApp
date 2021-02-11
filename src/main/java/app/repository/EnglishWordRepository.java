package app.repository;

import app.entity.EnglishWord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnglishWordRepository extends JpaRepository<EnglishWord, Long> {

//    List<EnglishWord> findAllByUsers(User user);
}
