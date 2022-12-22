package sn.sonatel.dsi.dac.dif.insternship.kudoback.Mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.DTOs.NoteDTO;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Entities.GroupeCHO;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Entities.Note;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Repositories.GroupeCHORepository;

import java.util.Optional;

@Mapper(componentModel = "spring")
public abstract class NoteDTOMapper extends BaseMapper<Note, NoteDTO> {

    @Autowired
    GroupeCHORepository groupeCHORepository;

    @Override
    @Mapping(source = "groupId", target = "groupeCHO", qualifiedByName = "IdToGroup")
    @Mapping(source = "roomieUsername", target = "roomie", qualifiedByName = "usernameToRoomie")
    public abstract Note ToEntity(NoteDTO noteDTO);

    @Override
    @Mapping(source = "groupeCHO", target = "groupId", qualifiedByName = "groupToId")
    @Mapping(source = "roomie", target = "roomieUsername", qualifiedByName = "roomieToUsername")
    public abstract NoteDTO ToDTO(Note note);

    @Named("groupToId")
    public Long groupToId(GroupeCHO groupeCHO){
        return groupeCHO.getId();
    }

    @Named("IdToGroup")
    public GroupeCHO idToGroup(Long groupID) throws NullPointerException{
        Optional<GroupeCHO> group = groupeCHORepository.findById(groupID);
        try
        {
            return group.get();
        }
        catch(Exception e){
            return null;
        }
    }

}
