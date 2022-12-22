package sn.sonatel.dsi.dac.dif.insternship.kudoback.Services;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.DTOs.KudoDTO;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Data.KudoTestData;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Data.RoomieTestData;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Entities.Roomie;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Mappers.KudoDTOMapper;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Repositories.RoomieRepository;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Repositories.GenericTest;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Service.KudoService;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class KudoServiceTest extends GenericTest {

    @Autowired
    KudoService kudoService;
    @Autowired
    KudoDTOMapper kudoDTOMapper;
    @Autowired
    RoomieRepository roomieRepository;

    static Roomie sender;
    static Roomie receiver;
    static KudoDTO kudoDTO;

    @BeforeAll
    static void setUp(){
        sender = RoomieTestData.defaultRoomie();
        receiver = RoomieTestData.defaultRoomie();
        sender.setUsername("Sender");
        receiver.setUsername("Receiver");
        kudoDTO = KudoTestData.defaultDTO();
    }

    @BeforeEach
    void beforeEach(){
        roomieRepository.save(sender);
        roomieRepository.save(receiver);
        kudoDTO.setSender(sender.getUsername());
        kudoDTO.setReceiver(sender.getUsername());
    }

    @Test
    void createKudoShouldSucceed(){
        KudoDTO dto = kudoService.createKudo(kudoDTO);
        assertThat(dto)
                .isNotNull()
                .usingRecursiveComparison()
                .ignoringFields("id")
                .isEqualTo(kudoDTO);
    }

    @Test
    void findAllKudosShouldReturnAllKudos(){
        kudoService.createKudo(kudoDTO);

        List<KudoDTO> kudos = kudoService.getAllKudos();
        assertThat(kudos)
                .isNotEmpty()
                .hasSize(1);
    }

}
