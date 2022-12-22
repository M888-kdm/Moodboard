package sn.sonatel.dsi.dac.dif.insternship.kudoback.DTOs;

import lombok.Data;
import java.util.Date;

@Data
public class StoryDTO extends BaseDTO {

    private Long id;
    private String url;
    private Date date;
    private String roomieUsername;

}
