package com.example.librarysystem.Service;

import com.example.librarysystem.Api.ApiException;
import com.example.librarysystem.Model.Librarian;
import com.example.librarysystem.Repository.LibrarianRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LibrarianService {

    private final LibrarianRepository librarianRepository;

    public List<Librarian> getAll(){
        return librarianRepository.findAll();
    }

    public void addLibrarian(Librarian librarian){
        librarianRepository.save(librarian);


    }

    public void updateLibrarian(Integer id,Librarian librarian){
        Librarian oldLibrarian=librarianRepository.findLibrarianRepositoryById(id);
        if (oldLibrarian==null){
            throw new ApiException("id not found");
        }
        oldLibrarian.setName(oldLibrarian.getName());
        oldLibrarian.setUserName(oldLibrarian.getUserName());
        oldLibrarian.setEmail(oldLibrarian.getEmail());
        oldLibrarian.setPassword(oldLibrarian.getPassword());
        librarianRepository.save(librarian);
    }


    public void deleteLibrarian(Integer id){
        Librarian oldLibrarian=librarianRepository.findLibrarianRepositoryById(id);
        if (oldLibrarian==null){
            throw new ApiException("id not found");
        }
        librarianRepository.deleteById(id);
    }

    public Librarian getLibrarianByid(Integer id){
        Librarian libID=librarianRepository.findLibrarianRepositoryById(id);
        if (libID==null){
            throw new ApiException("id not found");
        }
        return libID;
    }

    public Librarian getLibrarianbyEmail(String Email){
        Librarian libem=librarianRepository.findLibrarianByEmail(Email);
        if (libem==null){
            throw new ApiException("email not found");
        }
        return libem;
    }



}








