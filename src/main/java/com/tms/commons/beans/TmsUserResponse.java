package com.tms.commons.beans;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
public class TmsUserResponse extends BaseResponse {
    private List<TmsUserInfo> users;
}
