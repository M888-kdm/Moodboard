package sn.sonatel.dsi.dac.dif.insternship.kudoback.Controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.DTOs.InfoDTO;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.DTOs.RoomieDTO;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Data.InfoTestData;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Data.RoomieTestData;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Service.InfoService;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Service.RoomieService;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Utils.UrlMapping;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class InfoControllerIT extends BaseTest {

    @Autowired
    MockMvc mvc;
    @Autowired
    InfoService infoService;
    @Autowired
    RoomieService roomieService;
    InfoDTO infoDTO;
    static RoomieDTO roomieDTO;
    static ObjectMapper mapper;
    @BeforeAll
    static void beforeAll(){
        roomieDTO = RoomieTestData.defaultDTO();
        roomieDTO.setIsCHO(true);
        mapper = new ObjectMapper();
    }

    @BeforeEach
    void beforeEach() {
        roomieService.saveRoomie(roomieDTO);
        infoDTO = InfoTestData.defaultDTO();
        infoDTO.setRoomieUsername(roomieDTO.getUsername());
    }

    @Test
    void getLatestInfosShouldReturnInfos() throws Exception {
        infoService.saveInfo(infoDTO);
        mvc.perform(get(UrlMapping.Info.GET_LATEST_INFOS))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$.[0].message", is(infoDTO.getMessage())));
    }

    @Test
    void saveInfosShouldSucceed() throws Exception {
        mvc.perform(post("/api/infos/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsBytes(infoDTO)))
                .andExpect(status().isCreated());
    }

}
