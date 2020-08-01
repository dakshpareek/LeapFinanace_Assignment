package com.assignment.project.service;


import java.io.IOException;
import java.net.MalformedURLException;

public interface ScraperService {

    String scrapeUrl(String url) throws IOException;
}
