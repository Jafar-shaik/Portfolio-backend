package com.jafar.portfolio.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "projects")
public class Project {

    @Id
    private String _id;

    private String title;
    private String description;
    private List<String > technologies;
    private String githubUrl;

}
