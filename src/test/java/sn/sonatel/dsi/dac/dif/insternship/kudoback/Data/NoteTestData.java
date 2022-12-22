package sn.sonatel.dsi.dac.dif.insternship.kudoback.Data;

import sn.sonatel.dsi.dac.dif.insternship.kudoback.DTOs.NoteDTO;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Entities.Note;

import java.util.Random;

public class NoteTestData {

    public static final class Default{
        private static Long id = Double.doubleToLongBits(new Random().nextDouble());
        private static Integer value = 5;
        private static String comment = "Great Job Guys !!";
        private static String roomieUsername = RoomieTestData.defaultDTO().getUsername();
        private static Long groupId = GroupeCHOTestData.defaultGroup().getId();
    }

    public static final Note defaultNote(){

        Note note = new Note();

        note.setId(Default.id);
        note.setValue(Default.value);
        note.setComment(Default.comment);

        return note;

    }

    public static final NoteDTO defaultDTO(){

        NoteDTO dto = new NoteDTO();

        dto.setId(Default.id);
        dto.setValue(Default.value);
        dto.setComment(Default.comment);
        dto.setRoomieUsername(Default.roomieUsername);
        dto.setGroupId(null);

        return dto;
    }

}
