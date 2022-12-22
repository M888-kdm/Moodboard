package sn.sonatel.dsi.dac.dif.insternship.kudoback.Services;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.DTOs.NoteDTO;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Data.GroupeCHOTestData;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Data.NoteTestData;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Data.RoomieTestData;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Entities.GroupeCHO;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Entities.Roomie;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Repositories.GroupeCHORepository;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Repositories.RoomieRepository;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Repositories.GenericTest;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Service.NoteService;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NoteServiceTest extends GenericTest {

    @Autowired
    NoteService noteService;
    @Autowired
    RoomieRepository roomieRepository;
    @Autowired
    GroupeCHORepository groupeCHORepository;

    GroupeCHO group;

    static NoteDTO noteDTO;
    static Roomie roomie;
    static GroupeCHO groupeCHO;

    @BeforeAll
    static void setUp(){
        noteDTO = NoteTestData.defaultDTO();
        roomie = RoomieTestData.defaultRoomie();
        groupeCHO = GroupeCHOTestData.defaultCHOGroup();
    }

    @BeforeEach
    void beforeEach(){
        group = groupeCHORepository.save(groupeCHO);
        roomieRepository.save(roomie);
        noteDTO.setGroupId(group.getId());
    }

    @Test
    void saveNoteShouldSucceed(){
        NoteDTO dto = noteService.saveNote(noteDTO);

        assertThat(dto)
                .isNotNull()
                .hasFieldOrPropertyWithValue("roomieUsername", dto.getRoomieUsername())
                .usingRecursiveComparison()
                .ignoringFields("id")
                .isEqualTo(noteDTO);
    }

    @Test
    void getGroupNoteShouldReturnGroupNote(){
        NoteDTO dto = noteService.saveNote(noteDTO);
        Integer value = noteService.getGroupNote(dto.getGroupId());
        assertThat(value)
                .isEqualTo(dto.getValue());
    }

    @Test
    void getAllNotesShouldReturnAllNotes(){
        noteDTO.setGroupId(group.getId());
        noteDTO.setRoomieUsername(roomie.getUsername());
        noteService.saveNote(noteDTO);

        List<NoteDTO> allNotes = noteService.getAllNotes(group.getId());

        assertThat(allNotes)
                .isNotEmpty()
                .hasSize(1);
    }

}
