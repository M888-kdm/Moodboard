package sn.sonatel.dsi.dac.dif.insternship.kudoback.Mappers;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.DTOs.MoodDTO;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Data.MoodTestData;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Data.RoomieTestData;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Entities.Mood;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Entities.Roomie;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Enumerations.MoodValue;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Repositories.RoomieRepository;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Repositories.GenericTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MoodMapperTest extends GenericTest {

    Mood mood;
    MoodDTO moodDTO;
    static Roomie roomie;
    @Autowired
    RoomieRepository roomieRepository;
    @Autowired
    MoodDTOMapper moodDTOMapper;

    @BeforeAll
    static void setUp(){
        roomie = RoomieTestData.defaultRoomie();
    }

    @BeforeEach
    public void beforeEach(){
        moodDTO = MoodTestData.defaultDTO();
        roomieRepository.save(roomie);
    }

    @Test
    public void convertMoodDtoToEntityShouldReturnCorrectEntity(){
        mood = moodDTOMapper.ToEntity(moodDTO);
        assertThat(mood)
                .isNotNull()
                .hasFieldOrPropertyWithValue("value", MoodValue.NEUTRAL)
                .hasFieldOrPropertyWithValue("date", moodDTO.getDate());
        assertThat(mood.getRoomie())
                .isNotNull()
                .hasFieldOrPropertyWithValue("username", roomie.getUsername());
    }

    @Test
    public void convertMoodEntityToDtoShouldReturnCorrectDto(){
        mood = (Mood) moodDTOMapper.ToEntity(moodDTO);
        moodDTO = (MoodDTO)moodDTOMapper.ToDTO(mood);

        assertThat(moodDTO)
                .isNotNull()
                .hasFieldOrPropertyWithValue("value", MoodTestData.defaultDTO().getValue());
    }

}
