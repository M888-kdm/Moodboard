package sn.sonatel.dsi.dac.dif.insternship.kudoback.Repositories;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Data.GroupeCHOTestData;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Data.NoteTestData;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Entities.GroupeCHO;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Entities.Note;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NoteRepositoryTest extends GenericTest{

    @Autowired
    NoteRepository noteRepository;
    @Autowired
    GroupeCHORepository groupeCHORepository;

    Note note;
    Note note_alt;
    static GroupeCHO groupeCHO;

    @BeforeAll
    static void setUp(){
        groupeCHO = GroupeCHOTestData.defaultCHOGroup();
    }

    @BeforeEach
    void beforeEach(){
        note = NoteTestData.defaultNote();

    }

    @Test
    void saveNoteShouldSucceed(){
        Note result = noteRepository.save(note);
        assertThat(result)
                .isNotNull()
                .usingRecursiveComparison()
                .ignoringFields("id")
                .isEqualTo(note);
    }

    @Test
    void getGroupNoteShouldSucceed(){
        GroupeCHO saved = groupeCHORepository.save(groupeCHO);
        note.setGroupeCHO(saved);
        noteRepository.save(note);
        note_alt = NoteTestData.defaultNote();
        note_alt.setValue(3);
        note_alt.setGroupeCHO(saved);
        noteRepository.save(note_alt);

        Integer mean = noteRepository.getGroupNote(saved.getId());

        assertThat(mean)
                .isEqualTo(4);
    }

    @Test
    void getAllNotesShouldReturnAllNotes(){
        noteRepository.save(note);
        GroupeCHO saved = groupeCHORepository.save(groupeCHO);
        note.setGroupeCHO(saved);
        noteRepository.save(note);

        List<Note> notes = noteRepository.getAllNotes(saved.getId());

        assertThat(notes)
                .isNotEmpty()
                .hasSize(1);
    }

}
