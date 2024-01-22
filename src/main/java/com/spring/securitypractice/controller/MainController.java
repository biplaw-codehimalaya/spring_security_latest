package com.spring.securitypractice.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/home")
    public ResponseEntity<String> getHomePage(){
        return new ResponseEntity<>("This is Normal HomePage", HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<String> getUserPage(){
        return new ResponseEntity<>("This is User Page. From Secured Endpoint.", HttpStatus.OK);
    }
}
