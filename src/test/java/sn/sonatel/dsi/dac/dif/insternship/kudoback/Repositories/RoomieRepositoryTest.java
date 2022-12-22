package sn.sonatel.dsi.dac.dif.insternship.kudoback.Repositories;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.DTOs.RoomieDTO;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Data.RoomieTestData;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Entities.Roomie;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Mappers.RoomieDTOMapper;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.List;

public class RoomieRepositoryTest extends GenericTest {

    @Autowired
    private RoomieRepository roomieRepository;
    @Autowired
    private RoomieDTOMapper roomieDTOMapper = Mappers.getMapper(RoomieDTOMapper.class);

    private List<Roomie> roomies;
    private static RoomieDTO roomieDTO;
    private Roomie roomie;

    @BeforeAll
    static void setUp(){
        roomieDTO = RoomieTestData.defaultDTO();
    }

    @BeforeEach
    void beforeEach(){
        roomie = roomieDTOMapper.asEntity(roomieDTO);
    }

    @Test
    void getWeeklyChosFromUnenrolledRoomiesShouldReturnWeeklyChos(){
        for(int i=0; i<5; i++)
            roomieRepository.save(roomie);
        roomies = roomieRepository.getWeeklyChosFromUnenrolledRoomies();
        assertThat(roomies).isNotNull().isNotEmpty().hasSize(3);
    }

    @Test
    void getWeeklyChosFromEnrolledRoomiesShouldReturnWeeklyChos(){
        roomie.setLastService(new Date(2020, 10, 10));
        for(int i=0; i<5; i++)
            roomieRepository.save(roomie);
        roomies = roomieRepository.getWeeklyCHOsFromEnrolledRoomies(2);

        assertThat(roomies).isNotEmpty().hasSize(2);
    }

    @Test
    void getWeeklyChosFromEnrolledRoomiesWhenNoneIsEnrolledShouldReturnEmpty(){
        roomie.setLastService(new Date(2020, 10, 10));
        roomieRepository.save(roomie);
        roomies = roomieRepository.getWeeklyChosFromUnenrolledRoomies();

        assertThat(roomies).isEmpty();
    }

    @Test
    void getWeekLyChosFromUnenrolledRoomiesWhenAllAreEnrolledShouldReturnEmptyResult(){
        roomieRepository.save(roomie);
        roomies = roomieRepository.getWeeklyCHOsFromEnrolledRoomies(2);

        assertThat(roomies).isEmpty();
    }

    @Test
    void findByUsernameShouldReturnResult(){
        roomieRepository.save(roomie);
        Roomie result = roomieRepository.getRoomieByUsername(roomie.getUsername());

        assertThat(result)
                .isNotNull()
                .hasFieldOrPropertyWithValue("username", roomie.getUsername());
    }

    @Test
    void findByUsernameWithBadUsernameShouldReturnEmpty(){
        Roomie result = roomieRepository.getRoomieByUsername(roomie.getUsername());
        assertThat(result).isNull();
    }

    @Test
    void getCurrentChosShouldReturnCurrentChos(){
        RoomieDTO choDto = RoomieTestData.defaultCHO();
        Roomie cho = roomieDTOMapper.asEntity(choDto);
        for(int i=0; i<3; i++){
            roomieRepository.save(cho);
        }

        List<Roomie> chos = roomieRepository.getCurrentChos();

        assertThat(chos).hasSize(3);
    }


}
