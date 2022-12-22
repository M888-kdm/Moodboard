package sn.sonatel.dsi.dac.dif.insternship.kudoback.Entities;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Data
public class Roomie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String fullName;

    @Column
    private String username;

    @Column
    private String plateau;

    @Column
    private String job;

    @Column
    private Date lastService;

    @Column
//    @ColumnDefault("false")
    private Boolean isCHO;

    @ManyToMany
    Set<GroupeCHO> choGroups;

}
