package sn.sonatel.dsi.dac.dif.insternship.kudoback.Services;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.DTOs.InfoDTO;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Data.InfoTestData;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Data.RoomieTestData;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Entities.Info;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Entities.Roomie;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Mappers.InfoDTOMapper;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Repositories.RoomieRepository;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Repositories.GenericTest;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Service.InfoService;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class InfoServiceTest extends GenericTest {

    @Autowired
    InfoService infoService;
    @Autowired
    InfoDTOMapper infoDTOMapper;
    @Autowired
    RoomieRepository roomieRepository;

    static Roomie roomie;

    static InfoDTO infoDTO;
    Info info;

    @BeforeAll
    static void setUp(){
        roomie = RoomieTestData.defaultRoomie();
    }

    @BeforeEach
    void beforeEach(){
        roomieRepository.save(roomie);
        infoDTO = InfoTestData.defaultDTO();
        infoDTO.setRoomieUsername(roomie.getUsername());
    }

    @Test
    void saveInfoShouldSucceed(){
        InfoDTO dto = infoService.saveInfo(infoDTO);
        assertThat(dto)
                .isNotNull()
                .usingRecursiveComparison()
                .ignoringFields("id")
                .isEqualTo(infoDTO);
    }

    @Test
    void getLastInfosShouldReturnLastInfos(){
        infoService.saveInfo(infoDTO);
        List<InfoDTO> infos = infoService.getLastInfos();
        assertThat(infos).isNotEmpty().hasSize(1);
    }

}
