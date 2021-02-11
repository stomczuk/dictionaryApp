package app.controller;

import app.DTO.ChallengeResultDTO;
import app.service.ChallengeResultService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/challenge")
public class ChallengeResultController {

    private final ModelMapper modelMapper;
    private final ChallengeResultService challengeResultService;

    public ChallengeResultController(ModelMapper modelMapper, ChallengeResultService challengeResultService) {
        this.modelMapper = modelMapper;
        this.challengeResultService = challengeResultService;
    }

    @PostMapping("/save_challenge")
    public ResponseEntity saveChallengeResult(@RequestBody ChallengeResultDTO challengeResultDTO) {
        Long challengeResultId;
        try {
            challengeResultId = challengeResultService.saveDTO(challengeResultDTO);
            return new ResponseEntity(challengeResultId, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/fetch_ranking")
    public ResponseEntity fetchRanking() {
        List list = challengeResultService.generateRanking();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/fetch_place")
    public ResponseEntity fetchPlace(@RequestBody int idOfResult) {
        Long id = new Long(idOfResult);
        int place = 0;
        ChallengeResultDTO challengeResultEntity =
                modelMapper.map(challengeResultService.getChallengeResult(id), ChallengeResultDTO.class);
        List<ChallengeResultDTO> list = challengeResultService.generateRanking();
        for (int i = 0; i < list.size(); i++) {
            if (challengeResultEntity.getId() == list.get(i).getId()) {
                place = i + 1;
            }
        }
        return new ResponseEntity(place, HttpStatus.OK);
    }

}
