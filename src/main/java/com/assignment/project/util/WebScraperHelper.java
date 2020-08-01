package com.assignment.project.util;

import org.jsoup.Jsoup;

import java.io.IOException;
import java.net.URL;
import org.jsoup.nodes.Document;

public class WebScraperHelper {
    private String pageUrl;
    private Integer pageParseTimeoutMillis;


    public WebScraperHelper(String pageUrl, Integer pageParseTimeoutMillis) {
        super();
        this.pageUrl = pageUrl;
        this.pageParseTimeoutMillis = pageParseTimeoutMillis;
    }

    public String getDataFromUrl() throws IOException
    {
        Document doc = Jsoup.parse(new URL(pageUrl), pageParseTimeoutMillis);
        String text = doc.text();
        return text;
    }
}
