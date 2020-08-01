package com.assignment.project.service;

import com.assignment.project.util.WebScraperHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.MalformedURLException;

@Service
@Slf4j
public class ScraperServiceImpl implements ScraperService{

    @Value("${timeout.ms}")
    Integer parseTimeoutMillis;

    public ScraperServiceImpl() {
    }


    @Override
    public String scrapeUrl(String url) throws IOException {
        log.info("loadContents()...start");

        WebScraperHelper scraperHelper = new WebScraperHelper(url, parseTimeoutMillis);

        log.info("Extracting url details...start");

        String dataFromUrl = scraperHelper.getDataFromUrl();

        log.info("loadContents()...completed");
        return dataFromUrl;
    }
}
