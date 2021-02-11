package app.entity;

import javax.persistence.*;

@Entity
@Table(name = "challenge_result")
public class ChallengeResultEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int correctAnswer;
    private String time;
    private int ranking;

    public ChallengeResultEntity() {
    }

    public ChallengeResultEntity(Long id, int correctAnswer, String time, int ranking) {
        this.id = id;
        this.correctAnswer = correctAnswer;
        this.time = time;
        this.ranking = ranking;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    @Override
    public String toString() {
        return "ChallengeResultEntity{" +
                "id=" + id +
                ", correctAnswer=" + correctAnswer +
                ", time='" + time + '\'' +
                ", ranking=" + ranking +
                '}';
    }
}
