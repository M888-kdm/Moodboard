package sn.sonatel.dsi.dac.dif.insternship.kudoback.Entities;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Enumerations.MoodValue;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Mood {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @CreationTimestamp
    private Date date;

    @Enumerated(EnumType.STRING)
    @Column
    private MoodValue value;

    @ManyToOne
    @JoinColumn(name = "roomie_id")
    private Roomie roomie;

}
