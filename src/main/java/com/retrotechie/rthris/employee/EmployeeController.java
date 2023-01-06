package com.retrotechie.rthris.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Combination of @Controller & @ResponseBody
@RequestMapping("/api") // Define a base URL for all REST APIs created in this controller
@CrossOrigin("http://localhost:3000") // Connect frontend and backend
public class EmployeeController {
    @Autowired // Inject EmployeeService as a dependency
    private EmployeeService employeeService;

    // CREATE
    // `value` is the endpoint -> full URL: `/api/employee`
    // `method` is the HTTP methods (POST, PUT, GET, DELETE)
    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    // GET
    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    // UPDATE
    @RequestMapping(value = "/employees/{employeeId}", method = RequestMethod.PUT)
    // `@PathVariable` means the API endpoint has a path parameter involved
    // Below code will map `employeeId` value from the endpoint to `id`
    public Employee updateEmployee(@PathVariable(value = "employeeId") Long id,
            @RequestBody Employee employeeDetails) {
        return employeeService.updateEmployee(id, employeeDetails);
    }

    // DELETE
    @RequestMapping(value = "/employees/{employeeId}", method = RequestMethod.DELETE)
    public void deleteEmployee(@PathVariable(value = "employeeId") Long id) {
        employeeService.deleteEmployee(id);
    }
}
