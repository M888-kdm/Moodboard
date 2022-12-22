package sn.sonatel.dsi.dac.dif.insternship.kudoback.Mappers;


import java.util.List;
import java.util.stream.Collectors;

public interface GenericMapper<S, D> {

    S asEntity(D destination);
    D asDTO(S source);

    default List<S> asEntityList(List<D> dList){
        return dList.stream().map(this::asEntity).collect(Collectors.toList());
    }
    default List<D> asDTOList(List<S> eList){
        return eList.stream().map(this::asDTO).collect(Collectors.toList());
    }

}
