package com.aamnapm.counting.dto;

import com.aamnapm.counting.model.Record;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Setter
@Getter
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

}
