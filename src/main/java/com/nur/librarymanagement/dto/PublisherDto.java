package com.nur.librarymanagement.dto;

import com.nur.librarymanagement.entity.Book;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublisherDto {

    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String description;



}
