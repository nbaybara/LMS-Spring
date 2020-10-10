package com.nur.librarymanagement.util;

import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

@Data
public class TPage<T> {
    private int number;
    private int size;
    private Sort sort; //Kolonlarda sıralama yapmak
    private int totalPages;
    private Long totalElements;
    private List<T> content; //Dönülecek data

    public void setStat(Page page, List<T> list) {
        this.number = page.getNumber();
        this.size = page.getSize();
        this.sort = page.getSort();
        this.totalPages = page.getTotalPages();
        this.totalPages = page.getTotalPages();
        this.totalPages = page.getTotalPages();
        this.totalElements = page.getTotalElements();
        this.content = list;
    }
}
