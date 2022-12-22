package sn.sonatel.dsi.dac.dif.insternship.kudoback.Mappers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.DTOs.GroupeChoDTO;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Data.GroupeCHOTestData;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Entities.GroupeCHO;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Repositories.GenericTest;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Service.RoomieService;

import static org.assertj.core.api.Assertions.assertThat;

public class GroupeChoMapperTest extends GenericTest {

    @Autowired
    static RoomieService roomieService;

    GroupeCHO groupeCHO;
    GroupeChoDTO groupeChoDTO;

    GroupeChoDTOMapper groupeChoDTOMapper = Mappers.getMapper(GroupeChoDTOMapper.class);

    @BeforeEach
    void beforeEach(){
        groupeChoDTO = GroupeCHOTestData.defaultGroup();
    }

    @Test
    void convertGroupDTOToEntityShouldReturnCorrectEntity(){
        groupeCHO = groupeChoDTOMapper.asEntity(groupeChoDTO);
        assertThat(groupeCHO)
                .isNotNull()
                .usingRecursiveComparison()
                .ignoringFields("id", "chos")
                .isEqualTo(groupeCHO);
    }

    @Test
    void convertGroupEntityToDTOShouldReturnCorrectDTO(){
        groupeCHO = groupeChoDTOMapper.asEntity(groupeChoDTO);
        groupeChoDTO = groupeChoDTOMapper.asDTO(groupeCHO);
        assertThat(groupeCHO)
                .isNotNull()
                .usingRecursiveComparison()
                .ignoringFields("id", "chos")
                .isEqualTo(groupeChoDTO);
    }

}
