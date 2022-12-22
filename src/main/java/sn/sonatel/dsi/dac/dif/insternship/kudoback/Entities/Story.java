package sn.sonatel.dsi.dac.dif.insternship.kudoback.Entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Story {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String url;

    @Column
    private Date date;

    @ManyToOne
    @JoinColumn(name = "roomie_id")
    private Roomie roomie;
}
