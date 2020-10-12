package com.nur.librarymanagement.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "isbn", length =50, unique = true )
    private String isbn;
    @Column(name = "name", length = 1000)
    private String name;
    @Column(name = "sub_name", length = 50)
    private String sub_name;
    @Column(name = "serial_name", length = 50)
    private String serial_name;

    @Column(name = "description", length =250)
    private String description;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.REMOVE})
    @JoinTable(name = "books_publishers", joinColumns = {@JoinColumn(name = "book_id")}, inverseJoinColumns = {
            @JoinColumn(name = "publisher_id")})
    private Set<Publisher> publishers = new HashSet<Publisher>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "books_authors", joinColumns = { @JoinColumn(name = "book_id") }, inverseJoinColumns = {
            @JoinColumn(name = "author_id") })
    private Set<Author> authors = new HashSet<Author>();

    public Book(String bookName, String sub_name, String serial_name, String isbn, String description) {
        this.name = bookName;
        this.sub_name = sub_name;
        this.serial_name = serial_name;
        this.isbn = isbn;
        this.description = description;
    }
    public void addAuthors(Author author) {
        this.authors.add(author);
        author.getBooks().add(this);
    }
    public void addPublishers(Publisher publisher) {
        this.publishers.add(publisher);
        publisher.getBooks().add(this);
    }


}
