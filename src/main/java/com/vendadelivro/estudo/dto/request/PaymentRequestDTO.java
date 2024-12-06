package com.vendadelivro.estudo.dto.request;

import com.vendadelivro.estudo.validator.Document;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import org.springframework.util.Assert;

public record PaymentRequestDTO(
        @NotBlank @Email String email,
        @NotBlank String name,
        @NotBlank String surname,
        @NotBlank @Document String document,
        @NotBlank String address,
        @NotBlank String complement,
        @NotBlank String city,
        @NotBlank String countryId,
        String stateId,
        @NotBlank String telephone,
        @NotBlank String cep
) {
    public boolean validDocument() {
        Assert.hasLength(document, "document must exist for this method to be called");

        CPFValidator cpfValidator = new CPFValidator();
        cpfValidator.initialize(null);

        CNPJValidator cnpjValidator = new CNPJValidator();
        cnpjValidator.initialize(null);

        return cpfValidator.isValid(document, null) || cnpjValidator.isValid(document, null);
    }
}
