package com.example.StudentLibraryManagementSystem.DTO;

public class IssueBookReqDTO {

    private int bookId;

    private int cardId;

    public IssueBookReqDTO() {
    }
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }
}
