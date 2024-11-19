package com.vendadelivro.estudo.dto.request;

import com.vendadelivro.estudo.model.State;
import com.vendadelivro.estudo.validator.UniqueValue;

public record StateAddressDTO (
        Long countryId,
        @UniqueValue(domainClass = State.class, fieldName = "stateName") String stateName
) {}
