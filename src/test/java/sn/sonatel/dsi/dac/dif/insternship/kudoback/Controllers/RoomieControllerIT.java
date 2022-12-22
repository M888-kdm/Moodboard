package sn.sonatel.dsi.dac.dif.insternship.kudoback.Controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.DTOs.RoomieDTO;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Data.RoomieTestData;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Service.RoomieService;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Utils.UrlMapping;

public class RoomieControllerIT extends BaseTest {

    @Autowired
    MockMvc mvc;
    @Autowired
    RoomieService roomieService;
    static ObjectMapper mapper;
    RoomieDTO roomieDTO;

    @BeforeAll
    static void setUp(){
        mapper = new ObjectMapper();
    }

    @BeforeEach
    void beforeEach(){
        roomieDTO = RoomieTestData.defaultDTO();
    }

    @Test
    void getCurrentChosShouldReturnCurrentChos() throws Exception{
        roomieDTO.setIsCHO(true);
        roomieService.saveRoomie(roomieDTO);
        mvc.perform(get("/api/roomies/chos/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].id").exists())
                .andExpect(jsonPath("$.[0].username", is(roomieDTO.getUsername() + "/")))
                .andExpect(jsonPath("$.[0].fullName", is(roomieDTO.getFullName())))
                .andExpect(jsonPath("$.[0].plateau", is(roomieDTO.getPlateau())))
                .andExpect(jsonPath("$.[0].isCHO", is(roomieDTO.getIsCHO())));
    }

    @Test
    void getRoomieByUsernameShouldReturnRoomie() throws Exception{
        roomieService.saveRoomie(roomieDTO);
        mvc.perform(get(UrlMapping.Roomie.FIND_BY_USERNAME + "/" + roomieDTO.getUsername()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.username", is(roomieDTO.getUsername())))
                .andExpect(jsonPath("$.fullName", is(roomieDTO.getFullName())))
                .andExpect(jsonPath("$.plateau", is(roomieDTO.getPlateau())))
                .andExpect(jsonPath("$.isCHO", is(roomieDTO.getIsCHO())));
    }

    @Test
    void saveRoomieShouldSucceed() throws Exception{
        mvc.perform(post(UrlMapping.Roomie.base + "/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsBytes(roomieDTO))
        ).andExpect(status().isCreated());
    }

}
