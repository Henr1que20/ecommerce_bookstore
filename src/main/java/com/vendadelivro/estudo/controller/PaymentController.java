package com.vendadelivro.estudo.controller;

import com.vendadelivro.estudo.dto.request.PaymentRequestDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payment")
public class PaymentController {

    /*
    * I implemented this validation in 2 ways, one using @InitBinder and the other
    * way I created a custom annotation, now I am validating with the annotation (@Document)
    *
    * @InitBinder
    * public void init(WebDataBinder binder){
    *     binder.addValidators(new ValidadeDocumentCpfCnpjValidator());
    * }
    */


    @PostMapping
    public ResponseEntity<String> payment(@RequestBody @Valid PaymentRequestDTO paymentRequestDTO) {
        return ResponseEntity.ok(paymentRequestDTO.toString());
    }
}
