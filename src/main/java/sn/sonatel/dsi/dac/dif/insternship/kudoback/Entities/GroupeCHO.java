package sn.sonatel.dsi.dac.dif.insternship.kudoback.Entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Data
public class GroupeCHO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Date creationDate;

    @ManyToMany
    @JoinTable(name = "ServiceCHO",
            joinColumns = @JoinColumn(name = "roomie_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Roomie> chos;

}
