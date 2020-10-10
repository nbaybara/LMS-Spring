package com.nur.librarymanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Publisher {
    private int id;
    private String name;
    private  String description;
}
