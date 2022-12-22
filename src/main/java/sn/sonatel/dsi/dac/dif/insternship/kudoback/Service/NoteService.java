package sn.sonatel.dsi.dac.dif.insternship.kudoback.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.DTOs.NoteDTO;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Entities.Note;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Mappers.NoteDTOMapper;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Repositories.GroupeCHORepository;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Repositories.NoteRepository;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Repositories.RoomieRepository;

import java.util.List;

@Service
public class NoteService {

    @Autowired
    NoteRepository noteRepository;
    @Autowired
    NoteDTOMapper noteDTOMapper;

    public NoteDTO saveNote(NoteDTO noteDTO){
        Note note = noteRepository.save(noteDTOMapper.ToEntity(noteDTO));
        return noteDTOMapper.ToDTO(note);
    }

    public List<NoteDTO> getAllNotes(Long group_id){
        return noteDTOMapper.ToDTOList(noteRepository.getAllNotes(group_id));
    }

    public Integer getGroupNote(Long group_id){
        return noteRepository.getGroupNote(group_id);
    }

}
