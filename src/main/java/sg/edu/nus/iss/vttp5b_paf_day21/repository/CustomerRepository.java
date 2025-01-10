package sg.edu.nus.iss.vttp5b_paf_day21.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.vttp5b_paf_day21.model.Customer;
import sg.edu.nus.iss.vttp5b_paf_day21.model.exception.ResourceNotFoundException;
import sg.edu.nus.iss.vttp5b_paf_day21.utils.sql;

@Repository
public class CustomerRepository {
    @Autowired
    JdbcTemplate template;

    // paf day 21 - slide 26 / 27
    public List<Customer> getCustomers() {
        List<Customer> customers = new ArrayList<>();

        customers = template.query(sql.sql_getAllCustomers, BeanPropertyRowMapper.newInstance(Customer.class));

        if (customers.isEmpty()) {
            throw new ResourceNotFoundException("No record in Customer table");
        }

        return customers;
    }

    public List<Customer> getCustomers(int limit, int offset) {
        List<Customer> customers = new ArrayList<>();

        SqlRowSet sqlRowSet = template.queryForRowSet(sql.sql_getCustomers_LimitOffset, limit, offset);

        while (sqlRowSet.next()) {
            Customer customer = new Customer();
            customer.setId(sqlRowSet.getInt("id"));;
            customer.setFullname(sqlRowSet.getString("fullname"));
            customer.setEmail(sqlRowSet.getString("email"));
            customers.add(customer);
        }

        if (customers.isEmpty()) {
            throw new ResourceNotFoundException("No record in Customer table");
        }

        return customers;
    }

    public Customer getCustomerById(int id) {

        Customer c = null;
        try {
            c = template.queryForObject(sql.sql_getCustomersById, BeanPropertyRowMapper.newInstance(Customer.class), id);
        } catch (DataAccessException ex) {
            throw new ResourceNotFoundException("Customer with Id " + id + " not found.");
        }

        return c;
    }

    public Boolean deleteCustomerById(int id) {

        int customerDeleted = template.update(sql.sql_deleteCustomerById, id);

        if (customerDeleted > 0) {
            return true;
        }
        return false;
    }

    public Boolean updateCustomerById(Customer customer) {
        int customerUpdated = template.update(sql.sql_updateCustomerById, customer.getFullname(), customer.getEmail(), customer.getId());

        if (customerUpdated > 0) {
            return true;
        }
        return false;
    }

    public Boolean insertNewCustomer(Customer customer) {
        int customerCreated = template.update(sql.sql_insertCustomer, customer.getFullname(), customer.getEmail());

        if (customerCreated > 0) {
            return true;
        }
        return false;

    }
}
