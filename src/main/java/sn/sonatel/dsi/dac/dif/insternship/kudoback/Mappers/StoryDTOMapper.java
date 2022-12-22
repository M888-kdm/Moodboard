package sn.sonatel.dsi.dac.dif.insternship.kudoback.Mappers;

import org.mapstruct.Mapper;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.DTOs.StoryDTO;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Entities.Story;

@Mapper(componentModel = "spring")
public abstract class StoryDTOMapper extends BaseMapper<Story, StoryDTO> {

}
