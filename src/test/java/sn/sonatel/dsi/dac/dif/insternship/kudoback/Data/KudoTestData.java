package sn.sonatel.dsi.dac.dif.insternship.kudoback.Data;

import sn.sonatel.dsi.dac.dif.insternship.kudoback.DTOs.KudoDTO;

import java.util.Date;
import java.util.Random;

public class KudoTestData {

    public static final class Default{
        public static final Long id = Double.doubleToLongBits(new Random().nextDouble());
        public static final String message = "Thank you for the coffee !";
        public static final Date date = new Date(2010, 10, 10);
    }

    public static final KudoDTO defaultDTO(){
        KudoDTO dto = new KudoDTO();

        dto.setId(Default.id);
        dto.setMessage(Default.message);
        dto.setDate(Default.date);

        return dto;
    }

}
