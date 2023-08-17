package com.example.librarysystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty
    @Column(columnDefinition = "varchar(30) not null")
    private String title;
    @NotEmpty
    @Column(columnDefinition = "varchar(20) not null")
    private String Author;
    @NotEmpty
    @Column(columnDefinition = "varchar(30) not null check(category='Academic' or category='Mystery' or category='Novel')")
    private String Category;

    @NotNull
    @Column(columnDefinition = "int (10) MAX(10) not null ")
    private Integer ISBN;

    @Size(min=50)
    @Column(columnDefinition = "int (1000) MIN(50) unique not null ")
    private Integer numberOfPages;
}
