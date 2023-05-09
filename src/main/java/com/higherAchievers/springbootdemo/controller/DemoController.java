package com.higherAchievers.springbootdemo.controller;

import com.higherAchievers.springbootdemo.dto.LoginRequest;
import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DemoController {

    @GetMapping("/greeting")
    public String greeting() {
        return "Hello guys";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "You're welcome to our class";
    }

    @PostMapping
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        String message;
        if (request.getUsername().equalsIgnoreCase("iacademy") &&
        request.getPassword().equalsIgnoreCase("1234")) {
            message = "You successfully logged in!";
            return ResponseEntity.ok(message);
        } else  {
            message = "Wrong Credentials entered!";
            return ResponseEntity.badRequest().body(message);
        }
    }

}
