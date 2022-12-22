package sn.sonatel.dsi.dac.dif.insternship.kudoback.Mappers;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.DTOs.NoteDTO;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Data.GroupeCHOTestData;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Data.NoteTestData;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Data.RoomieTestData;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Entities.GroupeCHO;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Entities.Note;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Entities.Roomie;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Repositories.GroupeCHORepository;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Repositories.RoomieRepository;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Repositories.GenericTest;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class NoteMapperTest  extends GenericTest {

    NoteDTO noteDTO;
    Note note;
    static Roomie roomie;
    GroupeCHO groupeCHO;
    GroupeCHO group;
    @Autowired
    NoteDTOMapper noteDTOMapper;
    @Autowired
    RoomieRepository roomieRepository;
    @Autowired
    GroupeCHORepository groupeCHORepository;

    void arrange(){
        Roomie result = roomieRepository.save(roomie);
        Set chos = groupeCHO.getChos();
        chos.add(result);
        groupeCHO.setChos(chos);
        group = groupeCHORepository.save(groupeCHO);
        noteDTO.setGroupId(group.getId());
    }

    @BeforeAll
    static void setUp(){
        roomie = RoomieTestData.defaultRoomie();
    }

    @BeforeEach
    void beforeEach(){
        noteDTO = NoteTestData.defaultDTO();
        groupeCHO = GroupeCHOTestData.defaultCHOGroup();
        arrange();
    }

    @Test
    void convertNoteDTOToEntityShouldReturnCorrectEntity(){
        note = noteDTOMapper.ToEntity(noteDTO);

        assertThat(note)
                .isNotNull()
                .usingRecursiveComparison()
                .ignoringFields("roomie", "groupeCHO")
                .isEqualTo(noteDTO);

        assertThat(note.getRoomie())
                .isNotNull()
                .hasFieldOrPropertyWithValue("username", roomie.getUsername());

        assertThat(note.getGroupeCHO()).isNotNull();
    }

    @Test
    void convertNoteEntityToDTOShouldReturnCorrectDTO(){
        note = noteDTOMapper.ToEntity(noteDTO);
        noteDTO = noteDTOMapper.ToDTO(note);

        assertThat(noteDTO)
                .isNotNull()
                .usingRecursiveComparison()
                .ignoringFields("roomieUsername", "groupId")
                .isEqualTo(note);

        assertThat(noteDTO.getGroupId()).isEqualTo(group.getId());

        assertThat(noteDTO.getRoomieUsername()).isEqualTo(roomie.getUsername());
    }

}
