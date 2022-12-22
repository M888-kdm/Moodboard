package sn.sonatel.dsi.dac.dif.insternship.kudoback.Mappers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.DTOs.RoomieDTO;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Data.RoomieTestData;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Entities.Roomie;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RoomieMapperTest {

    RoomieDTO dto;
    Roomie roomie;

    private GenericMapper mapper = Mappers.getMapper(RoomieDTOMapper.class);

    @BeforeEach
    void setUp(){
        dto = RoomieTestData.defaultDTO();
    }

    @Test
    void testConvertRoomieEntityToDTOShouldReturnCorrect(){
        roomie = (Roomie)mapper.asEntity(dto);
        dto = (RoomieDTO) mapper.asDTO(roomie);
        assertThat(dto)
                .isNotNull()
                .usingRecursiveComparison()
                .ignoringFields("choGroups")
                .isEqualTo(roomie);
    }

    @Test
    void testConvertRoomieDtoToEntityShouldReturnCorrect(){
        roomie = (Roomie)mapper.asEntity(dto);
        assertThat(roomie)
                .isNotNull()
                .usingRecursiveComparison()
                .ignoringFields("choGroups")
                .isEqualTo(dto);
    }

    @Test
    void testConvertRoomieDTOListToEntityListShouldSucceed(){
        List<RoomieDTO> roomieDTOS = new ArrayList<>();
        roomieDTOS.add(dto);
        List<Roomie> roomies = mapper.asEntityList(roomieDTOS);

        assertThat(roomies).isNotNull().isNotEmpty().hasSize(1);
    }

    @Test
    void testConvertRoomieEntityListToDTOListShouldSucceed(){
        roomie = (Roomie)mapper.asEntity(dto);
        List<Roomie> roomies = new ArrayList<>();
        roomies.add(roomie);
        List<RoomieDTO> roomieDTOS = mapper.asDTOList(roomies);

        assertThat(roomieDTOS).isNotNull().isNotEmpty().hasSize(1);
    }

}
