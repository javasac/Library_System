package org.gfg.JBDL_76_Minor1.service.impl;

import org.gfg.JBDL_76_Minor1.dto.TxnRequest;
import org.gfg.JBDL_76_Minor1.enums.TxnStatus;
import org.gfg.JBDL_76_Minor1.exception.BookException;
import org.gfg.JBDL_76_Minor1.exception.UserException;
import org.gfg.JBDL_76_Minor1.model.Book;
import org.gfg.JBDL_76_Minor1.model.Txn;
import org.gfg.JBDL_76_Minor1.model.User;
import org.gfg.JBDL_76_Minor1.repository.TxnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
public class TxnService {
    @Autowired
    private TxnRepository txnRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    @Transactional(rollbackFor = {BookException.class, UserException.class})
    public String create(TxnRequest txnRequest) throws UserException, BookException {
        // user is trying to get the book , user is valid or not?
        User userFromDb = userService.checkIfUserIsValid(txnRequest.getUserEmail());
        if(userFromDb == null){
            throw new UserException("User is not valid.");
        }

        // book no he is asking, actually belongs to my library
        Book bookFromDb = bookService.checkIfBookIsValid(txnRequest.getBookNo());
        if(bookFromDb == null){
            throw new BookException("book is not valid.");
        }
        // book a user is asking should not be assigned to some another user?
        if(bookFromDb.getUser() !=null){
            throw new BookException("book is not free to be issued.");
        }
        return createTxn(userFromDb, bookFromDb);

    }
    //t1
    @Transactional(propagation = Propagation.SUPPORTS)
    public String createTxn(User userFromDb, Book bookFromDb) throws BookException {
        // create a txn
        String txnId = UUID.randomUUID().toString();
        Txn txn = Txn.
                builder().
                txnId(txnId).
                user(userFromDb).
                book(bookFromDb).
                txnStatus(TxnStatus.ISSUED).
                issuedDate(new Date()).
                build();
        txnRepository.save(txn);
        if(txn.getSettlementAmount()==null ){
            throw new BookException("exception has been thrown");
        }
        bookService.markBookUnavailable(bookFromDb, userFromDb);
        return txnId;
    }
}
