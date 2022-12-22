package sn.sonatel.dsi.dac.dif.insternship.kudoback.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.DTOs.NoteDTO;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Service.NoteService;

import java.util.List;

@RestController
@RequestMapping("api/notes/")
public class NoteController {

    @Autowired
    NoteService noteService;

    @PostMapping
    public ResponseEntity saveNote(@RequestBody NoteDTO noteDTO){
        noteService.saveNote(noteDTO);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/group/{groupId}")
    public ResponseEntity getGroupNote(@PathVariable("groupId") Long groupId){
        Integer note = noteService.getGroupNote(groupId);
        return new ResponseEntity(note, HttpStatus.OK);
    }

    @GetMapping("/group/all/{groupId}")
    public ResponseEntity getAllNotes(@PathVariable("groupId") Long groupId){
        List<NoteDTO> notes = noteService.getAllNotes(groupId);
        return new ResponseEntity(notes, HttpStatus.OK);
    }

}
