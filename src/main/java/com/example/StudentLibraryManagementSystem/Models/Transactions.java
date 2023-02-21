package com.example.StudentLibraryManagementSystem.Models;

import com.example.StudentLibraryManagementSystem.Enums.TransactionStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="transactions")
public class Transactions {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;

   @Enumerated(value = EnumType.STRING)
    private TransactionStatus transactionStatus;

    private int totalFine;
    private String transactionId= UUID.randomUUID().toString();
    @CreationTimestamp
    private Date transactionDate;
    private Boolean isIssueOperation;

    //for connecting with book
    @ManyToOne
    @JoinColumn
    private Book book;  //this variable is used in parent class for bidirectional mapping.

    //for connecting with card class
    @ManyToOne
    @JoinColumn
    private Card card;  //this variable is used in parent class for bidirectional mapping.

    public Transactions() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }
    public void setTransactionStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public int getTotalFine() {
        return totalFine;
    }

    public void setTotalFine(int totalFine) {
        this.totalFine = totalFine;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Boolean getIssueOperation() {
        return isIssueOperation;
    }

    public void setIssueOperation(Boolean issueOperation) {
        isIssueOperation = issueOperation;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card= card;
    }
}
