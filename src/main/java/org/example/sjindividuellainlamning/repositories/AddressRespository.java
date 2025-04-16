package org.example.sjindividuellainlamning.repositories;

import org.example.sjindividuellainlamning.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRespository extends JpaRepository<Address, Integer> {

}
