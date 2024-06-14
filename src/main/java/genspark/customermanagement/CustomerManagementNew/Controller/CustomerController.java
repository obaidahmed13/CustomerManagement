package CustomerManagmentSystem.Controller;

import CustomerManagmentSystem.Entity.Customer;
import CustomerManagmentSystem.Service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    private Logger logger = LoggerFactory.getLogger("LoggingController.class");

    @GetMapping
    public List<Customer> getAllCustomers() {
        logger.info("Retrieved all the customers");
        return customerService.getAllCustomers();
    }

    @GetMapping("/get/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    @GetMapping("/get/name/{name}")
    public List<Customer> getCustomerByName(@PathVariable String name) {
        return customerService.getCustomerByName(name);
    }
    @GetMapping("/get/firstname/{firstName}")
    public List<Customer> getCustomerByFirstName(@PathVariable String firstName) {
        return customerService.getCustomerByFirstName(firstName);
    }


        @GetMapping("/get/lastname/{lastName}")
    public List<Customer> getCustomerByLastName(@PathVariable String lastName) {
        return customerService.getCustomerByLastName(lastName);
    }
          @GetMapping("/get/phonenumber/{phoneNumber}")
    public List<Customer> getCustomerByPhoneNumber(@PathVariable String phoneNumber) {
        return customerService.getCustomerByLastName(phoneNumber);
    }

    @PostMapping("/create")
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }
//    @DeleteMapping("/{id}")
//    public void deleteCustomer(@RequestBody Long id) {
//        customerService.deleteCustomer(id);
//    }




}
