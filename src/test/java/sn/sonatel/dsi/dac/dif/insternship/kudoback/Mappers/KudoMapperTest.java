package sn.sonatel.dsi.dac.dif.insternship.kudoback.Mappers;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.DTOs.KudoDTO;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Data.KudoTestData;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Data.RoomieTestData;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Entities.Kudo;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Entities.Roomie;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Repositories.KudoRepository;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Repositories.RoomieRepository;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Repositories.GenericTest;

import static org.assertj.core.api.Assertions.assertThat;

public class KudoMapperTest extends GenericTest {

    Kudo kudo;
    KudoDTO kudoDTO;
    static Roomie sender;
    static Roomie receiver;

    @Autowired
    KudoRepository kudoRepository;
    @Autowired
    RoomieRepository roomieRepository;
    @Autowired
    KudoDTOMapper kudoDTOMapper;

    @BeforeAll
    static void setUp(){
        sender = RoomieTestData.defaultRoomie();
        receiver = RoomieTestData.defaultRoomie();
        sender.setUsername("Sender");
        receiver.setUsername("Receiver");
    }

    @BeforeEach
    void beforeEach(){
        roomieRepository.save(sender);
        roomieRepository.save(receiver);
        kudoDTO = KudoTestData.defaultDTO();
        kudoDTO.setSender(sender.getUsername());
        kudoDTO.setReceiver(receiver.getUsername());
    }

    @Test
    void convertKudoDtoToEntityShouldSucceed(){
        kudo = kudoDTOMapper.ToEntity(kudoDTO);

        assertThat(kudo)
                .isNotNull()
                .usingRecursiveComparison()
                .ignoringFields("sender", "receiver")
                .isEqualTo(kudoDTO);

        assertThat(kudo.getSender())
                .isNotNull()
                .usingRecursiveComparison()
                .ignoringFields("id")
                .isEqualTo(sender);

        assertThat(kudo.getReceiver())
                .isNotNull()
                .usingRecursiveComparison()
                .ignoringFields("id")
                .isEqualTo(receiver);
    }

    @Test
    void convertKudoEntityToDtoShouldReturnCorrectDto(){
        kudo = kudoDTOMapper.ToEntity(kudoDTO);
        kudoDTO = kudoDTOMapper.ToDTO(kudo);

        assertThat(kudoDTO)
                .isNotNull()
                .hasFieldOrPropertyWithValue("sender", sender.getUsername())
                .hasFieldOrPropertyWithValue("receiver", receiver.getUsername())
                .usingRecursiveComparison()
                .ignoringFields("sender", "receiver")
                .isEqualTo(kudo)
                ;
    }

}
