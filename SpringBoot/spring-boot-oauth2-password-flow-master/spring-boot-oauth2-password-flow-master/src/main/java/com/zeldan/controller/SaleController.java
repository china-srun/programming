package com.zeldan.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sale")
public class SaleController {
    
    @RequestMapping(method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('PRIVILEGE_SALE_INVOICE')")
    public ResponseEntity<String> getInvoice() {
        return new ResponseEntity<>("Response Invoice", HttpStatus.OK);
    }

    @RequestMapping(value = {"create"},method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('PRIVILEGE_SALE_INVOICE_CREATE')")
    public ResponseEntity<String> createinvoice() {
        return new ResponseEntity<>("Create Invoice", HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('PRIVILEGE_SALE_INVOICE_UPDATE')")
    public ResponseEntity<String> updateInvoice() {
        return new ResponseEntity<>("Update Invoice", HttpStatus.OK);
    }
}
