package com.example.StudentLibraryManagementSystem.Controllers;

import com.example.StudentLibraryManagementSystem.DTO.IssueBookReqDTO;
import com.example.StudentLibraryManagementSystem.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("issueBook")
    public String issueBook(@RequestBody IssueBookReqDTO issueBookReqDTO){

        try{
            return transactionService.issueBook(issueBookReqDTO);
        }catch (Exception e){
            return e.getMessage();
        }

    }

    @GetMapping("/getTxnInfo")
    public String getTransactionEntry(@RequestParam("bookId")Integer bookId, @RequestParam("cardId")Integer cardId){
        return transactionService.getTransactions(bookId,cardId);
    }
}
