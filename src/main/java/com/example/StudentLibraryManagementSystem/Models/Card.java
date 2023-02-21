package com.example.StudentLibraryManagementSystem.Models;

import com.example.StudentLibraryManagementSystem.Enums.CardStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="card")
public class Card {

    @Id                   //annotation for primary key /foreign key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //auto generation anootation
    private int id;

    @CreationTimestamp   //this annotation will auto save timestamp the time whenever an entry will be created
    private Date createdOn;

    @UpdateTimestamp    //this annotation will auto save timestamp the time whenever an entry will be updated
    private Date updatedOn;

    @Enumerated(value = EnumType.STRING)  //annotation to tell sql to keep this status in string format
    private CardStatus cardstatus;   //Enum

    //annotations for uni-directional mapping with parent class
    @OneToOne
    @JoinColumn
    private Student studentVariableName;  //this variable is used in parent class for bidirectional mapping.

    @OneToMany(mappedBy = "card",cascade =CascadeType.ALL)
    private List<Book> booksIssued;

    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
    private List<Transactions> transactionsLists=new ArrayList<>();

    //constructor & getters setters
    public Card() {
       booksIssued=new ArrayList<>();
    }

    public List<Book> getBooksIssued() {
        return booksIssued;
    }

    public void setBooksIssued(List<Book> booksIssued) {
        this.booksIssued = booksIssued;
    }

    public List<Transactions> getTransactionsLists() {
        return transactionsLists;
    }

    public void setTransactionsLists(List<Transactions> transactionsLists) {
        this.transactionsLists = transactionsLists;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }
    public CardStatus getCardstatus() {
        return cardstatus;
    }
    public void setCardstatus(CardStatus cardstatus) {
        this.cardstatus = cardstatus;
    }

    public Student getStudentVariableName() {
        return studentVariableName;
    }
    public void setStudentVariableName(Student studentVariableName) {
        this.studentVariableName = studentVariableName;
    }
}
