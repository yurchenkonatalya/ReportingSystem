package com.example.reportingsystem.rest;

import com.example.reportingsystem.dto.LoginDto;
import com.example.reportingsystem.dto.RequestDto;
import com.example.reportingsystem.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.naming.NamingException;
import java.security.NoSuchAlgorithmException;

@Controller
@RequestMapping("/api/reportingService/")
@CrossOrigin(origins = "http://localhost:63342")
@Slf4j
public class RestController {
    private final UserService userService;

    @Autowired
    public RestController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("generateReport")
    public ResponseEntity generateReport(@RequestBody RequestDto requestDto) {
        log.info(requestDto.toString());
        return null;
    }

    @PostMapping("login")
    public ResponseEntity login(@RequestBody LoginDto loginDto){
        return userService.login(loginDto);
    }
}
