package sn.sonatel.dsi.dac.dif.insternship.kudoback.Scheduled;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.DTOs.RoomieDTO;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Service.GroupeCHOService;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Service.RoomieService;

import java.util.List;

public class Tasks {

    @Autowired
    GroupeCHOService groupeCHOService;

    @Autowired
    RoomieService roomieService;

    @Scheduled(cron = "0 0 0 * * SUN")
    public void chooseChos(){
        List<RoomieDTO> chos = roomieService.getCurrentChos();

        if(!chos.isEmpty()){
            for(RoomieDTO cho: chos)
                roomieService.endChoService(cho.getUsername());
        }

        groupeCHOService.createGroup();
    }

}
