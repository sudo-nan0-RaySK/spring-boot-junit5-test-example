package com.raykan.beans;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class HealthInfo {
    private String status;
    private int portInfo;
    private long startedAt;
    private long upSince;
}
