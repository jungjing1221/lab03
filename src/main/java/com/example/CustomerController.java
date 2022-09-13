package com.example;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController {
    private List<Customer> customers = new ArrayList<Customer>();

    public CustomerController() {
        Customer customer1 = new Customer("1010", "John", "Male", 25);
        Customer customer2 = new Customer("10108", "Peter", "Male", 24);
        Customer customer3 = new Customer("1019", "Sara", "Female", 23);
        Customer customer4 = new Customer("1110", "Rose", "Female", 23);
        Customer customer5 = new Customer("1001", "Emma", "Female", 30);
        this.customers.add(customer1);
        this.customers.add(customer2);
        this.customers.add(customer3);
        this.customers.add(customer4);
        this.customers.add(customer5);
    }
    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public List<Customer> getCustomers() {
        return this.customers;
    }
    @RequestMapping(value = "/customerbyid/{id}", method = RequestMethod.GET)
    public Customer getCustomerByID(@PathVariable("id") String ID) {
        for(Customer customer : this.customers){
            if(customer.getID().equals(ID)) return customer;
        }
        return new Customer();
    }
    @RequestMapping(value = "/customerbyname/{name}", method = RequestMethod.GET)
    public Customer getCustomerByName(@PathVariable("name") String name) {
        for(Customer customer : this.customers){
            if(customer.getName().equals(name)) return customer;
        }
        return new Customer();
    }
    @RequestMapping(value = "/customerDelByid/{id}", method = RequestMethod.GET)
    public List<Customer> delCustomerByID(@PathVariable("id") String ID) {
        this.customers.removeIf(customer -> customer.getID().equals(ID));
        return this.customers;
    }
    @RequestMapping(value = "/customerDelByname/{n}", method = RequestMethod.GET)
    public List<Customer> delCustomerByName(@PathVariable("n") String n) {
        this.customers.removeIf(customer -> customer.getName().equals(n));
        return this.customers;
    }
    @RequestMapping(value = "/addCustomer", method = RequestMethod.GET)
    public List<Customer> addCustomer(@RequestParam("id") String id, @RequestParam("name") String n, @RequestParam("sex") String s, @RequestParam("age") Integer age) {
        Customer customer = new Customer(id, n, s, age);
        this.customers.add(customer);
        return this.customers;
    }
    @RequestMapping(value = "/addCustomer2", method = RequestMethod.POST)
    public List<Customer> addCustomer2(@RequestParam("id") String id, @RequestParam("name") String n, @RequestParam("sex") String s, @RequestParam("age") Integer age) {
        Customer customer = new Customer(id, n, s, age);
        this.customers.add(customer);
        return this.customers;
    }
}
