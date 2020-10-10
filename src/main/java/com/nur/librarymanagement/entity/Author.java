package com.nur.librarymanagement.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="author")
@Data
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id ;

    @Column(name = "n_sname")
    private String n_sname;

    @Column(name = "description")
    private String description;

    @JoinColumn(name = "authorial_book_id")
    @OneToMany(fetch = FetchType.LAZY)
    private List<Book> books;

}
