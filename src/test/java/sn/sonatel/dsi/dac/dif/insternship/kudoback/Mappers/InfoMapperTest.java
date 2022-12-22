package sn.sonatel.dsi.dac.dif.insternship.kudoback.Mappers;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.DTOs.InfoDTO;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Data.InfoTestData;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Data.RoomieTestData;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Entities.Info;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Entities.Roomie;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Repositories.RoomieRepository;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Repositories.GenericTest;

import static org.assertj.core.api.Assertions.assertThat;

public class InfoMapperTest extends GenericTest {

    Info info;
    InfoDTO infoDTO;
    static Roomie roomie;
    @Autowired
    InfoDTOMapper infoDTOMapper;
    @Autowired
    RoomieRepository roomieRepository;

    @BeforeAll
    static void setUp(){
        roomie = RoomieTestData.defaultRoomie();
    }

    @BeforeEach
    void beforeEach(){
        infoDTO = InfoTestData.defaultDTO();
        infoDTO.setRoomieUsername(roomie.getUsername());
    }

    @Test
    public void testConvertInfoDTOToEntityShouldReturnCorrectEntity(){
        roomieRepository.save(roomie);
        info = infoDTOMapper.ToEntity(infoDTO);

        assertThat(info)
                .isNotNull()
                .usingRecursiveComparison()
                .ignoringFields("roomie")
                .isEqualTo(infoDTO);

        assertThat(info.getRoomie())
                .isNotNull()
                .usingRecursiveComparison()
                .ignoringFields("id")
                .isEqualTo(roomie);
    }

    @Test
    public void testConvertInfoEntityToDTOShouldReturnCorrectDTO(){
        roomieRepository.save(roomie);
        info = infoDTOMapper.ToEntity(infoDTO);
        infoDTO = infoDTOMapper.ToDTO(info);

        assertThat(infoDTO)
                .isNotNull()
                .usingRecursiveComparison()
                .ignoringFields("roomieUsername")
                .isEqualTo(info);

        assertThat(infoDTO.getRoomieUsername())
                .isEqualTo(roomie.getUsername());
    }

}
