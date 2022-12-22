package sn.sonatel.dsi.dac.dif.insternship.kudoback.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.DTOs.MoodDTO;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Service.MoodService;

@RestController
@RequestMapping("/api/moods/")
public class MoodController {

    @Autowired
    MoodService moodService;

    @PostMapping
    public ResponseEntity saveMood(@RequestBody MoodDTO moodDTO){
        moodService.saveMood(moodDTO);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/{username}")
    public ResponseEntity<MoodDTO> getMoodOfRoomie(@PathVariable String username){
        MoodDTO moodDTO = moodService.getMoodOfRoomie(username);
        return new ResponseEntity<>(moodDTO, HttpStatus.OK);
    }

}
