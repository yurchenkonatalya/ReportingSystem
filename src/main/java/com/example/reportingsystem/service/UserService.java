package com.example.reportingsystem.service;

import com.example.reportingsystem.dto.LoginDto;
import org.springframework.http.ResponseEntity;

import javax.naming.NamingException;
import java.security.NoSuchAlgorithmException;

public interface UserService {
    ResponseEntity login(LoginDto authRequest);
}
