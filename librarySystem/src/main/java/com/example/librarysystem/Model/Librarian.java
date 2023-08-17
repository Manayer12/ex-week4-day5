package com.example.librarysystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Librarian {
    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;

@Column(columnDefinition = "varchar(20) not null")
@NotEmpty
private String name;

@Column(columnDefinition = "varchar(20) not null")
@NotEmpty
private String userName;

@Column(columnDefinition = "varchar(30) not null unique")
@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{7,}$")
private String password;

@Email
@Column(columnDefinition = "varchar(30) not null unique ")
private String email;






}
