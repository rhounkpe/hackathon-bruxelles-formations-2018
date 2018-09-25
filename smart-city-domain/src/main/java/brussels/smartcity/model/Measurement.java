package brussels.smartcity.model;

import java.time.LocalDateTime;

public class Measurement {
    private String deviceId;
    private LocalDateTime date;
    private float laeq15;
    private float laeq60;



    public Measurement() {}


    public Measurement(String deviceId, LocalDateTime date, float laeq15, float laeq60) {
        this.deviceId = deviceId;
        this.date = date;
        this.laeq15 = laeq15;
        this.laeq60 = laeq60;
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

    public float getLaeq15() {
        return laeq15;
    }

    public void setLaeq15(float laeq15) {
        this.laeq15 = laeq15;
    }

    public float getLaeq60() {
        return laeq60;
    }

    public void setLaeq60(float laeq60) {
        this.laeq60 = laeq60;
    }
}
