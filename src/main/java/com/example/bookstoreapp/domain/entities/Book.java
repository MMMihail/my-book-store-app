package com.example.bookstoreapp.domain.entities;

import com.example.bookstoreapp.domain.enums.CoverType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//import java.sql.Date;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false)
    private String publisher;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Integer amount;

    @Column(nullable = false)
    private Date published;

    @Column(nullable = false)
    private String language;

    //    @Enumerated(EnumType.STRING)
//    private Language language;

    @Enumerated(EnumType.STRING)
    private CoverType cover;

    @Column(nullable = false)
    private Integer pageNumber;

    @Column(nullable = false)
    private String dimensions;

    @Column(nullable = false)
    private Double weight;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @ManyToOne
    private Category category;

    @ManyToMany
    private List<Author> author;

}
