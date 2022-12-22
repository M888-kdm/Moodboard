package sn.sonatel.dsi.dac.dif.insternship.kudoback.Data;

import sn.sonatel.dsi.dac.dif.insternship.kudoback.DTOs.MoodDTO;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Entities.Mood;
import sn.sonatel.dsi.dac.dif.insternship.kudoback.Enumerations.MoodValue;

import java.time.Instant;
import java.util.Date;
import java.util.Random;

public class MoodTestData {

    public static MoodDTO defaultDTO(){

        MoodDTO moodDTO = new MoodDTO();
        moodDTO.setId(Default.id);
        moodDTO.setDate(Default.date);
        moodDTO.setValue(Default.moodString);
        moodDTO.setRoomieUsername(Default.username);

        return moodDTO;
    }

    public static Mood defaultMood(){

        Mood mood = new Mood();
        mood.setId(Default.id);
        mood.setDate(Default.date);
        mood.setValue(Default.mood);

        return mood;

    }

    public static class Default{
        public static final Long id = Double.doubleToLongBits(new Random().nextDouble());
        public static Date date = Date.from(Instant.now());
        public static String moodString = "NEUTRAL";
        public static String username = "Khadim";
        public static MoodValue mood = MoodValue.NEUTRAL;
    }

}
