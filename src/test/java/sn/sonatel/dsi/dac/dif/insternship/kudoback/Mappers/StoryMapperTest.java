package sn.sonatel.dsi.dac.dif.insternship.kudoback.Mappers;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.DTOs.StoryDTO;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Data.RoomieTestData;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Data.StoryTestData;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Entities.Roomie;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Entities.Story;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Repositories.RoomieRepository;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Repositories.GenericTest;

import static org.assertj.core.api.Assertions.assertThat;

public class StoryMapperTest extends GenericTest {

    private Story story;
    private StoryDTO storyDTO;
    static Roomie roomie;

    @Autowired
    StoryDTOMapper storyDTOMapper;
    @Autowired
    RoomieRepository roomieRepository;

    @BeforeAll
    static void setUp(){
        roomie = RoomieTestData.defaultRoomie();
    }

    @BeforeEach
    public void beforeEach(){
        storyDTO = StoryTestData.defaultDTO();
        roomieRepository.save(roomie);
    }

    @Test
    public void testConvertStoryDTOToEntityShouldReturnCorrectEntity(){
        story = storyDTOMapper.ToEntity(storyDTO);
        assertThat(story)
                .isNotNull()
                .usingRecursiveComparison()
                .ignoringFields("roomie")
                .isEqualTo(storyDTO);
    }

    @Test
    public void testConvertStoryEntityToDTOShouldReturnCorrectEntity(){
        story = storyDTOMapper.ToEntity(storyDTO);
        storyDTO = storyDTOMapper.ToDTO(story);
        assertThat(storyDTO)
                .isNotNull()
                .usingRecursiveComparison()
                .ignoringFields("roomieUsername")
                .isEqualTo(story);
    }

}
