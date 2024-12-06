package com.vendadelivro.estudo.controller.dataBinderValidator;

import com.vendadelivro.estudo.dto.request.PaymentRequestDTO;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ValidadeDocumentCpfCnpjValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return PaymentRequestDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()){
            return;
        }

        PaymentRequestDTO requestDTO = (PaymentRequestDTO) target;

        if(!requestDTO.validDocument()){
            errors.rejectValue("document", null, "document neet to be CPF or CNPJ");
        }
    }
}
