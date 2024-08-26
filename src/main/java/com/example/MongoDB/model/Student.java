package com.example.MongoDB.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "StudentCollection")
public class Student {

    @Id
    private int id;
    private String name;
    private int age;
}
