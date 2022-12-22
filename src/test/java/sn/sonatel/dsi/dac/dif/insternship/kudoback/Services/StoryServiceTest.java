package sn.sonatel.dsi.dac.dif.insternship.kudoback.Services;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.DTOs.StoryDTO;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Data.RoomieTestData;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Data.StoryTestData;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Entities.Roomie;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Mappers.StoryDTOMapper;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Repositories.RoomieRepository;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Repositories.GenericTest;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Service.StoryService;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StoryServiceTest extends GenericTest {

    @Autowired
    StoryService storyService;
    @Autowired
    StoryDTOMapper storyDTOMapper;
    @Autowired
    RoomieRepository roomieRepository;

    static StoryDTO storyDTO;
    static Roomie roomie;

    @BeforeAll
    static void setUp(){
        storyDTO = StoryTestData.defaultDTO();
        roomie = RoomieTestData.defaultRoomie();
    }

    @BeforeEach
    void beforeEach(){
        roomieRepository.save(roomie);
    }

    @Test
    void saveStoryShouldSucceed(){
        StoryDTO dto = storyService.saveStory(storyDTO);
        assertThat(dto)
                .isNotNull()
                .hasFieldOrPropertyWithValue("url", storyDTO.getUrl());
    }

    @Test
    void getDailyStoriesShouldReturnDailyStories(){
        storyService.saveStory(storyDTO);
        List<StoryDTO> stories = storyService.getDailyStories();
        assertThat(stories)
                .isNotEmpty()
                .hasSize(1);
    }

}
