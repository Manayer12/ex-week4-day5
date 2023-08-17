package com.example.librarysystem.Service;

import com.example.librarysystem.Api.ApiException;
import com.example.librarysystem.Model.Book;
import com.example.librarysystem.Repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    public void addBook(Book book) {
        bookRepository.save(book);


    }

    public void updateBook(Integer id, Book book) {
        Book oldBook = bookRepository.findBookById(id);
        if (oldBook == null) {
            throw new ApiException("id not found");
        }
        oldBook.setTitle(oldBook.getTitle());
        oldBook.setAuthor(oldBook.getAuthor());
        oldBook.setCategory(oldBook.getCategory());
        oldBook.setISBN(oldBook.getISBN());
        oldBook.setNumberOfPages(oldBook.getNumberOfPages());


        bookRepository.save(book);
    }


    public void deleteBook(Integer id) {
        Book oldBook = bookRepository.findBookById(id);
        if (oldBook == null) {
            throw new ApiException("id not found");
        }
        bookRepository.deleteById(id);
    }

    public List<Book> getallBycategory(String category) {
        List<Book> cate = bookRepository.findBookByCategory(category);
        if (cate.isEmpty()) {
            throw new ApiException("category not found");
        }
        return cate;
    }

    public List<Book> getallByAuthor(String Author) {
        List<Book> ath = bookRepository.findBookByAuthor(Author);
        if (ath.isEmpty()) {
            throw new ApiException("auther not found");
        }
        return ath;
    }

    public List<Book> getallByTitle(String title) {
        List<Book> tit = bookRepository.findByTitle(title);
        if (tit.isEmpty()) {
            throw new ApiException("book not found");
        }
        return tit;
    }

    public Book getpages(Integer numberOfPages) {
        return bookRepository.Pages(numberOfPages);
    }


}