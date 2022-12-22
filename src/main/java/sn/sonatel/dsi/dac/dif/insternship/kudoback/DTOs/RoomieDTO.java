package sn.sonatel.dsi.dac.dif.insternship.kudoback.DTOs;

import lombok.*;

import java.util.Date;

@Data
public class RoomieDTO extends BaseDTO {

    private Long id;
    private String fullName;
    private String username;
    private String plateau;
    private String job;
    private Date lastService;
    private Boolean isCHO;

}
