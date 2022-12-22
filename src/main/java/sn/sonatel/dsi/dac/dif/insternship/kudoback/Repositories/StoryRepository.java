package sn.sonatel.dsi.dac.dif.insternship.kudoback.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Entities.Story;

import java.util.List;

public interface StoryRepository extends JpaRepository<Story, Long> {

    @Query(value = "SELECT * FROM story WHERE date > NOW() - INTERVAL 1 DAY", nativeQuery = true)
    public List<Story> getDailyStories();

}
