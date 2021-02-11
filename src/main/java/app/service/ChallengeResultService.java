package app.service;

import app.DTO.ChallengeResultDTO;
import app.entity.ChallengeResultEntity;

import java.util.List;

public interface ChallengeResultService {

    ChallengeResultEntity convertDTOChallengeResultToEntity(ChallengeResultDTO challengeResultDTO);

    List<ChallengeResultDTO> convertListOfChallengeResultEntityToDTO(List<ChallengeResultEntity> listOfChallengeResultEntity);

    Long saveDTO(ChallengeResultDTO challengeResultDTO);

    List<ChallengeResultDTO> generateRanking();

    ChallengeResultEntity getChallengeResult(Long id);
}
