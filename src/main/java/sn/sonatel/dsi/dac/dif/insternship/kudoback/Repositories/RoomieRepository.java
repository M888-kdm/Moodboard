package sn.sonatel.dsi.dac.dif.insternship.kudoback.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Entities.Roomie;


import java.util.List;

@Repository
public interface RoomieRepository extends JpaRepository<Roomie, Long> {

    @Query(value = "SELECT * FROM roomie WHERE last_service IS NULL AND ischo = FALSE LIMIT 3", nativeQuery = true)
    public List<Roomie> getWeeklyChosFromUnenrolledRoomies();

    @Query(value = "SELECT * FROM roomie WHERE ischo=FALSE AND last_service IS NOT NULL ORDER BY last_service LIMIT :number", nativeQuery = true)
    public List<Roomie> getWeeklyCHOsFromEnrolledRoomies(@Param("number") Integer number);

    @Query(value = "SELECT * FROM roomie WHERE username = :username", nativeQuery = true)
    public Roomie getRoomieByUsername(@Param("username") String username);

    @Query(value = "SELECT * FROM roomie WHERE ischo=true", nativeQuery = true)
    public List<Roomie> getCurrentChos();

}
