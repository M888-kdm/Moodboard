package sn.sonatel.dsi.dac.dif.insternship.kudoback.Mappers;

import org.mapstruct.Mapper;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.DTOs.GroupeChoDTO;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Entities.GroupeCHO;

@Mapper(componentModel = "spring")
public interface GroupeChoDTOMapper extends GenericMapper<GroupeCHO, GroupeChoDTO>{

}
