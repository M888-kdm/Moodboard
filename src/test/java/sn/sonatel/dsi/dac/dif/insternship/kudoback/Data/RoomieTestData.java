package sn.sonatel.dsi.dac.dif.insternship.kudoback.Data;

import sn.sonatel.dsi.dac.dif.insternship.kudoback.DTOs.RoomieDTO;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Entities.Roomie;

import java.util.Date;
import java.util.Random;

public class RoomieTestData {

    public static final RoomieDTO defaultDTO(){

        RoomieDTO dto = new RoomieDTO();

        dto.setId(Default.id);
        dto.setUsername(Default.username);
        dto.setJob(Default.job);
        dto.setPlateau(Default.plateau);
        dto.setFullName(Default.fullName);
        dto.setLastService(Default.lastService);
        dto.setIsCHO(Default.isCho);

        return dto;
    }

    public static final RoomieDTO defaultCHO(){
        RoomieDTO cho = defaultDTO();
        cho.setIsCHO(true);
        return cho;
    }

    public static final Roomie defaultRoomie(){

        Roomie roomie = new Roomie();

        roomie.setUsername(Default.username);
        roomie.setId(Default.id);
        roomie.setJob(Default.job);
        roomie.setPlateau(Default.plateau);
        roomie.setLastService(Default.lastService);
        roomie.setIsCHO(Default.isCho);
        roomie.setFullName(Default.fullName);
        roomie.setChoGroups(null);

        return roomie;
    }

    public static final class Default{

        public static final Long id = Double.doubleToLongBits(new Random().nextDouble());
        public static final String username = "Khadim";
        public static final String fullName = "Khadim Diop";
        public static final String plateau = "B2C";
        public static final String job = "Developpeur";
        public static final Boolean isCho = false;
        public static final Date lastService = null;

    }


}
