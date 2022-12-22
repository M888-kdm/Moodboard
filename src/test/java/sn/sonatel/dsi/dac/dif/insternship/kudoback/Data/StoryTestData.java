package sn.sonatel.dsi.dac.dif.insternship.kudoback.Data;

import sn.sonatel.dsi.dac.dif.insternship.kudoback.DTOs.StoryDTO;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Entities.Story;

import java.util.Date;
import java.util.Random;

public class StoryTestData {

    public static final class Default{
        public static final Long id = Double.doubleToLongBits(new Random().nextDouble());
        public static final String url = "assets/image.png";
        public static final Date date = new Date(2000, 10, 10);
        public static final String roomieUsername = RoomieTestData.defaultRoomie().getUsername();
    }

    public static final Story defaultStory(){

        Story story = new Story();
        story.setId(Default.id);
        story.setUrl(Default.url);
        story.setDate(Default.date);

        return story;

    }

    public static final StoryDTO defaultDTO(){

        StoryDTO storyDTO = new StoryDTO();

        storyDTO.setId(Default.id);
        storyDTO.setUrl(Default.url);
        storyDTO.setDate(Default.date);
        storyDTO.setRoomieUsername(Default.roomieUsername);

        return storyDTO;
    }
}
