package com.Shirai_Kuroko.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @author Shirai_Kuroko
 * @version 1.0.0
 * @ClassName Response.java
 * @Description TODO
 * @createTime 2022年08月22日 16:21
 */

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Response {
    @JsonProperty("ErrCode")
    private int ErrCode;
    @JsonProperty("ErrMsg")
    private String ErrMsg;
    @JsonProperty("Data")
    private List<OperationLog> Data;

    public Response(int i, String o, List<OperationLog> query) {
        this.ErrCode=i;
        this.ErrMsg=o;
        this.Data=query;
    }
}
