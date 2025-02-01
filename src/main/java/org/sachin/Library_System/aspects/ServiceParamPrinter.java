package org.sachin.Library_System.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.sachin.Library_System.dto.request.TxnRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceParamPrinter {
    private static final Logger log = LoggerFactory.getLogger(ServiceParamPrinter.class);


    @Pointcut("execution(* org.gfg.JBDL_76_Minor1.service.impl.TxnService.create(org.gfg.JBDL_76_Minor1.dto.request.TxnRequest))")
    public void txnServiceCreateMethod(){}

    @Before(value = "txnServiceCreateMethod() && args(txnRequest)")
    public void txnServiceAdvice(TxnRequest txnRequest){
        log.info("txnRequest is : "+txnRequest);
    }
}
