package com.local.onlineshoppingproject.Services;

import com.local.onlineshoppingproject.Entities.Customer;
import com.local.onlineshoppingproject.Exceptions.EmailAlreadyExistsException;
import com.local.onlineshoppingproject.Repositories.CustomerRepo;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class CustomerService {


    private final CustomerRepo customerRepo;
    private final BasketService basketService;

    private final PasswordMigrationService passwordMigrationService;
    @Lazy
    public CustomerService(CustomerRepo customerRepo, PasswordMigrationService passwordMigrationService, BasketService basketService) {
        this.customerRepo = customerRepo;
        this.passwordMigrationService = passwordMigrationService;
        this.basketService = basketService;
    }

    public List<Customer> getAllUsers() {
        return customerRepo.findAll();
    }

    public Customer addNewUser(Customer customer) {
        if (customerRepo.existsByEmail(customer.getEmail())) {
            throw new EmailAlreadyExistsException("Bu emaile sahip bir kullanıcı mevcut.");
        }
        Customer newCustomer = customerRepo.save(customer);
        passwordMigrationService.migratePasswordCustomer(newCustomer);
        basketService.addNewBasketForNewCustomer(newCustomer);
        return newCustomer;
    }

    public Customer getCustomerById(int customerId) {
        return customerRepo.findById(customerId).orElse(null);
    }

    public Customer updateThatCustomer(int customerId, Customer newCustomer) {
        Optional<Customer> customer = customerRepo.findById(customerId);
        if (customer.isPresent()) {

            Customer foundCustomer = customer.get();
            foundCustomer.setName(newCustomer.getName());
            foundCustomer.setSurname(newCustomer.getSurname());
            foundCustomer.setEmail(newCustomer.getEmail());
            foundCustomer.setPassword(newCustomer.getPassword());
            foundCustomer.setAddress(newCustomer.getAddress());
            if(!foundCustomer.getPassword().startsWith("$2a$")) {
                passwordMigrationService.migratePasswordCustomer(foundCustomer);
            }
            return customerRepo.save(foundCustomer);
        } else {
            return null;
        }
    }

    public void deleteThatCustomer(int customerId) {
        customerRepo.deleteById(customerId);
    }

    public List<Customer> addThoseCustomer(List<Customer> customer) {
        return customerRepo.saveAll(customer);
    }

    public List<Customer> getCustomerByName(String customerName) {
        return customerRepo.findAllByName(customerName);
    }

    public Customer getCustomerByMail(String email) {
        Optional<Customer> customer = customerRepo.findByEmail(email);
        return customer.orElse(null);
    }


}

