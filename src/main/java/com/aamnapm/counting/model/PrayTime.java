package com.aamnapm.counting.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "paray_time")
public class PrayTime extends BaseEntity {

    @JsonProperty("CityName")
    @Column(name = "CityName")
    private String CityName;

    @JsonProperty("CountryName")
    @Column(name = "CountryName")
    private String CountryName;

    @JsonProperty("CityLName")
    @Column(name = "CityLName")
    private String CityLName;

    @JsonProperty("CountryLName")
    @Column(name = "CountryLName")
    private String CountryLName;

    @JsonProperty("TimeZone")
    @Column(name = "TimeZone")
    private String TimeZone;

    @JsonProperty("Imsaak")
    @Column(name = "Imsaak")
    private String Imsaak;

    @JsonProperty("Sunrise")
    @Column(name = "Sunrise")
    private String Sunrise;

    @JsonProperty("Noon")
    @Column(name = "Noon")
    private String Noon;

    @JsonProperty("Sunset")
    @Column(name = "Sunset")
    private String Sunset;

    @JsonProperty("Maghreb")
    @Column(name = "Maghreb")
    private String Maghreb;

    @JsonProperty("Midnight")
    @Column(name = "Midnight")
    private String Midnight;

    @JsonProperty("Today")
    @Column(name = "Today")
    private String Today;

    @JsonProperty("TodayQamari")
    @Column(name = "TodayQamari")
    private String TodayQamari;

    @JsonProperty("DayLenght")
    @Column(name = "DayLenght")
    private String DayLenght;

    @JsonProperty("SimultaneityOfKaaba")
    @Column(name = "SimultaneityOfKaaba")
    private String SimultaneityOfKaaba;


    public String getCityName() {
        return CityName;
    }

    public void setCityName(String cityName) {
        CityName = cityName;
    }

    public String getCountryName() {
        return CountryName;
    }

    public void setCountryName(String countryName) {
        CountryName = countryName;
    }

    public String getCityLName() {
        return CityLName;
    }

    public void setCityLName(String cityLName) {
        CityLName = cityLName;
    }

    public String getCountryLName() {
        return CountryLName;
    }

    public void setCountryLName(String countryLName) {
        CountryLName = countryLName;
    }

    public String getTimeZone() {
        return TimeZone;
    }

    public void setTimeZone(String timeZone) {
        TimeZone = timeZone;
    }

    public String getImsaak() {
        return Imsaak;
    }

    public void setImsaak(String imsaak) {
        Imsaak = imsaak;
    }

    public String getSunrise() {
        return Sunrise;
    }

    public void setSunrise(String sunrise) {
        Sunrise = sunrise;
    }

    public String getNoon() {
        return Noon;
    }

    public void setNoon(String noon) {
        Noon = noon;
    }

    public String getSunset() {
        return Sunset;
    }

    public void setSunset(String sunset) {
        Sunset = sunset;
    }

    public String getMaghreb() {
        return Maghreb;
    }

    public void setMaghreb(String maghreb) {
        Maghreb = maghreb;
    }

    public String getMidnight() {
        return Midnight;
    }

    public void setMidnight(String midnight) {
        Midnight = midnight;
    }

    public String getToday() {
        return Today;
    }

    public void setToday(String today) {
        Today = today;
    }

    public String getTodayQamari() {
        return TodayQamari;
    }

    public void setTodayQamari(String todayQamari) {
        TodayQamari = todayQamari;
    }

    public String getDayLenght() {
        return DayLenght;
    }

    public void setDayLenght(String dayLenght) {
        DayLenght = dayLenght;
    }

    public String getSimultaneityOfKaaba() {
        return SimultaneityOfKaaba;
    }

    public void setSimultaneityOfKaaba(String simultaneityOfKaaba) {
        SimultaneityOfKaaba = simultaneityOfKaaba;
    }
}