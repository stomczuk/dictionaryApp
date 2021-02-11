package app.controller;


import app.DTO.EnglishWordDTO;
import app.entity.EnglishWord;
import app.service.EnglishWordService;
import app.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/englishWord")
@RestController
public class EnglishWordController {

    private final EnglishWordService englishWordService;
    private final UserService userService;


    public EnglishWordController(EnglishWordService englishWordService, UserService userService) {
        this.englishWordService = englishWordService;
        this.userService = userService;
    }

    Logger logger = Logger.getGlobal();


    @PostMapping("/add_word")
    public ResponseEntity add(@RequestBody List<EnglishWordDTO> englishWordDTO) {
        System.out.println(englishWordDTO);
        englishWordService.saveListOfDTO(englishWordDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(value = "/fetch_word")
    public ResponseEntity getWordById(@RequestBody Long id) {
        EnglishWord englishWord = englishWordService.getEnglishWordById(id);
        return new ResponseEntity(englishWordService.convertWordToDTO(englishWord), HttpStatus.OK);
    }

    @PostMapping("/delete_word")
    public ResponseEntity delete(@RequestBody Long id) {
        if (id != null) {
            try {
//                User user = userService.findByUsername(securityService.findLoggedInUsername());
                this.englishWordService.deleteById(id);

//                user.removeGroup(englishWord);
//                englishWordService.save(englishWord);
            } catch (Exception e) {
                logger.info(e.getMessage());
                return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/edit_word")
    public ResponseEntity edit(@RequestBody EnglishWordDTO englishWordDTO) {
        if (englishWordDTO != null) {
            try {
                EnglishWord editedEnglishWord = englishWordService.convertToDao(englishWordDTO);
                EnglishWord englishWordToEdit = englishWordService.getEnglishWordById(editedEnglishWord.getId());
                englishWordToEdit.setWord(editedEnglishWord.getWord());
                englishWordToEdit.setTranslation(editedEnglishWord.getTranslation());
                englishWordService.saveDAO(englishWordToEdit);

            } catch (Exception e) {
                logger.info(e.getMessage());
                return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity(HttpStatus.OK);
    }


    @GetMapping("/list_of_all_words")
    public ResponseEntity<List<EnglishWordDTO>> getListOfAllWords() {
        List list = this.englishWordService.getAllWords();
        list.sort(Comparator.comparing(EnglishWord::getId));
        return new ResponseEntity<List<EnglishWordDTO>>(englishWordService.convertListOfWordsToDTO(list), HttpStatus.OK);
    }
}
