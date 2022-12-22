package sn.sonatel.dsi.dac.dif.insternship.kudoback.Repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Data.StoryTestData;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Entities.Story;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Mappers.StoryDTOMapper;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StoryRepositoryTest extends GenericTest {

    @Autowired
    StoryRepository storyRepository;
    @Autowired
    StoryDTOMapper storyDTOMapper;

    Story story;

    @BeforeEach
    void beforeEach(){
        story = StoryTestData.defaultStory();
    }

    @Test
    void getDailyStoriesShouldReturnDailyStories(){
        storyRepository.save(story);
        List<Story> stories = storyRepository.getDailyStories();

        assertThat(stories)
                .isNotEmpty()
                .hasSize(1);
    }

}
