package org.gfg.JBDL_76_Minor1.controller;

import org.gfg.JBDL_76_Minor1.dto.TxnRequest;
import org.gfg.JBDL_76_Minor1.exception.BookException;
import org.gfg.JBDL_76_Minor1.exception.UserException;
import org.gfg.JBDL_76_Minor1.service.impl.TxnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/txn")
@Validated
public class TxnController {

    @Autowired
    private TxnService txnService;

    @PostMapping("/issue")
    public String create(@RequestBody TxnRequest txnRequest) throws UserException, BookException {
        return txnService.create(txnRequest);
    }

}
// issue
// return
