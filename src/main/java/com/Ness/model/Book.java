package com.Ness.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Table(name = "Book", uniqueConstraints = {
        @UniqueConstraint(name = "book_title_unique", columnNames = "title")}
)
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Book {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @SequenceGenerator(name = "book_sequence", sequenceName = "book_sequence", allocationSize = 1)
    @Column(name = "id", updatable = false, columnDefinition = "INTEGER")
    private Long id;

    @Column(name = "title", nullable = false, columnDefinition = "TEXT")
    private String title;

    @Column(name = "author", nullable = false, columnDefinition = "TEXT")
    private String author;
}
