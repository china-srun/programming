package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.customerException;
import com.example.demo.model.customerModel;
import com.example.demo.repository.customerRepo;

@RestController
public class customerController {

    @Autowired
    private customerRepo CustomerRepository;


    @GetMapping("/customer")
    List<customerModel> allCustomer() {
        return CustomerRepository.findAll();
    }

    @GetMapping("/customer/{id}")
    customerModel getById(@PathVariable Long id) {
        return CustomerRepository.findById(id).orElseThrow(() -> new customerException(id));
    }

    @PostMapping("/customer")
    customerModel post(@RequestBody customerModel newCustomer) {
        return CustomerRepository.save(newCustomer);
    }

    @DeleteMapping("/customer/{id}")
    void delete (@PathVariable Long id) {
        CustomerRepository.deleteById(id);
    }

    @PutMapping("/customer/{id}")
    customerModel update(@PathVariable Long id, @RequestBody customerModel newCustomer) { 
        return CustomerRepository.findById(id).map(customerModel -> {
            customerModel.setName(newCustomer.getName());
            customerModel.setAge(newCustomer.getAge());
            return CustomerRepository.save(customerModel);
        }).orElseGet(() -> {
            newCustomer.setId(id);
            return CustomerRepository.save(newCustomer);
        });
        // if the updated user does not exist then it will automatically create that specific customer
    }

}
