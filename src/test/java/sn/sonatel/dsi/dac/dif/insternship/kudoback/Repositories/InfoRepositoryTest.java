package sn.sonatel.dsi.dac.dif.insternship.kudoback.Repositories;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Data.InfoTestData;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Data.RoomieTestData;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Entities.Info;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Entities.Roomie;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Mappers.InfoDTOMapper;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class InfoRepositoryTest extends GenericTest {

    @Autowired
    InfoRepository infoRepository;
    @Autowired
    RoomieRepository roomieRepository;
    @Autowired
    InfoDTOMapper infoDTOMapper;

    static Roomie roomie;

    Info info;

    @BeforeAll
    static void setUp(){
        roomie = RoomieTestData.defaultRoomie();
    }

    @BeforeEach
    void beforeEach(){
        info = InfoTestData.defaultInfo();
    }

    @Test
    void getLastInfosShouldReturnLastInfos(){
        for(int i=0; i<7; i++)
            infoRepository.save(info);
        List<Info> infos = infoRepository.getLastInfos();

        assertThat(infos).isNotEmpty().hasSize(5);
    }

}
