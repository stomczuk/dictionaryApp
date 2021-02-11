package app.service;

import app.DTO.EnglishWordDTO;
import app.entity.EnglishWord;
import app.repository.EnglishWordRepository;
import app.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnglishWordServiceImpl implements EnglishWordService {


    private final EnglishWordRepository englishWordRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public EnglishWordServiceImpl(EnglishWordRepository englishWordRepository, ModelMapper modelMapper,
                                  UserRepository userRepository) {
        this.englishWordRepository = englishWordRepository;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }

    @Override
    public void saveListOfDTO(List<EnglishWordDTO> englishWordsDTO) {
//        EnglishWord englishWord = convertToDao(englishWordDTO);
//        User user = userRepository.findByUsername("123");
//        Set<User> users = new HashSet<>();
//        users.add(user);
//        englishWord.setUsers(users);
//        englishWord.setId(3L);
//        englishWord.setUsers(users);
        List<EnglishWord> words = modelMapper.map(englishWordsDTO, new TypeToken<List<EnglishWord>>() {
        }.getType());
        englishWordRepository.saveAll(words);
    }

    @Override
    public void saveDAO(EnglishWord englishWord) {
        englishWordRepository.save(englishWord);
    }

    @Override
    public EnglishWord getEnglishWordById(Long id) {
        return englishWordRepository.findById(id).get();
    }


    @Override
    public List<EnglishWordDTO> convertListOfWordsToDTO(List<EnglishWord> list) {
        List<EnglishWordDTO> listDTO = new ArrayList();
        EnglishWordDTO englishWordDTO;
        for (int i = 0; i < list.size(); i++) {
            englishWordDTO = modelMapper.map(list.get(i), EnglishWordDTO.class);
            listDTO.add(englishWordDTO);
        }
        return listDTO;
    }

    @Override
    public EnglishWord convertToDao(EnglishWordDTO englishWordDTO) {
        EnglishWord englishWord = modelMapper.map(englishWordDTO, EnglishWord.class);
        return englishWord;
    }

    @Override
    public void deleteById(Long id) {
        if (id != null) {
            this.englishWordRepository.deleteById(id);
        }
    }

    @Override
    public List<EnglishWord> getAllWords() {
        List list = englishWordRepository.findAll();
        return list;
    }

    @Override
    public EnglishWordDTO convertWordToDTO(EnglishWord englishWord) {
        return modelMapper.map(englishWord, EnglishWordDTO.class);
    }
}
