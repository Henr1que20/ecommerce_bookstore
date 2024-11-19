package com.vendadelivro.estudo.service;

import com.vendadelivro.estudo.dto.request.CountryAddressDTO;
import com.vendadelivro.estudo.dto.request.StateAddressDTO;
import com.vendadelivro.estudo.dto.response.CountryResponseDTO;
import com.vendadelivro.estudo.dto.response.StateResponseDTO;

public interface AddressService {
    CountryResponseDTO registerNewCountry(CountryAddressDTO countryAddressDTO);

    StateResponseDTO registerNewState(StateAddressDTO stateAddressDTO);
}
