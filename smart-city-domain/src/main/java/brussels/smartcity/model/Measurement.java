package brussels.smartcity.model;


import java.time.LocalDateTime;



public class Measurement {

    private Long identifier;
    private String deviceId;
    private LocalDateTime date;
    private double laeq15;
    private double laeq60;
    private double lceq15;
    private double lceq60;



    public Measurement() {}


    public Measurement(String deviceId, LocalDateTime date, double laeq15, double laeq60) {
        this.deviceId = deviceId;
        this.date = date;
        this.laeq15 = laeq15;
        this.laeq60 = laeq60;
    }

    //Revoir ce constructeur en réutilisant le précédent
    public Measurement(Long identifier, String deviceId, LocalDateTime date, double laeq15, double laeq60) {
        this.identifier = identifier;
        this.deviceId = deviceId;
        this.date = date;
        this.laeq15 = laeq15;
        this.laeq60 = laeq60;
    }

    public Measurement(Long identifier, String deviceId, LocalDateTime date, double laeq15, double laeq60, double lceq15, double lceq60) {
        this.identifier = identifier;
        this.deviceId = deviceId;
        this.date = date;
        this.laeq15 = laeq15;
        this.laeq60 = laeq60;
        this.lceq15 = lceq15;
        this.lceq60 = lceq60;
    }

    public Long getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Long identifier) {
        this.identifier = identifier;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public double getLaeq15() {
        return laeq15;
    }

    public void setLaeq15(double laeq15) {
        this.laeq15 = laeq15;
    }

    public double getLaeq60() {
        return laeq60;
    }

    public void setLaeq60(double laeq60) {
        this.laeq60 = laeq60;
    }

    public double getLceq15() {
        return lceq15;
    }

    public void setLceq15(double lceq15) {
        this.lceq15 = lceq15;
    }

    public double getLceq60() {
        return lceq60;
    }

    public void setLceq60(double lceq60) {
        this.lceq60 = lceq60;
    }
}
