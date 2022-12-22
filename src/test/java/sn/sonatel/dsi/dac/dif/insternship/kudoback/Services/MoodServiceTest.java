package sn.sonatel.dsi.dac.dif.insternship.kudoback.Services;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.DTOs.MoodDTO;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Data.MoodTestData;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Data.RoomieTestData;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Entities.Roomie;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Mappers.MoodDTOMapper;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Repositories.RoomieRepository;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Repositories.GenericTest;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Service.MoodService;

import static org.assertj.core.api.Assertions.assertThat;

public class MoodServiceTest extends GenericTest {

    @Autowired
    MoodService moodService;
    @Autowired
    RoomieRepository roomieRepository;
    @Autowired
    MoodDTOMapper moodDTOMapper;
    static Roomie roomie;
    static MoodDTO moodDTO;

    @BeforeAll
    static void setUp(){
        roomie = RoomieTestData.defaultRoomie();
    }

    @BeforeEach
    void beforeEach(){
        roomieRepository.save(roomie);
        moodDTO = MoodTestData.defaultDTO();
        moodDTO.setRoomieUsername(roomie.getUsername());
    }

    @Test
    void saveMoodShouldSucceed(){
        MoodDTO dto = moodService.saveMood(moodDTO);
        assertThat(dto)
                .isNotNull()
                .usingRecursiveComparison()
                .ignoringFields("id")
                .isEqualTo(moodDTO);
    }

    @Test
    void getMoodCountForCurrentDate(){
       moodService.saveMood(moodDTO);
       Integer count = moodService.getMoodCountForCurrentDate(moodDTO.getValue());
       assertThat(count).isEqualTo(1);
    }

    @Test
    void getMoodCountForCurrentWeek(){
        moodService.saveMood(moodDTO);
        Integer count = moodService.getMoodCountForCurrentWeek(moodDTO.getValue());
        assertThat(count).isEqualTo(1);
    }

}
