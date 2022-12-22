package sn.sonatel.dsi.dac.dif.insternship.kudoback.Embeddables;

import lombok.Data;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Entities.Roomie;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class ServiceCHOKey implements Serializable {

    @Column
    private Long roomie_id;

    @Column
    private Long group_id;

}
