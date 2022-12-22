package sn.sonatel.dsi.dac.dif.insternship.kudoback.Mappers;

import org.mapstruct.Mapper;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.DTOs.RoomieDTO;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Entities.Roomie;

@Mapper(componentModel = "spring")
public interface RoomieDTOMapper extends GenericMapper<Roomie, RoomieDTO>{
}
