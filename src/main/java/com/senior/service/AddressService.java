package com.senior.service;

import com.senior.exception.UserNotFoundException;
import com.senior.model.Address;
import com.senior.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AddressService {
    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address add(Address address) {
        return addressRepository.save(address);
    }

    public List<Address> findAllAddress() {
        return addressRepository.findAll();
    }

    public Address update(Long id, Address addressUpdated) {
        Address address = this.findAddressId(id);

        address.setCEP(addressUpdated.getCEP());
        address.setCity(addressUpdated.getCity());
        address.setCountry(addressUpdated.getCountry());
        address.setState(addressUpdated.getState());
        address.setPatio(addressUpdated.getPatio());
        address.setDistrict(addressUpdated.getDistrict());
        address.setNumber(addressUpdated.getNumber());

        return addressRepository.save(address);
    }

    public Address findAddressId(Long id) {
        return addressRepository.findAddressById(id)
                .orElseThrow(() -> new UserNotFoundException("Address by id " + id + " was not found"));
    }

    public void deleteAdress(Long id) {
        addressRepository.deleteAddressById(id);
    }

    public Page<Address> findPage(Pageable pageable) {
        return addressRepository.findAll(pageable);
    }
}
