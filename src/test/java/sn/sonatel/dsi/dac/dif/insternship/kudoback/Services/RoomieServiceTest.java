package sn.sonatel.dsi.dac.dif.insternship.kudoback.Services;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.DTOs.RoomieDTO;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Data.RoomieTestData;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Mappers.RoomieDTOMapper;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Repositories.GenericTest;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Service.GroupeCHOService;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Service.RoomieService;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.List;

class RoomieServiceTest extends GenericTest {

    @Autowired
    RoomieService roomieService;
    @Autowired
    GroupeCHOService groupeCHOService;
    @Autowired
    RoomieDTOMapper roomieDTOMapper;

    static RoomieDTO roomieDTO;

    @BeforeAll
    static void setUp(){
        roomieDTO = RoomieTestData.defaultDTO();
    }

    @Test
    void saveRoomieShouldSucceed(){
        RoomieDTO dto = roomieService.saveRoomie(roomieDTO);
        assertThat(dto)
                .isNotNull()
                .hasFieldOrPropertyWithValue("username", roomieDTO.getUsername());
    }

    @Test
    void getWeeklyChosShouldReturnChos(){
        for(int i = 0; i<5; i++)
            roomieService.saveRoomie(roomieDTO);
        List<RoomieDTO> chos = roomieService.getWeeklyCHOs();
        assertThat(chos).isNotEmpty().hasSize(3);
    }

    @Test
    void getRoomieByUsernameShouldReturnCorrectUser(){
        roomieService.saveRoomie(roomieDTO);
        RoomieDTO dto  = roomieService.getRoomieByUsername(roomieDTO.getUsername());
        assertThat(dto)
                .isNotNull()
                .hasFieldOrPropertyWithValue("username", roomieDTO.getUsername());
    }

    @Test
    void getRoomieByUsernameWithBadUsernameShouldReturnNull(){
        RoomieDTO dto  = roomieService.getRoomieByUsername(roomieDTO.getUsername());
        assertThat(dto).isNull();
    }

    @Test
    void setRoomieAsChoShouldSucceed(){
        roomieService.saveRoomie(roomieDTO);
        roomieService.setRoomieAsCho(roomieDTO.getUsername());
        RoomieDTO dto = roomieService.getRoomieByUsername(roomieDTO.getUsername());
        assertThat(dto)
                .isNotNull()
                .hasFieldOrPropertyWithValue("isCHO", true);
    }

    @Test
    void getCurrentChosShouldSucceed(){
        for(int i=0; i<5; i++){
            RoomieDTO dto = RoomieTestData.defaultDTO();
            dto.setUsername("User " + Integer.toString(i));
            roomieService.saveRoomie(dto);
        }

        groupeCHOService.createGroup();

        List<RoomieDTO> chos = roomieService.getCurrentChos();

        assertThat(chos)
                .isNotNull()
                .hasSize(3);
    }


}
