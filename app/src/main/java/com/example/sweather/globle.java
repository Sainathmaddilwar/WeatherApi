package com.example.sweather;

public class globle {
    private String weather;
    private String temp;
    private String humidity;
    private String Airpressure;
    private String Visiblity;
    private String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getAirpressure() {
        return Airpressure;
    }

    public void setAirpressure(String airpressure) {
        Airpressure = airpressure;
    }

    public String getVisiblity() {
        return Visiblity;
    }

    public void setVisiblity(String visiblity) {
        Visiblity = visiblity;
    }

    public String getWeather() {
        return weather;
    }

    public String getTemp() {
        return temp;
    }


    public void setWeather(String weather) {
        this.weather = weather;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }
}
