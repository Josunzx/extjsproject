package com.canal.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/szs")
public class IAmSZSBankController {

    @RequestMapping("/messageExchange")
    public void returnBack(HttpServletResponse response) throws IOException {
//        Thread.sleep(5 * 60 * 1000);
        String _RejCode = "signhis.not.amt.error";
        String _RejMsg = "存在历史签章未放款";
        String s = "00000427<?xml version=\"1.0\" encoding=\"UTF-8\"?><Message><Head><_ResponseSystemId>MCA</_ResponseSystemId><_RejCode>"
            + _RejCode
            + "</_RejCode>"
            + "<_RejMsg>"
            + _RejMsg
            + "</_RejMsg><_MCHJnlNo>YXWD_WvjWREJH_2517537</_MCHJnlNo><_TransactionId>per.MCLoanSign</_TransactionId><_MCHTimestamp>2017-10-10 19:19:25.608</_MCHTimestamp>"
            + "<_ProcessState>FL</_ProcessState></Head><Body></Body></Message>";
        s = new String(s.getBytes("utf-8"), "iso-8859-1");
        response.getWriter().write(s);
    }
}
