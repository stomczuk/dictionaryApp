package app.service;

import app.DTO.EnglishWordDTO;
import app.entity.EnglishWord;

import java.util.List;

public interface EnglishWordService {

    void saveListOfDTO(List<EnglishWordDTO> englishWordsDTO);

    void saveDAO(EnglishWord englishWord);

    EnglishWord getEnglishWordById(Long id);

    //    List<EnglishWord>findAllEnglishWordsByUser(User user);
    List<EnglishWordDTO> convertListOfWordsToDTO(List<EnglishWord> list);

    EnglishWord convertToDao(EnglishWordDTO englishWordDTO);

    void deleteById(Long id);

    List<EnglishWord> getAllWords();

    EnglishWordDTO convertWordToDTO(EnglishWord englishWord);


}
