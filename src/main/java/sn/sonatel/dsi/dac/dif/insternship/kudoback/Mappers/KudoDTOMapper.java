package sn.sonatel.dsi.dac.dif.insternship.kudoback.Mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.DTOs.KudoDTO;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Entities.Kudo;

@Mapper(componentModel = "spring")
public abstract class KudoDTOMapper extends BaseMapper<Kudo, KudoDTO>{

    @Override
    @Mapping(source = "sender", target = "sender", qualifiedByName = "usernameToRoomie")
    @Mapping(source = "receiver", target = "receiver", qualifiedByName = "usernameToRoomie")
    public abstract Kudo ToEntity(KudoDTO kudoDTO);

    @Override
    @Mapping(source = "sender", target = "sender", qualifiedByName = "roomieToUsername")
    @Mapping(source = "receiver", target = "receiver", qualifiedByName = "roomieToUsername")
    public abstract KudoDTO ToDTO(Kudo kudo);

}
