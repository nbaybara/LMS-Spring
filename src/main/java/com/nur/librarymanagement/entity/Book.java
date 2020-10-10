package com.nur.librarymanagement.entity;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "book_name", length = 4000)
    private String bookName;
    @Column(name = "sub_name", length = 1000)
    private String sub_name;
    @Column(name = "series_name", length = 1000)
    private String series_name;

    @JoinColumn(name = "authorial_book_id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private Book authorial;

    @JoinColumn(name = "assignee_book_id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private Publisher assigne;

    @Column(name = "isbn", length = 1000)
    private String isbn;
    @Column(name = "description", length = 1000)
    private String description;






}
