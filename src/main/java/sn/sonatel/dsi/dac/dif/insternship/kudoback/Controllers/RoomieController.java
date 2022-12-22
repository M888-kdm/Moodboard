package sn.sonatel.dsi.dac.dif.insternship.kudoback.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.DTOs.RoomieDTO;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Service.RoomieService;
@RestController
@RequestMapping("api/roomies/")
public class RoomieController {

    @Autowired
    RoomieService roomieService;

    @PostMapping
    public ResponseEntity saveRoomie(@RequestBody RoomieDTO roomieDTO){
        roomieService.saveRoomie(roomieDTO);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/chos")
    public ResponseEntity getWeeklyCHOs(){
        return new ResponseEntity(roomieService.getCurrentChos(), HttpStatus.OK);
    }

    @GetMapping("/get/{username}")
    public ResponseEntity getRoomieByUsername(@PathVariable String username){
        return new ResponseEntity(roomieService.getRoomieByUsername(username), HttpStatus.OK);
    }

}
