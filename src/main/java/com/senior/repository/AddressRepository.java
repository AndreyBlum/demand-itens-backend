package com.senior.repository;

import com.senior.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Long> {

    Optional<Address> findAddressById(Long id);

    void deleteAddressById(Long id);
}
