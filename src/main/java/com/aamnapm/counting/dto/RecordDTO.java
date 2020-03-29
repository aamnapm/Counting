package com.aamnapm.counting.dto;

import io.swagger.annotations.ApiModelProperty;

import java.util.UUID;

public class RecordDTO {

    @ApiModelProperty(required = false,hidden = true)
    private UUID uuid;

    @ApiModelProperty(required = false,hidden = false)
    private Integer type;

    @ApiModelProperty(required = false,hidden = false)
    private String title;

    @ApiModelProperty(required = false,hidden = false)
    private String price;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
