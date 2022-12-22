package sn.sonatel.dsi.dac.dif.insternship.kudoback.Data;

import sn.sonatel.dsi.dac.dif.insternship.kudoback.DTOs.GroupeChoDTO;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.DTOs.RoomieDTO;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Entities.GroupeCHO;

import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class GroupeCHOTestData {

    public static final GroupeChoDTO defaultGroup(){
        GroupeChoDTO dto = new GroupeChoDTO();
        dto.setId(Default.id);
        dto.setCreationDate(Default.date);

        return dto;
    }

    public static final GroupeChoDTO testGroup(){
        GroupeChoDTO dto = defaultGroup();

        return dto;
    }

    public static final class Default{
        public static final Long id = Double.doubleToLongBits(new Random().nextDouble());
        public static final Date date = Date.from(Instant.now());
        public static final Set<RoomieDTO> chos = new HashSet<RoomieDTO>(){{
            for(int i=0; i<3; i++)
                add(RoomieTestData.defaultDTO());
        }};
    }

    public static final GroupeCHO defaultCHOGroup(){
        GroupeCHO group = new GroupeCHO();

        group.setId(Default.id);
        group.setCreationDate(Default.date);
        group.setChos(new HashSet<>());

        return group;
    }

}
