package com.example.StudentLibraryManagementSystem.Services;

import com.example.StudentLibraryManagementSystem.DTO.AuthorEntryDTO;
import com.example.StudentLibraryManagementSystem.DTO.AuthorResponseDTO;
import com.example.StudentLibraryManagementSystem.DTO.BookResponseDTO;
import com.example.StudentLibraryManagementSystem.Models.Author;
import com.example.StudentLibraryManagementSystem.Models.Book;
import com.example.StudentLibraryManagementSystem.Repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;

   /* public String addAuthor(Author author){
        authorRepository.save(author);
        return "Author added Successfully";
    }*/

    public String addAuthor(AuthorEntryDTO authorEntryDTO){



        Author author=new Author();

        //we are setting its attributes so that we can save correct values in db
        author.setName(authorEntryDTO.getName());
        author.setAge(authorEntryDTO.getAge());
        author.setCountry(authorEntryDTO.getCountry());
        author.setRating(authorEntryDTO.getRating());

        authorRepository.save(author);
        return "Author added Successfully";
    }

    public AuthorResponseDTO getAuthor(Integer authorId){

        Author author =  authorRepository.findById(authorId).get();
        AuthorResponseDTO authorResponseDTO = new AuthorResponseDTO();
        //Set its attributes.
        //List<Book> --> List<BookResponseDto>
        List<Book> bookList = author.getBooksWritten();

        List<BookResponseDTO> booksWrittenDto =new ArrayList<>();

        for(Book b : bookList){

            BookResponseDTO bookResponseDto = new BookResponseDTO();
            bookResponseDto.setGenre(b.getGenre());
            bookResponseDto.setPages(b.getPages());
            bookResponseDto.setName(b.getName());

            booksWrittenDto.add(bookResponseDto);
        }
        //Set attributes for authorResponse Dto
        authorResponseDTO.setBooksWritten(booksWrittenDto);
        authorResponseDTO.setName(author.getName());
        authorResponseDTO.setAge(author.getAge());
        authorResponseDTO.setRating(author.getRating());

        return authorResponseDTO;

    }


}
