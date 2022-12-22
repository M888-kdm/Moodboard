package sn.sonatel.dsi.dac.dif.insternship.kudoback.Controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.DTOs.GroupeChoDTO;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.DTOs.NoteDTO;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.DTOs.RoomieDTO;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Data.NoteTestData;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Data.RoomieTestData;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Service.GroupeCHOService;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Service.NoteService;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Service.RoomieService;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Utils.UrlMapping;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class NoteControllerIT extends BaseTest {

    @Autowired
    RoomieService roomieService;
    @Autowired
    NoteService noteService;
    @Autowired
    GroupeCHOService groupeCHOService;
    @Autowired
    MockMvc mvc;

    static NoteDTO noteDTO;
    static RoomieDTO roomieDTO;
    static GroupeChoDTO groupeChoDTO;
    static ObjectMapper mapper;

    @BeforeAll
    static void setUp(){
        noteDTO = NoteTestData.defaultDTO();
        noteDTO.setRoomieUsername(RoomieTestData.defaultDTO().getUsername());
        roomieDTO = RoomieTestData.defaultDTO();
        mapper = new ObjectMapper();
    }

    @BeforeEach
    void beforeEach(){
        roomieService.saveRoomie(roomieDTO);
        groupeChoDTO = groupeCHOService.createGroup();
        noteDTO.setGroupId(groupeChoDTO.getId());
    }

    @Test
    void createNoteShouldSucceed() throws Exception {
        mvc.perform(post(UrlMapping.Note.SAVE_NOTE)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsBytes(noteDTO)))
                .andExpect(status().isCreated());
    }

    @Test
    void getGroupNoteShouldReturnGroupNote() throws Exception{
        noteService.saveNote(noteDTO);
        mvc.perform(get(UrlMapping.Note.GET_GROUP_NOTE + "/" + groupeChoDTO.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", is(noteDTO.getValue())));
    }

    @Test
    void getAllNotesShouldReturnGroupNote() throws Exception{
        noteService.saveNote(noteDTO);
        mvc.perform(get(UrlMapping.Note.GET_ALL_NOTES + "/" + groupeChoDTO.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));
    }

}
