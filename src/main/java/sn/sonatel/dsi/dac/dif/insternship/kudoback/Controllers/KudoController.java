package sn.sonatel.dsi.dac.dif.insternship.kudoback.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.DTOs.KudoDTO;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Service.KudoService;

import java.util.List;

@RestController
@RequestMapping("api/kudos/")
public class KudoController {

    @Autowired
    KudoService kudoService;

    @PostMapping
    public ResponseEntity createKudo(@RequestBody KudoDTO kudoDTO){
        kudoService.createKudo(kudoDTO);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<KudoDTO>> getAllKudos(){
        List<KudoDTO> kudos = kudoService.getAllKudos();
        return new ResponseEntity<>(kudos, HttpStatus.OK);
    }

}
