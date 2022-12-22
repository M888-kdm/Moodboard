package sn.sonatel.dsi.dac.dif.insternship.kudoback.Mappers;

import org.mapstruct.Mapper;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.DTOs.InfoDTO;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Entities.Info;;

@Mapper(componentModel = "spring")
public abstract class InfoDTOMapper extends BaseMapper<Info, InfoDTO> {

}
