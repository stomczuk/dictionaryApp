package app.controller;

import app.entity.EnglishWord;
import app.model.Test;
import app.repository.EnglishWordRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin
public class TestRestController {

    private final EnglishWordRepository englishWordRepository;

    public TestRestController(EnglishWordRepository englishWordRepository) {
        this.englishWordRepository = englishWordRepository;
    }

    @GetMapping("/test")
    public Test testMethod() {
        Test user = new Test("123", "456");
        Test user1 = new Test("123", "456");
        List<Test> list = Arrays.asList(user, user1);
        return user;
    }

    @GetMapping("/list_of_all_words")
    public List<EnglishWord> getListOfAllWords() {
//        User user = userService.findByUsername(securityService.findLoggedInUsername());
//        return englishWordService.findAllEnglishWordsByUser(user);
        List list = Arrays.asList(englishWordRepository.findAll());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        return list;
    }
}
