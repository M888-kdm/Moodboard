package sn.sonatel.dsi.dac.dif.insternship.kudoback.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.DTOs.InfoDTO;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Entities.Info;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Mappers.InfoDTOMapper;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Repositories.InfoRepository;

import java.util.List;

@Service
public class InfoService {

    @Autowired
    InfoRepository infoRepository;

    @Autowired
    InfoDTOMapper infoDTOMapper;

    public List<InfoDTO> getLastInfos(){
        return infoDTOMapper.ToDTOList(infoRepository.getLastInfos());
    }

    public InfoDTO saveInfo(InfoDTO infoDTO){
        Info info = infoRepository.save(infoDTOMapper.ToEntity(infoDTO));
        return infoDTOMapper.ToDTO(info);
    }

}
