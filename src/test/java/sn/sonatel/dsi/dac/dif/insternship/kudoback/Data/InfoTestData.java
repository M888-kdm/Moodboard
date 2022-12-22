package sn.sonatel.dsi.dac.dif.insternship.kudoback.Data;

import sn.sonatel.dsi.dac.dif.insternship.kudoback.DTOs.InfoDTO;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Entities.Info;

import java.util.Date;
import java.util.Random;

public class InfoTestData {

    public static final class Default{
        public static final Long id = Double.doubleToLongBits(new Random().nextDouble());
        public static final String message = "This is a test info for the project";
        public static final Date date = new Date(2000, 10, 10);
    }

    public static final InfoDTO defaultDTO(){

        InfoDTO infoDTO = new InfoDTO();
        infoDTO.setId(Default.id);
        infoDTO.setMessage(Default.message);
        infoDTO.setDate(Default.date);

        return infoDTO;
    }

    public static final Info defaultInfo(){

        Info info = new Info();
        info.setId(Default.id);
        info.setMessage(Default.message);
        info.setDate(Default.date);

        return info;

    }

}
