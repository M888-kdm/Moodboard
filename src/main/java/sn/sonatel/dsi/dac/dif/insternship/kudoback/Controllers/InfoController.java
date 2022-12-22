package sn.sonatel.dsi.dac.dif.insternship.kudoback.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.DTOs.InfoDTO;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Service.InfoService;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/api/infos/")
public class InfoController {

    @Autowired
    InfoService infoService;

    @GetMapping("/get/latest")
    public ResponseEntity<List<InfoDTO>> getLastInfos(){
        return new ResponseEntity(infoService.getLastInfos(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createInfo(@RequestBody InfoDTO infoDTO){
        infoService.saveInfo(infoDTO);
        return new ResponseEntity(HttpStatus.CREATED);
    }

}
