package ua.com.kisit.courseshop2025.service;

import org.springframework.stereotype.Service;
import ua.com.kisit.courseshop2025.entity.Address;
import ua.com.kisit.courseshop2025.repository.AddressRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> findAllAddress() {

        // List<Address> addresses = new ArrayList<>();
        // select * from table
        // addressRepository.findAll().forEach(addresses::add);

        return addressRepository.findAll();
    }

    public Address findAddressById(Long id) {
        return addressRepository.findById(id).orElse(null);
    }

    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    public Address updateAddress(Address address) {
        return addressRepository.save(address);
    }

    public void deleteAddress(Address address) {
        addressRepository.delete(address);
    }

    public void deleteAddressById(Long id) {
        addressRepository.deleteById(id);
    }

    public void deleteAllAddress() {
        addressRepository.deleteAll();
    }

}
