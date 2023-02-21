package com.example.StudentLibraryManagementSystem.Controllers;

import com.example.StudentLibraryManagementSystem.DTO.AuthorEntryDTO;
import com.example.StudentLibraryManagementSystem.DTO.AuthorResponseDTO;
import com.example.StudentLibraryManagementSystem.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("author")
public class AuthorController {

    @Autowired
    AuthorService authorService;


    @PostMapping("/addAuthor")
    public String addAuthor(@RequestBody AuthorEntryDTO authorEntryDTO){
        return authorService.addAuthor(authorEntryDTO);
    }

   /* @PostMapping("/addAuthor")
    public String addAuthor(@RequestBody Author author){
        return authorService.addAuthor(author);
    }
    */
   @GetMapping("/getAuthor")
   public AuthorResponseDTO getAuthor(@RequestParam("authorId")Integer authorId){
       return authorService.getAuthor(authorId);
   }
}
