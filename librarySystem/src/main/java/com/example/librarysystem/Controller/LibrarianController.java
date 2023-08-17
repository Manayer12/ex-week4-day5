package com.example.librarysystem.Controller;
import com.example.librarysystem.Api.ApiResponse;
import com.example.librarysystem.Model.Librarian;
import com.example.librarysystem.Service.LibrarianService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/librarian")
@RestController
@RequiredArgsConstructor
public class LibrarianController {
    private final LibrarianService librarianService;


    @GetMapping("/get")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(librarianService.getAll());
    }


    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid Librarian librarian){
        librarianService.addLibrarian(librarian);
        return ResponseEntity.status(200).body(new ApiResponse("librarn added"));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Integer id,@RequestBody @Valid Librarian librarian){
        librarianService.updateLibrarian(id,librarian);
        return ResponseEntity.status(200).body(new ApiResponse("librarian updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        librarianService.deleteLibrarian(id);
        return ResponseEntity.status(200).body(new ApiResponse("librarian deleted"));
    }

    @PutMapping("/findbyid/{id}")
    public ResponseEntity update(@PathVariable Integer id){
        librarianService.getLibrarianByid(id);
        return ResponseEntity.status(200).body(new ApiResponse("librarian updated"));
    }
    @PutMapping("/findbyemail/{email}")
    public ResponseEntity update(@PathVariable String email){
        librarianService.getLibrarianbyEmail(email);
        return ResponseEntity.status(200).body(new ApiResponse("librarian updated"));
    }





}
