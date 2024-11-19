package com.vendadelivro.estudo.dto.request;

import com.vendadelivro.estudo.model.Country;
import com.vendadelivro.estudo.validator.UniqueValue;

public record CountryAddressDTO (
        @UniqueValue(domainClass = Country.class, fieldName = "countryName") String countryName
){}
