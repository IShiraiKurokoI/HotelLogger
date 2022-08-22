package com.Shirai_Kuroko.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class OperationLog {
    @JsonProperty("time")
    private Date time;
    @JsonProperty("operation")
    private String operation;

    public OperationLog(java.sql.Date time, String operation) {
        this.time = time;
        this.operation = operation;
    }
}
