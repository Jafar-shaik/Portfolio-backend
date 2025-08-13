package com.jafar.portfolio.config;

import com.jafar.portfolio.entity.ConfigApiEntity;
import com.jafar.portfolio.repository.ConfigApiEntityRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public class AppCache {

    @Autowired
    private ConfigApiEntityRepository configApiEntityRepository;

    private final HashMap<String, String> appCache = new HashMap<>();

    @PostConstruct
    public void init() {
        List<ConfigApiEntity> all = configApiEntityRepository.findAll();
        for (ConfigApiEntity configApiEntity : all) {
            appCache.put(configApiEntity.getKey(), configApiEntity.getValue());
        }
        System.out.println("🚀 AppCache initialized with keys: " + appCache.keySet());
    }

    public HashMap<String, String> getAppCache() {
        return appCache;
    }

    public String getOrDefault(String key, String defaultValue) {
        return appCache.getOrDefault(key, defaultValue);
    }

    public void put(String key, String value) {
        appCache.put(key, value);
    }
}
