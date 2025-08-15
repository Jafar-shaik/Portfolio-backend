package com.jafar.portfolio.service;

import com.jafar.portfolio.config.AppCache;
import com.jafar.portfolio.entity.QuoteApi;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class QuoteApiService {

    @Value("${api.ninjas.key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AppCache appCache;

    public QuoteApi getQuote(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("X-Api-Key",apiKey);
        HttpEntity<Void> entity = new HttpEntity<>(httpHeaders);
        String url = appCache.getOrDefault("QUOTE",null);
        if(url == null) throw  new RuntimeException("Quote API URL not found in cache!");
        ResponseEntity<QuoteApi[]> response = restTemplate.exchange(url, HttpMethod.GET, entity, QuoteApi[].class);
        QuoteApi[] quotes = response.getBody();
        if (quotes == null || quotes.length==0){
            throw  new RuntimeException("Quote is not generated ");
        }
        return quotes[0];
    }

    @PostConstruct
    public void fetchQuoteOnStartup() {
        try {
            QuoteApi quoteApi = getQuote();
            appCache.put("LATEST_QUOTE", quoteApi.getQuote());
            System.out.println("🚀 Fetched initial quote on startup: " + quoteApi.getQuote());
        } catch (Exception e) {
            System.err.println("❌ Failed to fetch initial quote: " + e.getMessage());
        }
    }


    public void fetchQuoteApiPeriodically(){
        try {
            QuoteApi quoteApi = getQuote();
            appCache.put("LATEST_QUOTE", quoteApi.getQuote());
            System.out.println("✅ Updated latest quote: " + quoteApi.getQuote());
        } catch (Exception e) {
            System.err.println("❌ Failed to fetch quote: " + e.getMessage());
        }
    }

    public String getLatestQuote(){
        return appCache.getOrDefault("LATEST_QUOTE","No Quote available yet");
    }

}
