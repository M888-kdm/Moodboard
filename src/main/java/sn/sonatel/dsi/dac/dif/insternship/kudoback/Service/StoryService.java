package sn.sonatel.dsi.dac.dif.insternship.kudoback.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.DTOs.StoryDTO;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Entities.Story;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Mappers.StoryDTOMapper;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Repositories.StoryRepository;

import java.util.List;

@Service
public class StoryService {

    @Autowired
    StoryRepository storyRepository;
    @Autowired
    StoryDTOMapper storyDTOMapper;

    public StoryDTO saveStory(StoryDTO storyDTO){
        Story story = storyRepository.save(storyDTOMapper.ToEntity(storyDTO));
        return storyDTOMapper.ToDTO(story);
    }

    public List<StoryDTO> getDailyStories(){
        return storyDTOMapper.ToDTOList(storyRepository.getDailyStories());
    }

}
