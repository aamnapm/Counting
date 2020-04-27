package com.aamnapm.counting.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class ResponseApi {

    private boolean status;
    private String message;
    private UUID result;

}
