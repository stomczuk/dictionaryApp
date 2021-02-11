package app.exchange.challenge;

import app.entity.ChallengeResultEntity;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ChallengeResultServiceTest {

    @Test
    public void convertRanking() {
        String time = "0:0:12:30";
        String time2 = "0:0:11:30";
        String time3 = "0:0:06:30";

    }

    @Test
    public void fetchPlaceInRanking() {
        List list = new ArrayList();
        list.add(new ChallengeResultEntity(1L, 3, "0:0:12:12", 0));
        list.add(new ChallengeResultEntity(1L, 5, "0:0:12:12", 0));
        list.add(new ChallengeResultEntity(1L, 3, "0:0:14:12", 0));
        list.add(new ChallengeResultEntity(1L, 23, "0:2:12:12", 0));
        list.add(new ChallengeResultEntity(1L, 8, "0:0:12:12", 0));
        list.add(new ChallengeResultEntity(1L, 3, "0:0:12:44", 0));
        list.add(new ChallengeResultEntity(1L, 6, "0:0:12:15", 0));
        list.add(new ChallengeResultEntity(1L, 5, "0:0:12:23", 0));
        list.add(new ChallengeResultEntity(1L, 5, "0:0:12:12", 0));
        list.add(new ChallengeResultEntity(1L, 5, "0:0:44:12", 0));
        list.add(new ChallengeResultEntity(1L, 3, "0:0:13:12", 0));
        list.add(new ChallengeResultEntity(1L, 2, "0:0:52:12", 0));
        list.add(new ChallengeResultEntity(1L, 3, "0:0:52:12", 0));

        Comparator<ChallengeResultEntity> comparator = Comparator.comparing(result -> result.getCorrectAnswer());
        Comparator<ChallengeResultEntity> comparatorReversed = comparator.reversed();
        comparator = comparatorReversed.thenComparing(result -> result.getTime());
        list.sort(comparator);
        list.forEach(o -> {
            System.out.println(o.toString());
        });
    }

    @Test
    public void getPlaceInRanking() {
        ChallengeResultEntity a = new ChallengeResultEntity(1L, 3, "00:00:10:21", 0);
        ChallengeResultEntity b = new ChallengeResultEntity(1L, 3, "00:00:10:21", 0);
        ChallengeResultEntity c = new ChallengeResultEntity(1L, 3, "00:00:10:21", 0);
        ChallengeResultEntity d = new ChallengeResultEntity(1L, 3, "00:00:10:21", 0);
        List list = new ArrayList();
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        System.out.println(list.indexOf(5));

    }
}
