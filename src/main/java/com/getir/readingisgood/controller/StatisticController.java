package com.getir.readingisgood.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@AllArgsConstructor
@CrossOrigin("*")
@RestController
@RequestMapping("/statistics")
public class StatisticController {

    @GetMapping("/orderCount")
    public ResponseEntity<?> totalOrderCount(){

        return ResponseEntity.ok("asdasd");
    }

}
