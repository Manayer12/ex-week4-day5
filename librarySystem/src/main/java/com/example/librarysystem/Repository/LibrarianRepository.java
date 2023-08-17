package com.example.librarysystem.Repository;

import com.example.librarysystem.Model.Book;
import com.example.librarysystem.Model.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibrarianRepository extends JpaRepository<Librarian,Integer> {
    Librarian findLibrarianRepositoryById(Integer id);
    Librarian findLibrarianByEmail(String email);



}
