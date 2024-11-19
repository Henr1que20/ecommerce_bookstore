package com.vendadelivro.estudo.service.impl;

import com.vendadelivro.estudo.dto.request.CountryAddressDTO;
import com.vendadelivro.estudo.dto.request.StateAddressDTO;
import com.vendadelivro.estudo.dto.response.CountryResponseDTO;
import com.vendadelivro.estudo.dto.response.StateResponseDTO;
import com.vendadelivro.estudo.model.Country;
import com.vendadelivro.estudo.model.State;
import com.vendadelivro.estudo.repo.CountryRepository;
import com.vendadelivro.estudo.repo.StateRepository;
import com.vendadelivro.estudo.service.AddressService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {
    private CountryRepository countryRepository;
    private StateRepository stateRepository;

    @Autowired
    public AddressServiceImpl(CountryRepository countryRepository, StateRepository stateRepository) {
        this.countryRepository = countryRepository;
        this.stateRepository = stateRepository;
    }


    @Override
    @Transactional
    public CountryResponseDTO registerNewCountry(CountryAddressDTO countryAddressDTO) {
        Country country = new Country(countryAddressDTO.countryName());
        country = countryRepository.save(country);
        return new CountryResponseDTO(country.getId(), country.getCountryName());
    }

    @Override
    @Transactional
    public StateResponseDTO registerNewState(StateAddressDTO stateAddressDTO) {
        Optional<Country> country = Optional.ofNullable(countryRepository.findById(stateAddressDTO.countryId())
                .orElseThrow(() -> new EntityNotFoundException("Country not register!!")));

        State state = new State(stateAddressDTO.stateName(), country.get());

        state = stateRepository.save(state);
        return new StateResponseDTO(state.getId(), state.getStateName(), state.getCountry().getCountryName());
    }
}
