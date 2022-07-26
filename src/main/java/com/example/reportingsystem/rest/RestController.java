package com.example.reportingsystem.rest;

import com.example.reportingsystem.dto.LoginDto;
import com.example.reportingsystem.dto.RequestDto;
import com.example.reportingsystem.repository.ReportRepository;
import com.example.reportingsystem.service.ReportingService;
import com.example.reportingsystem.service.UserService;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.FileNotFoundException;
import java.util.List;

@Controller
@RequestMapping("/api/reportingService/")
@CrossOrigin(origins = "http://localhost:63342")
@Slf4j
public class RestController {
    private final UserService userService;
    private final ReportingService reportingService;


    @Autowired
    public RestController(UserService userService, ReportingService reportingService) {
        this.userService = userService;
        this.reportingService = reportingService;
    }

    @PostMapping("generateReport")
    public ResponseEntity generateReport(@RequestBody RequestDto requestDto) throws JRException, FileNotFoundException {
        reportingService.exportReport("pdf");
        log.info(requestDto.toString());
        return null;
    }

    @PostMapping("login")
    public ResponseEntity login(@RequestBody LoginDto loginDto){
        return userService.login(loginDto);
    }
}
