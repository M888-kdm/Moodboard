package sn.sonatel.dsi.dac.dif.insternship.kudoback.Mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.DTOs.MoodDTO;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Entities.Mood;

@Mapper(componentModel = "spring")
public abstract class MoodDTOMapper extends BaseMapper<Mood, MoodDTO> {

}
