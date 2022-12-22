package sn.sonatel.dsi.dac.dif.insternship.kudoback.Entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Integer value;

    @Column
    private String comment;

    @ManyToOne
    @JoinColumn(name = "roomie_id")
    private Roomie roomie;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private GroupeCHO groupeCHO;

}
