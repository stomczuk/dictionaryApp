package app.service;

import app.DTO.ChallengeResultDTO;
import app.entity.ChallengeResultEntity;
import app.repository.ChallengeResultEntityRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class ChallengeResultServiceImpl implements ChallengeResultService {

    private final ModelMapper modelMapper;
    private final ChallengeResultEntityRepository challengeResultEntityRepository;

    public ChallengeResultServiceImpl(ModelMapper modelMapper, ChallengeResultEntityRepository challengeResultEntityRepository) {
        this.modelMapper = modelMapper;
        this.challengeResultEntityRepository = challengeResultEntityRepository;
    }

    @Override
    public ChallengeResultEntity convertDTOChallengeResultToEntity(ChallengeResultDTO challengeResultDTO) {
        ChallengeResultEntity challengeResultEntity = modelMapper.map(challengeResultDTO, ChallengeResultEntity.class);
        return challengeResultEntity;
    }

    @Override
    public Long saveDTO(ChallengeResultDTO challengeResultDTO) {
        ChallengeResultEntity challengeResultEntity = convertDTOChallengeResultToEntity(challengeResultDTO);
        challengeResultEntityRepository.save(challengeResultEntity);
        return challengeResultEntity.getId();
    }

    @Override
    public List<ChallengeResultDTO> convertListOfChallengeResultEntityToDTO(List<ChallengeResultEntity> listOfChallengeResultEntity) {
        List<ChallengeResultDTO> rankingList = new ArrayList<ChallengeResultDTO>();
        listOfChallengeResultEntity.forEach(challengeResultEntity -> {
            ChallengeResultDTO challengeResultDTO = modelMapper.map(challengeResultEntity, ChallengeResultDTO.class);
            rankingList.add(challengeResultDTO);
        });
        return rankingList;
    }

    @Override
    public List<ChallengeResultDTO> generateRanking() {
        List list = convertListOfChallengeResultEntityToDTO(challengeResultEntityRepository.findAll());
        Comparator<ChallengeResultDTO> comparator = Comparator.comparing(result -> result.getCorrectAnswer());
        Comparator<ChallengeResultDTO> comparatorReversed = comparator.reversed();
        comparator = comparatorReversed.thenComparing(result -> result.getTime());
        list.sort(comparator);
        return list;
    }

    @Override
    public ChallengeResultEntity getChallengeResult(Long id) {
        ChallengeResultEntity challengeResultEntity = challengeResultEntityRepository.findById(id).get();
        return challengeResultEntity;
    }
}
