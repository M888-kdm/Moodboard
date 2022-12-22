package sn.sonatel.dsi.dac.dif.insternship.kudoback.Controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.DTOs.MoodDTO;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.DTOs.RoomieDTO;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Data.MoodTestData;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Data.RoomieTestData;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Service.MoodService;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Service.RoomieService;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Utils.UrlMapping;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class MoodControllerIT extends BaseTest {

    @Autowired
    MockMvc mvc;
    @Autowired
    RoomieService roomieService;
    @Autowired
    MoodService moodService;
    MoodDTO moodDTO;
    static RoomieDTO roomieDTO;
    static ObjectMapper mapper;

    @BeforeAll
    static void setUp(){
        roomieDTO = RoomieTestData.defaultDTO();
        mapper = new ObjectMapper();
    }

    @BeforeEach
    void beforeEach(){
        moodDTO = MoodTestData.defaultDTO();
        moodDTO.setRoomieUsername(roomieDTO.getUsername());
    }

    @Test
    void getRoomieMoodShouldReturnCorrectMood() throws Exception{
        roomieService.saveRoomie(roomieDTO);
        moodService.saveMood(moodDTO);
        mvc.perform(get(UrlMapping.Mood.GET_ROOMIE_MOOD + "/" + roomieDTO.getUsername()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.roomieUsername", is(roomieDTO.getUsername())))
                .andExpect(jsonPath("$.value", is(moodDTO.getValue())));
    }

    @Test
    void createMoodShouldSucceed() throws Exception{
        mvc.perform(post("/api/moods/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsBytes(moodDTO)))
                .andExpect(status().isCreated());
    }

}
