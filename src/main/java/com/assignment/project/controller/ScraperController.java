package com.assignment.project.controller;

import com.assignment.project.dto.UrlDTO;
import com.assignment.project.service.ScraperService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.IOException;

@RestController
@Slf4j
public class ScraperController {

    private ScraperService scraperService;
    public ScraperController(ScraperService scraperService) {
        this.scraperService = scraperService;
    }

    @PostMapping("/content")
    public ResponseEntity scrapeUrl(@Valid @RequestBody UrlDTO urlDTO) throws IOException {
        String scrapeUrlData = scraperService.scrapeUrl(urlDTO.getUrl());
        return ResponseEntity.ok(scrapeUrlData);
    }

}
