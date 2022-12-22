package sn.sonatel.dsi.dac.dif.insternship.kudoback.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Entities.Info;

import java.util.List;

@Repository
public interface InfoRepository extends JpaRepository<Info, Long> {

    @Query(value = "SELECT * FROM info ORDER BY date DESC LIMIT 5", nativeQuery = true)
    public List<Info> getLastInfos();

}
