package sn.sonatel.dsi.dac.dif.insternship.kudoback.Services;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.DTOs.GroupeChoDTO;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.DTOs.RoomieDTO;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Data.GroupeCHOTestData;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Data.RoomieTestData;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Mappers.GroupeChoDTOMapper;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Repositories.GroupeCHORepository;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Repositories.GenericTest;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Service.GroupeCHOService;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Service.RoomieService;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class GroupeCHOServiceTest extends GenericTest {

    @Autowired
    GroupeCHOService groupeCHOService;
    @Autowired
    GroupeCHOService service;
    @Autowired
    GroupeCHORepository groupeCHORepository;
    @Autowired
    GroupeChoDTOMapper groupeChoDTOMapper;
    @Autowired
    RoomieService roomieService;

    static RoomieDTO roomieDTO;
    static RoomieDTO cho;

    @BeforeAll
    static void setUp(){
        roomieDTO = RoomieTestData.defaultDTO();
        cho = RoomieTestData.defaultCHO();
    }

    @Test
    void createGroupShouldSucceed(){
        for(int i=0; i<5; i++){
            RoomieDTO dto = RoomieTestData.defaultDTO();
            dto.setUsername("User " + Integer.toString(i));
            roomieService.saveRoomie(dto);
        }

        GroupeChoDTO groupeChoDTO = groupeCHOService.createGroup();

        assertThat(groupeChoDTO)
                .isNotNull();
    }

    @Test
    void getCurrentGroupShouldReturnCurrentGroup(){
        groupeCHORepository.save(groupeChoDTOMapper.asEntity(GroupeCHOTestData.testGroup()));
        GroupeChoDTO groupeChoDTO = groupeCHOService.getCurrentGroup();

        assertThat(groupeChoDTO)
                .isNotNull()
                .hasFieldOrPropertyWithValue("creationDate", GroupeCHOTestData.testGroup().getCreationDate());
    }

}
