package sn.sonatel.dsi.dac.dif.insternship.kudoback.DTOs;

import lombok.Data;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Entities.GroupeCHO;

@Data
public class NoteDTO extends BaseDTO {

    private Long id;
    private Integer value;
    private String comment;
    private String roomieUsername;
    private Long groupId;

}
