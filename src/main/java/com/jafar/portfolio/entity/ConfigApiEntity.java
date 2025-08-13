package com.jafar.portfolio.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "config_api")
public class ConfigApiEntity {

    @Id
    private String _id;

    private String key;
    private String value;
}
