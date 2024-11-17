package org.gfg.JBDL_76_Minor1.controller;

import org.gfg.JBDL_76_Minor1.dto.request.TxnRequest;
import org.gfg.JBDL_76_Minor1.dto.request.TxnReturnRequest;
import org.gfg.JBDL_76_Minor1.exception.BookException;
import org.gfg.JBDL_76_Minor1.exception.UserException;
import org.gfg.JBDL_76_Minor1.service.impl.TxnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
//@Validated
@RequestMapping("/txn")
public class TxnController {

    @Autowired
    private TxnService txnService;

    @PostMapping("/issue")
    public ResponseEntity<String> create(@RequestBody @Validated TxnRequest txnRequest) throws UserException, BookException {
        String txnId =  txnService.create(txnRequest);
        if(txnId != null || !txnId.isEmpty()){
            return new ResponseEntity<>(txnId, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/return")
    public Double returnTxn(@RequestBody TxnReturnRequest txnReturnRequest) throws BookException, UserException {
        return txnService.returnTxn(txnReturnRequest);
    }


}
// issue
// return

// test cases Junit 5
// redis caching
// security :
// minor 2

