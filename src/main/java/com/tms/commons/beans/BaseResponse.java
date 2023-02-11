package com.tms.commons.beans;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Setter
@Getter
public class BaseResponse {
    private String status;
    private String errorCode;
    private String errorMessage;
    private Map<Integer, Object> messageParams;
}
