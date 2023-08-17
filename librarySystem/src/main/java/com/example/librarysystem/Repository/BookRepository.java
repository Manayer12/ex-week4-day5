package com.example.librarysystem.Repository;

import com.example.librarysystem.Model.Book;
import org.apache.tomcat.jni.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
    Book findBookById(Integer id);
    List<Book> findBookByCategory(String category);
    List<Book>findBookByAuthor(String Author);
    List<Book>findByTitle(String title);



    @Query("select b from Book b where b.numberOfPages>300")
    Book Pages(Integer numberOfPages);



}
