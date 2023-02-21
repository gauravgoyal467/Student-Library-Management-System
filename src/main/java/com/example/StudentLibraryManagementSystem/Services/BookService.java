package com.example.StudentLibraryManagementSystem.Services;

import com.example.StudentLibraryManagementSystem.DTO.BookRequuestDTO;
import com.example.StudentLibraryManagementSystem.Models.Author;
import com.example.StudentLibraryManagementSystem.Models.Book;
import com.example.StudentLibraryManagementSystem.Repositories.AuthorRepository;
import com.example.StudentLibraryManagementSystem.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    AuthorRepository authorRepository;

    /*public String addBook(@RequestBody Book book){
        //first we will get the author entity so for that
        int authorId=book.getAuthorVariableName().getId();
        Author author=authorRepository.findById(authorId).get();
        book.setAuthorVariableName(author);

        //getting list of books written
        List<Book> currentBooksWritten=author.getBooksWritten();
        //adding book into the list
        currentBooksWritten.add(book);
        author.setBooksWritten(currentBooksWritten);


        authorRepository.save(author);

     return "Book added successfully";
    }
     */

    public String addBook(@RequestBody BookRequuestDTO bookRequuestDTO) {
        //first we will get the author entity so for that
        int authorId = bookRequuestDTO.getAuthorId();
        //now fetch author entity
        Author author = authorRepository.findById(authorId).get();

        //created book entity to save in db
        Book book = new Book();
        //basic attribute to be set from dto to entity layer

        book.setGenre(bookRequuestDTO.getGenre());
        book.setName(bookRequuestDTO.getName());
        book.setPages(bookRequuestDTO.getPages());

        //Setting the foreign key attr in the child class :
        book.setAuthor(author);


        //getting list of books written
        List<Book> currentBooksWritten = author.getBooksWritten();
        //adding book into the list
        currentBooksWritten.add(book);
        author.setBooksWritten(currentBooksWritten);


        authorRepository.save(author);

        return "Book added successfully";
    }
}
