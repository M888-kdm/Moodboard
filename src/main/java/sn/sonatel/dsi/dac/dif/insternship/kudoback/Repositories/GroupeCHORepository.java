package sn.sonatel.dsi.dac.dif.insternship.kudoback.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Entities.GroupeCHO;

@Repository
public interface GroupeCHORepository extends JpaRepository<GroupeCHO, Long> {

    @Query(value = "SELECT * FROM groupecho ORDER BY creation_date LIMIT 1", nativeQuery = true)
    public GroupeCHO getCurrentGroup();

}
