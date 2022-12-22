package sn.sonatel.dsi.dac.dif.insternship.kudoback.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Entities.Mood;

@Repository
public interface MoodRepository extends JpaRepository<Mood, Long> {

    @Query(value = "SELECT * FROM mood JOIN roomie WHERE username=:username WHERE DATE(date) = DATE(NOW())", nativeQuery = true)
    public Mood getMoodOfRoomie(@Param("username") String username);

    @Query(value = "SELECT COUNT(*) FROM mood WHERE value = :mood AND Date(date) = DATE(NOW())" , nativeQuery = true)
    public Integer getMoodCountForCurrentDay(@Param("mood") String mood);

    @Query(value = "SELECT COUNT(*) FROM mood WHERE value = :mood AND WEEK(date) = WEEK(NOW())", nativeQuery = true)
    public Integer getMoodCountForCurrentWeek(@Param("mood") String mood);

}
