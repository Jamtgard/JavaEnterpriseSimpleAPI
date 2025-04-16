package org.example.sjindividuellainlamning.services;

import org.example.sjindividuellainlamning.entities.Address;
import org.example.sjindividuellainlamning.exceptions.ResourceNotFoundException;
import org.example.sjindividuellainlamning.repositories.AddressRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class AddressServiceImpl implements AddressServiceInterface {

    private final AddressRespository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRespository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address getAddressById(int id) {
        return addressRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Member", "id", id));
    }
}
