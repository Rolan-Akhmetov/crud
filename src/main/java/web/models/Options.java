package web.models;

public class Options {
    private String RADIO;
    private String HATCH;
    private String CONDITIONER;

    public Options(String RADIO, String HATCH, String CONDITIONER) {
        this.RADIO = RADIO;
        this.HATCH = HATCH;
        this.CONDITIONER = CONDITIONER;
    }

    public String getRADIO() {
        return RADIO;
    }

    public String getHATCH() {
        return HATCH;
    }

    public String getCONDITIONER() {
        return CONDITIONER;
    }
}
