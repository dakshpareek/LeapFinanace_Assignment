package com.assignment.project.controller;

import com.assignment.project.dto.UrlDTO;
import com.assignment.project.service.ScraperService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;

@RestController
@Slf4j
@CrossOrigin(origins = "https://sheltered-shore-05178.herokuapp.com", maxAge = 3600)
public class ScraperController {

    private ScraperService scraperService;
    public ScraperController(ScraperService scraperService) {
        this.scraperService = scraperService;
    }

    @GetMapping("/")
    public ResponseEntity getHome()
    {
        return ResponseEntity.ok("Welcome To App. Now Login To Make Request");
    }

    @PostMapping("/api/content")
    public ResponseEntity scrapeUrl(@Valid @RequestBody UrlDTO urlDTO) throws IOException {
        String scrapeUrlData = scraperService.scrapeUrl(urlDTO.getUrl());
        return ResponseEntity.ok(scrapeUrlData);
    }

}
