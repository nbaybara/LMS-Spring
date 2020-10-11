package com.nur.librarymanagement.dto;

import com.nur.librarymanagement.entity.Author;
import com.nur.librarymanagement.entity.Publisher;
import com.sun.istack.NotNull;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookDto {

    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String isbn;
    private String serial_name;
    private String description;
    private String sub_name;
    private Publisher publisher;
    private Author author;


}
