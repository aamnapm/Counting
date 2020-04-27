package com.aamnapm.counting.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
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

}