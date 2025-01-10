package sg.edu.nus.iss.vttp5b_paf_day21.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.vttp5b_paf_day21.model.Customer;
import sg.edu.nus.iss.vttp5b_paf_day21.repository.CustomerRepository;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.getCustomers();
    }

    public List<Customer> getCustomers(int limit, int offset) {
        return customerRepository.getCustomers(limit, offset);
    }

    public Customer getCustomerById(int id) {
        return customerRepository.getCustomerById(id);
    }

    public Boolean deleteCustomerById(int id) {
        return customerRepository.deleteCustomerById(id);
    }

    public Boolean updateCustomerById(Customer customer) {
        return customerRepository.updateCustomerById(customer);
    }

    public Boolean insertCustomer(Customer customer) {
        return customerRepository.insertNewCustomer(customer);
    }
}
