package com.retail.storeapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.retail.storeapi.controller.dto.GreetingResponse;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("greetings")
@Slf4j
public class GreetingsController {

    @GetMapping
    public ResponseEntity<GreetingResponse> hello() {
        log.info("@==> sending response");
        return ResponseEntity.status(HttpStatus.OK)
                .body(GreetingResponse.builder()
                        .message("Hello")
                        .build());
    }
}
