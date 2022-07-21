package com.example.reportingsystem.service.impl;

import com.example.reportingsystem.dto.LoginDto;
import com.example.reportingsystem.service.LdapService;
import com.example.reportingsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import java.security.NoSuchAlgorithmException;

@Service
public class UserServiceImpl implements UserService {
    private final LdapService ldapService;

    @Autowired
    public UserServiceImpl(LdapService ldapService) {
        this.ldapService = ldapService;
    }

    @Override
    public ResponseEntity login(LoginDto authRequest){
            DirContext context = ldapService.generateDirContext(authRequest.getUsername(), authRequest.getPassword());
            if (context == null)
                throw new BadCredentialsException("Invalid username or password");
            return (ResponseEntity) ResponseEntity.status(HttpStatus.OK);
    }
}
