package sn.sonatel.dsi.dac.dif.insternship.kudoback.DTOs;

import lombok.Data;
import java.util.Date;

@Data
public class MoodDTO extends BaseDTO {

    private Long id;
    private Date date;
    private String value;
    private String roomieUsername;

}
