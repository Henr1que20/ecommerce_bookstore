package com.vendadelivro.estudo.controller;

import com.vendadelivro.estudo.dto.request.CountryAddressDTO;
import com.vendadelivro.estudo.dto.request.StateAddressDTO;
import com.vendadelivro.estudo.dto.response.CountryResponseDTO;
import com.vendadelivro.estudo.dto.response.StateResponseDTO;
import com.vendadelivro.estudo.service.AddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/address")
public class AddressController {

    private AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping(value = "/country")
    public ResponseEntity<CountryResponseDTO> registerCountry(@RequestBody @Valid CountryAddressDTO countryAddressDTO) {
        CountryResponseDTO countryResponseDTO = addressService.registerNewCountry(countryAddressDTO);
        return ResponseEntity.ok().body(countryResponseDTO);
    }

    @PostMapping(value = "/state")
    public ResponseEntity<StateResponseDTO> registerState(@RequestBody @Valid StateAddressDTO stateAddressDTO) {
        StateResponseDTO stateResponseDTO = addressService.registerNewState(stateAddressDTO);
        return ResponseEntity.ok().body(stateResponseDTO);
    }
}
