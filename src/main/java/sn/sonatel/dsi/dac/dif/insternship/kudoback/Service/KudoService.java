package sn.sonatel.dsi.dac.dif.insternship.kudoback.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.DTOs.KudoDTO;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Entities.Kudo;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Mappers.KudoDTOMapper;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Repositories.KudoRepository;

import java.util.List;

@Service
public class KudoService {

    @Autowired
    KudoRepository kudoRepository;
    @Autowired
    KudoDTOMapper kudoDTOMapper;

    public KudoDTO createKudo(KudoDTO kudoDTO){
        Kudo kudo = kudoRepository.save(kudoDTOMapper.ToEntity(kudoDTO));
        return kudoDTOMapper.ToDTO(kudo);
    }

    public List<KudoDTO> getAllKudos(){
        return kudoDTOMapper.ToDTOList(kudoRepository.findAll());
    }

}
