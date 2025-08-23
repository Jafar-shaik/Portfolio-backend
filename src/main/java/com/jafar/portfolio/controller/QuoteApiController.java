package com.jafar.portfolio.controller;

import com.jafar.portfolio.service.MyQuoteApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class QuoteApiController {

    @Autowired
    private MyQuoteApiService myQuoteApiService;

    @GetMapping("/quote")
    public ResponseEntity<String > getQuote(){
        String latestQuote = myQuoteApiService.getRandomQuote();
        return ResponseEntity.ok(latestQuote);
    }
}
