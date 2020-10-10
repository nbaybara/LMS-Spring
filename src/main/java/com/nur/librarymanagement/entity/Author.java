package com.nur.librarymanagement.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name="authors")
@NoArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column(name = "n_sname",length = 100, nullable = false,unique = true)
    private String n_sname;

    @Column(name = "description",length = 250, nullable = false)
    private String description;
    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE , CascadeType.REMOVE}, mappedBy = "authors")
    private Set<Book> books = new HashSet<Book>();

    public Author(String n_sname , String description){
        this.n_sname=n_sname;
        this.description=description;
    }


}
