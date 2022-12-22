package sn.sonatel.dsi.dac.dif.insternship.kudoback.Entities;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Info {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 1000, columnDefinition = "TEXT")
    private String message;

    @CreationTimestamp
    private Date date;

    @ManyToOne
    @JoinColumn(name = "roomie_id")
    private Roomie roomie;

}
