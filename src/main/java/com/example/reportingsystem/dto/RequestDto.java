package com.example.reportingsystem.dto;

import lombok.Data;

@Data
public class RequestDto {
    private int reportingYear;
    private int reportingPeriod;
    private int developmentLevel;
}
