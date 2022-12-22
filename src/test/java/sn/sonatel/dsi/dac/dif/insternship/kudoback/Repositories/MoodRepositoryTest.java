package sn.sonatel.dsi.dac.dif.insternship.kudoback.Repositories;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Data.MoodTestData;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Entities.Mood;

import static org.assertj.core.api.Assertions.assertThat;

public class MoodRepositoryTest extends GenericTest {

    @Autowired
    private MoodRepository moodRepository;

    private Mood mood;

    @BeforeAll
    static void setUp(){

    }

    @BeforeEach
    void beforeEach(){
        mood = MoodTestData.defaultMood();
    }

    @Test
    void saveMoodShouldSucceed(){
        Mood result = moodRepository.save(mood);
        assertThat(result)
                .isNotNull()
                .usingRecursiveComparison()
                .ignoringFields("id")
                .isEqualTo(result);
    }

    @Test
    void getMoodCountForCurrentDay(){
        moodRepository.save(mood);
        Integer count = moodRepository.getMoodCountForCurrentDay(MoodTestData.Default.moodString);
        assertThat(count).isEqualTo(1);
    }

    @Test
    void getMoodCountForCurrentWeek(){
        moodRepository.save(mood);
        Integer count = moodRepository.getMoodCountForCurrentWeek(MoodTestData.Default.moodString);
        assertThat(count).isEqualTo(1);
    }

}
