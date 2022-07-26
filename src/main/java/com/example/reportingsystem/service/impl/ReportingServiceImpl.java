package com.example.reportingsystem.service.impl;

import com.example.reportingsystem.model.Line;
import com.example.reportingsystem.repository.ReportRepository;
import com.example.reportingsystem.service.ReportingService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportingServiceImpl implements ReportingService {
    private ReportRepository reportRepository;

    @Autowired
    public ReportingServiceImpl(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }
    @Override
    public String exportReport(String reportFormat) throws FileNotFoundException, JRException {
        List<Line> lines =reportRepository.findAll();
        File file = ResourceUtils.getFile("classpath:test.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(lines);
        Map<String,Object> map = new HashMap<>();
        map.put("by", "yurchenko");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, dataSource);
        if(reportFormat.equalsIgnoreCase("pdf")){
            JasperExportManager.exportReportToPdfFile(jasperPrint, "report.pdf");
        }
        return "report generated";
    }
}
