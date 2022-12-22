package sn.sonatel.dsi.dac.dif.insternship.kudoback.DTOs;

import lombok.Data;
import java.util.Date;

@Data
public class InfoDTO extends BaseDTO {

    private Long id;
    private String message;
    private Date date;
    private String roomieUsername;

}
