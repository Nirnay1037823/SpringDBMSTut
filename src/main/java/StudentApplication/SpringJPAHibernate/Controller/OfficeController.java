package StudentApplication.SpringJPAHibernate.Controller;

import StudentApplication.SpringJPAHibernate.Model.Office;
import StudentApplication.SpringJPAHibernate.Repository.OfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/office")
public class OfficeController {

    @Autowired
    OfficeRepository officeRepoObj;

    @PostMapping("/signup")
    public Office save(@RequestBody Office officeObj){
        System.out.println(officeObj);
        Office officeResponse = officeRepoObj.save(officeObj);

        return officeResponse;
    }
}
