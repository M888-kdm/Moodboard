package sn.sonatel.dsi.dac.dif.insternship.kudoback.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.DTOs.GroupeChoDTO;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.DTOs.RoomieDTO;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Entities.GroupeCHO;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Entities.Roomie;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Mappers.GroupeChoDTOMapper;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Mappers.RoomieDTOMapper;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Repositories.GroupeCHORepository;

import java.util.HashSet;
import java.util.List;

@Service
public class GroupeCHOService {
    @Autowired
    GroupeCHORepository groupeCHORepository;
    @Autowired
    GroupeChoDTOMapper groupeChoDTOMapper;
    @Autowired
    RoomieDTOMapper roomieDTOMapper;
    @Autowired
    RoomieService roomieService;

    public GroupeChoDTO createGroup(){
        // Create the group
        GroupeCHO group = groupeCHORepository.save(new GroupeCHO());

        // Get the roomies for CHO duty
        List<RoomieDTO> choDtoList = roomieService.getWeeklyCHOs();
        List<Roomie> chos = roomieDTOMapper.asEntityList(choDtoList);

        // Set the chos for the group
        group.setChos(new HashSet<>(chos));

        // Change the state of each chosen roomie
        for(RoomieDTO cho: choDtoList){
            roomieService.setRoomieAsCho(cho.getUsername());
        }

        group = groupeCHORepository.save(group);
        return groupeChoDTOMapper.asDTO(group);
    }

    public GroupeChoDTO getCurrentGroup(){
        return groupeChoDTOMapper.asDTO(groupeCHORepository.getCurrentGroup());
    }

}
