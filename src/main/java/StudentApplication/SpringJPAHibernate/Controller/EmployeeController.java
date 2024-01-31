package StudentApplication.SpringJPAHibernate.Controller;

import StudentApplication.SpringJPAHibernate.Repository.EmployeeRepository;
import StudentApplication.SpringJPAHibernate.Model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")        //Used to create a URL for mapping with requests directed to Table Employee
public class EmployeeController {

    @Autowired                          //Used to create a dependency injection for employeeRepoObj to use
                                        //EmployeeRepository
    EmployeeRepository employeeRepoObj;

    @PostMapping("/signup")
    public Employee save(@RequestBody Employee employeeObj){
        System.out.println(employeeObj);
        Employee employeeResponse = employeeRepoObj.save(employeeObj);

        return  employeeResponse;
    }
}
