package sn.sonatel.dsi.dac.dif.insternship.kudoback.Mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.DTOs.InfoDTO;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Entities.Info;

import java.util.List;
import java.util.stream.Collectors;
public abstract class BaseMapper<S, D> extends RoomieTransformer{

    @Mapping(source = "roomieUsername", target = "roomie", qualifiedByName = "usernameToRoomie")
    public abstract S ToEntity(D destination);

    @Mapping(source = "roomie", target = "roomieUsername", qualifiedByName = "roomieToUsername")
    public abstract D ToDTO(S source);

    public List<S> ToEntityList(List<D> dList){
        return dList.stream().map(this::ToEntity).collect(Collectors.toList());
    }

    public List<D> ToDTOList(List<S> eList){
        return eList.stream().map(this::ToDTO).collect(Collectors.toList());
    }

}
