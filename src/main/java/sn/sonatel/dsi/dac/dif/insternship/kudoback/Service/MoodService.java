package sn.sonatel.dsi.dac.dif.insternship.kudoback.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.DTOs.MoodDTO;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Entities.Mood;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Mappers.MoodDTOMapper;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Repositories.MoodRepository;

@Service
public class MoodService {

    @Autowired
    MoodRepository moodRepository;
    @Autowired
    MoodDTOMapper moodDTOMapper;

    public MoodDTO saveMood(MoodDTO moodDTO){
        Mood mood = moodRepository.save(moodDTOMapper.ToEntity(moodDTO));
        return moodDTOMapper.ToDTO(mood);
    }

    public MoodDTO getMoodOfRoomie(String username){
        Mood mood = moodRepository.getMoodOfRoomie(username);
        return moodDTOMapper.ToDTO(mood);
    }

    public Integer getMoodCountForCurrentDate(String mood){
        return moodRepository.getMoodCountForCurrentWeek(mood);
    }

    public Integer getMoodCountForCurrentWeek(String mood){
        return moodRepository.getMoodCountForCurrentWeek(mood);
    }

}
