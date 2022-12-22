package sn.sonatel.dsi.dac.dif.insternship.kudoback.Mappers;

import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Entities.Roomie;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Repositories.RoomieRepository;

public abstract class RoomieTransformer {

    @Autowired
    RoomieRepository roomieRepository;

    @Named("usernameToRoomie")
    public Roomie usernameToRoomie(String username){
        return roomieRepository.getRoomieByUsername(username);
    }

    @Named("roomieToUsername")
    public String roomieToUsername(Roomie roomie){
        return roomie.getUsername();
    }

}
