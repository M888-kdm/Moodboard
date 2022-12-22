package sn.sonatel.dsi.dac.dif.insternship.kudoback.Utils;

public final class UrlMapping {
    public static final String api = "/api";

    public static final class Roomie {
        public static final String base = api + "/roomies";
        public static final String GET_CHOS = base + "/chos";
        public static final String FIND_BY_USERNAME = base + "/get";
    }

    public static final class Info {
        public static final String base = api + "/infos";
        public static final String GET_LATEST_INFOS = base + "/get/latest";
        public static final String SAVE_INFO = base;
    }

    public static final class Kudo {
        public static final String base = api + "/kudos";
        public static final String GET_ALL_KUDOS = base + "/all";
        public static final String CREATE_KUDO = base + "/";
    }

    public static final class Mood{
        public static final String base = api + "/moods";
        public static final String GET_ROOMIE_MOOD = base;
    }

    public static final class Note{
        public static final String base = api + "/notes";
        public static final String SAVE_NOTE = base + "/";
        public static final String GET_GROUP_NOTE = base + "/group";
        public static final String GET_ALL_NOTES = base + "/group" + "/all";
    }

}
