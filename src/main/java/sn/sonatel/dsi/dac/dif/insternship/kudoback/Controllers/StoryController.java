package sn.sonatel.dsi.dac.dif.insternship.kudoback.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.DTOs.StoryDTO;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Service.StoryService;

import java.util.List;

@RestController
@RequestMapping("api/stories/")
public class StoryController {

    @Autowired
    StoryService storyService;

    @PostMapping
    public ResponseEntity saveStory(@RequestBody StoryDTO storyDTO){
        storyService.saveStory(storyDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getDailyStories(){
        List<StoryDTO> dailyStories = storyService.getDailyStories();
        return new ResponseEntity<>(dailyStories, HttpStatus.OK);
    }


}
