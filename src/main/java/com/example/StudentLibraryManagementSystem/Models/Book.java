package com.example.StudentLibraryManagementSystem.Models;

import com.example.StudentLibraryManagementSystem.Enums.Genre;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int pages;
    @Enumerated(value = EnumType.STRING)
    private Genre genre;    //self generated enum

    private boolean isIssued;

    //Book is child w.r.t author so setting here the foreign key
    @ManyToOne
    @JoinColumn
    private Author author;  //add an extra attirbute of author id for the foreign key with author(parent)(btw book and author)

    //Book is also child w.r.t card so setting here the foreign key
    @ManyToOne
    @JoinColumn
    private Card card;  //add an extra attirbute of card id for the foreign key with card(parent) (btw book and card)

    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    private List<Transactions> transactionsList=new ArrayList<>();

    public List<Transactions> getTransactionsList() {
        return transactionsList;
    }

    public void setTransactionsList(List<Transactions> transactionsList) {
        this.transactionsList = transactionsList;
    }

    //constructors and getters setters
    public Book() {
    }

    public int getId() { return id;  }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getPages() {
        return pages;
    }
    public void setPages(int pages) {
        this.pages = pages;
    }

    public Genre getGenre() {
        return genre;
    }
    public void setGenre(Genre genre) {
        this.genre = genre;
    }
    public boolean isIssued() { return isIssued; }

    public void setIssued(boolean issued) { isIssued = issued; }

    public Author getAuthor() {
        return author;
    }
    public void setAuthor(Author author) {
        this.author = author;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
