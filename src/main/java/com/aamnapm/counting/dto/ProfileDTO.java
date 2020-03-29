package com.aamnapm.counting.dto;

import com.aamnapm.counting.model.Record;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;
import java.util.UUID;

public class ProfileDTO {

    @ApiModelProperty(required = false, hidden = true)
    private UUID uuid;

    @ApiModelProperty(required = false, hidden = false)
    private int age;

    @ApiModelProperty(required = false, hidden = false)
    private String name;

    @ApiModelProperty(required = false, hidden = false)
    private String family;

    @ApiModelProperty(required = false, hidden = false)
    private String nationalCode;

    @ApiModelProperty(required = false, hidden = false)
    private List<Record> records;


    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }
}
