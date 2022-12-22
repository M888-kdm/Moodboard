package sn.sonatel.dsi.dac.dif.insternship.kudoback.Controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.DTOs.KudoDTO;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.DTOs.RoomieDTO;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Data.KudoTestData;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Data.RoomieTestData;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Service.KudoService;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Service.RoomieService;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Utils.UrlMapping;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class KudoControllerIT extends BaseTest{

    @Autowired
    KudoService kudoService;
    @Autowired
    RoomieService roomieService;
    @Autowired
    MockMvc mvc;

    RoomieDTO sender;
    RoomieDTO receiver;
    static KudoDTO kudoDTO;
    static ObjectMapper mapper;

    @BeforeAll
    static void setUp(){
        kudoDTO = KudoTestData.defaultDTO();
        mapper = new ObjectMapper();
    }

    @BeforeEach
    void beforeEach(){
        sender = RoomieTestData.defaultDTO();
        receiver = RoomieTestData.defaultDTO();
        sender.setUsername("Sender");
        receiver.setUsername("Receiver");
        roomieService.saveRoomie(sender);
        roomieService.saveRoomie(receiver);
        kudoDTO.setSender(sender.getUsername());
        kudoDTO.setReceiver(receiver.getUsername());
    }

    @Test
    void createKudoShouldSucceed() throws Exception{
        mvc.perform(post(UrlMapping.Kudo.CREATE_KUDO)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsBytes(kudoDTO)))
                .andExpect(status().isCreated());
    }

    @Test
    void getAllKudosShouldReturnAllKudos() throws Exception{
        kudoService.createKudo(kudoDTO);

        mvc.perform(get(UrlMapping.Kudo.GET_ALL_KUDOS))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$.[0].sender", is(kudoDTO.getSender())))
                .andExpect(jsonPath("$.[0].receiver", is(kudoDTO.getReceiver())))
                .andExpect(jsonPath("$.[0].message", is(kudoDTO.getMessage())));
    }

}
