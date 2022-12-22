package sn.sonatel.dsi.dac.dif.insternship.kudoback.Repositories;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Data.GroupeCHOTestData;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Entities.GroupeCHO;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Mappers.GroupeChoDTOMapper;

import static org.assertj.core.api.Assertions.assertThat;

public class GroupeChoRepositoryTest extends GenericTest{

    @Autowired
    GroupeCHORepository groupeCHORepository;
    @Autowired
    GroupeChoDTOMapper groupeChoDTOMapper;
    static GroupeCHO groupeCHO;

    @BeforeAll
    static void setUp(){
        groupeCHO = GroupeCHOTestData.defaultCHOGroup();
    }

    @Test
    void getCurrentGroupShouldReturnCurrentGroup(){
        groupeCHORepository.save(groupeCHO);
        GroupeCHO group = groupeCHORepository.getCurrentGroup();
        assertThat(group)
                .isNotNull()
                .hasFieldOrPropertyWithValue("creationDate", groupeCHO.getCreationDate());
    }

}
