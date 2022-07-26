package com.example.reportingsystem.service;

import net.sf.jasperreports.engine.JRException;

import java.io.FileNotFoundException;

public interface ReportingService {
    String exportReport(String reportFormat) throws FileNotFoundException, JRException;
}
