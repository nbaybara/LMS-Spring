package com.nur.librarymanagement.entity;
import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="publisher")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id ;
    @Column(name = "name", length = 200)
    private String name;

    @Column(name = "description")
    private String description;

    @JoinColumn(name = "assignee_book_id")
    @OneToMany(fetch = FetchType.LAZY)
    private List<Book> books;
}
