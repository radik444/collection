package controller;

import com.example.collection.Employee;
import com.example.collection.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("employee")

public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/add")
    public Employee addEmployee(@RequestParam("firstName") String name,
                                @RequestParam("lastName") String surnane){
        return employeeService.addEmployee(name, surnane);

    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam("firstName") String name,
                                @RequestParam("lastName") String surnane){
        return employeeService.findEmployee(name, surnane);

    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam("firstName") String name,
                                @RequestParam("lastName") String surnane){
        return employeeService.removeEmployee(name, surnane);
    }
    @GetMapping("/all")
    public List<Employee> getAll(){
        return employeeService.getAll();
    }
}
