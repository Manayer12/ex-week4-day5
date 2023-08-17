package com.example.librarysystem.Controller;
import com.example.librarysystem.Api.ApiResponse;
import com.example.librarysystem.Model.Book;
import com.example.librarysystem.Service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/Book")
@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;


    @GetMapping("/get")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(bookService.getAll());
    }


    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid Book book){
        bookService.addBook(book);
        return ResponseEntity.status(200).body(new ApiResponse("Book added"));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Integer id,@RequestBody @Valid Book book){
        bookService.updateBook(id,book);
        return ResponseEntity.status(200).body(new ApiResponse("Book updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        bookService.deleteBook(id);
        return ResponseEntity.status(200).body(new ApiResponse("Book deleted"));
    }

    @GetMapping("/searchcat/{category}")
    public ResponseEntity getallBycategory(@PathVariable String category){
        return ResponseEntity.status(200).body(bookService.getallBycategory(category));

    }

    @GetMapping("/searchauth/{Author}")
    public ResponseEntity getallByAuthor(@PathVariable String Author){
        return ResponseEntity.status(200).body(bookService.getallByAuthor(Author));

    }
    @GetMapping("/getpages")
    public ResponseEntity getallBycategory(Integer numberOfPages){
        return ResponseEntity.status(200).body(bookService.getpages(numberOfPages));

    }

    @GetMapping("/gettitle/{title}")
    public ResponseEntity getallByTitle(String title){
        return ResponseEntity.status(200).body(bookService.getallByTitle(title));

    }




}
