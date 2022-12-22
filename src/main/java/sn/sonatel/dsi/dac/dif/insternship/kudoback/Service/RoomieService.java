package sn.sonatel.dsi.dac.dif.insternship.kudoback.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.DTOs.RoomieDTO;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Entities.Roomie;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Mappers.RoomieDTOMapper;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Repositories.RoomieRepository;

import java.util.List;

@Service
public class RoomieService {

    @Autowired
    RoomieRepository roomieRepository;
    @Autowired
    RoomieDTOMapper roomieDTOMapper;

    public RoomieDTO saveRoomie(RoomieDTO roomieDTO){

        Roomie found;
        Roomie result;

        found = roomieRepository.getRoomieByUsername(roomieDTO.getUsername());

        if(found != null){
            Roomie roomie = roomieDTOMapper.asEntity(roomieDTO);
            roomie.setChoGroups(found.getChoGroups());
            result = roomieRepository.save(roomie);
        }
        else{
            Roomie roomie = roomieDTOMapper.asEntity(roomieDTO);
            result = roomieRepository.save(roomie);
        }

        return roomieDTOMapper.asDTO(result);
    }

    public List<RoomieDTO> getWeeklyCHOs(){
        List<Roomie> chos = roomieRepository.getWeeklyChosFromUnenrolledRoomies();
        if(chos.size() < 3){
            int remainder = 3 - chos.size();
            chos.addAll(roomieRepository.getWeeklyCHOsFromEnrolledRoomies(remainder));
        }
        return roomieDTOMapper.asDTOList(chos);
    }

    public RoomieDTO getRoomieByUsername(String username){
        return roomieDTOMapper.asDTO(roomieRepository.getRoomieByUsername(username));
    }

    public RoomieDTO setRoomieAsCho(String username){
        Roomie roomie = roomieRepository.getRoomieByUsername(username);
        roomie.setIsCHO(true);
        roomieRepository.save(roomie);

        return roomieDTOMapper.asDTO(roomie);
    }

    public RoomieDTO endChoService(String username){
        Roomie roomie = roomieRepository.getRoomieByUsername(username);
        roomie.setIsCHO(false);
        roomieRepository.save(roomie);

        return roomieDTOMapper.asDTO(roomie);
    }

    public List<RoomieDTO> getCurrentChos(){
        List<Roomie> chos = roomieRepository.getCurrentChos();
        return roomieDTOMapper.asDTOList(chos);
    }

}
