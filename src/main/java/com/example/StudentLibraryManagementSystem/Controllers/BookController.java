package com.example.StudentLibraryManagementSystem.Controllers;

import com.example.StudentLibraryManagementSystem.DTO.BookRequuestDTO;
import com.example.StudentLibraryManagementSystem.Models.Book;
import com.example.StudentLibraryManagementSystem.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("book")
public class BookController {

    @Autowired
    BookService bookService;

   /* @PostMapping("/addBook")
    public String addBook(Book book){
        return bookService.addBook(book);
    }

    */
   @PostMapping("/addBook")
   public String addBook(@RequestBody BookRequuestDTO bookRequuestDTO){
       return bookService.addBook(bookRequuestDTO);
   }
}
