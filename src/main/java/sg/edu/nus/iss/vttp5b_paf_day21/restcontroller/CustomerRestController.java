package sg.edu.nus.iss.vttp5b_paf_day21.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.nus.iss.vttp5b_paf_day21.model.Customer;
import sg.edu.nus.iss.vttp5b_paf_day21.service.CustomerService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/customers")
public class CustomerRestController {

    @Autowired
    CustomerService customerService;

    @GetMapping("")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();

        return ResponseEntity.ok().body(customers);
    }

    @GetMapping("/limit")
    public ResponseEntity<List<Customer>> getCustomersByLimitOffset(@RequestParam("limit") int limit, @RequestParam("offset") int offset) {
        List<Customer> customers = customerService.getCustomers(limit, offset);
        return  ResponseEntity.ok().body(customers);
    }

    @GetMapping("/{customer-id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("customer-id") Integer id) {
        Customer customer = customerService.getCustomerById(id);

        return ResponseEntity.ok().body(customer);
    }
    
    @DeleteMapping("/{customer-id}")
    public ResponseEntity<Boolean> deleteCustomerById(@PathVariable("customer-id") Integer id) {
        Boolean customerDeleted = customerService.deleteCustomerById(id);

        return ResponseEntity.ok().body(customerDeleted);
    }

    @PutMapping("/{customer-id}")
    public ResponseEntity<Boolean> updateCustomerById(@PathVariable("customer-id") Integer id, @RequestBody Customer customer) {
        Boolean customerUpdated = customerService.updateCustomerById(customer);
        
        return ResponseEntity.ok().body(customerUpdated);
    }

}
