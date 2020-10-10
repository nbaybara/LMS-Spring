package com.nur.librarymanagement.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {

    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String isbn;
    private String serial_name;
    private String description;
    private String sub_name;


}