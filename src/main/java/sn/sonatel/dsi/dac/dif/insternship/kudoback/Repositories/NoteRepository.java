package sn.sonatel.dsi.dac.dif.insternship.kudoback.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Entities.Note;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

    @Query(value="SELECT AVG(value) FROM NOTE WHERE group_id=:group_id", nativeQuery = true)
    public Integer getGroupNote(@Param("group_id") Long group_id);

    @Query(value = "SELECT * FROM NOTE WHERE group_id=:group_id", nativeQuery = true)
    public List<Note> getAllNotes(@Param("group_id") Long group_id);

}
