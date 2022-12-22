package sn.sonatel.dsi.dac.dif.insternship.kudoback.Entities;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Enumerations.KudoValue;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Kudo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String message;

    @Column
    private KudoValue value;

    @Column
    @CreationTimestamp
    private Date date;

    @OneToOne
    @JoinColumn(name = "sender_id")
    private Roomie sender;

    @OneToOne
    @JoinColumn(name = "receiver_id")
    private Roomie receiver;

}
