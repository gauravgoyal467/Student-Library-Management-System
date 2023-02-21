package com.example.StudentLibraryManagementSystem.Services;

import com.example.StudentLibraryManagementSystem.DTO.IssueBookReqDTO;
import com.example.StudentLibraryManagementSystem.Enums.CardStatus;
import com.example.StudentLibraryManagementSystem.Enums.TransactionStatus;
import com.example.StudentLibraryManagementSystem.Models.Book;
import com.example.StudentLibraryManagementSystem.Models.Card;
import com.example.StudentLibraryManagementSystem.Models.Transactions;
import com.example.StudentLibraryManagementSystem.Repositories.BookRepository;
import com.example.StudentLibraryManagementSystem.Repositories.CardRepository;
import com.example.StudentLibraryManagementSystem.Repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    CardRepository cardRepository;

    public String issueBook(IssueBookReqDTO issueBookReqDTO) throws Exception{
        int bookId= issueBookReqDTO.getBookId();
        int cardId=issueBookReqDTO.getCardId();

        //getting book and card entity to set it attribute to  transaction
       Book book=bookRepository.findById(bookId).get();
       Card card=cardRepository.findById(cardId).get();

       //final goal is to make a transaction entity and set its attribute  and save it
        Transactions transactions=new Transactions();


        //setting attributes
        transactions.setBook(book);
        transactions.setCard(card);
        transactions.setTransactionId(UUID.randomUUID().toString());
        transactions.setIssueOperation(true);
        transactions.setTransactionStatus(TransactionStatus.PENDING);


        //validations
        if (book == null || book.isIssued() == true) {
            transactions.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transactions);
            throw new Exception("Book is not available");
        }
        if (card==null || (card.getCardstatus()!= CardStatus.ACTIVATED)) {
            transactions.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transactions);
            throw new Exception("Card is not valid");
        }

        //We have reached a success case now.
        transactions.setTransactionStatus(TransactionStatus.SUCCESS);

        //set attributes of book
        book.setIssued(true);
        //Btw the book and transaction : bidirectional
        List<Transactions> listOfTransactionForBook = book.getTransactionsList();
        listOfTransactionForBook.add(transactions);
        book.setTransactionsList(listOfTransactionForBook);


        //I need to make changes in the card
        //Book and the card
        List<Book> issuedBooksForCard = card.getBooksIssued();
        issuedBooksForCard.add(book);
        card.setBooksIssued(issuedBooksForCard);

        for(Book b: issuedBooksForCard){
            System.out.println(b.getName());
        }

        //Card and the Transaction : bidirectional (parent class)
        List<Transactions> transactionsListForCard = card.getTransactionsLists();
        transactionsListForCard.add(transactions);
        card.setTransactionsLists(transactionsListForCard);

        //save the parent.
        cardRepository.save(card);
        //automatically by cascading : book and transaction will be saved.
        //Saving the parent

        return "Book issued successfully";
    }

    public String getTransactions(int bookId,int cardId){

        List<Transactions> transactionsList = transactionRepository.getTransactionsForBookAndCard(bookId,cardId);

        String transactionId = transactionsList.get(0).getTransactionId();

        return transactionId;
    }
}
