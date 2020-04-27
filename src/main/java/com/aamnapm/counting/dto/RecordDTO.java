package com.aamnapm.counting.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class RecordDTO {

    @ApiModelProperty(required = false, hidden = true)
    private UUID uuid;

    @ApiModelProperty(required = false, hidden = true)
    private UUID profileId;

    @ApiModelProperty(required = false, hidden = false)
    private Integer type;

    @ApiModelProperty(required = false, hidden = false)
    private String title;

    @ApiModelProperty(required = false, hidden = false)
    private String price;

}
