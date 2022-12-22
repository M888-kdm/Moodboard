package sn.sonatel.dsi.dac.dif.insternship.kudoback.DTOs;

import lombok.Data;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Enumerations.KudoValue;

import java.util.Date;

@Data
public class KudoDTO extends BaseDTO {

    private Long id;
    private String message;
    private KudoValue value;
    private Date date;
    private String sender;
    private String receiver;

}
