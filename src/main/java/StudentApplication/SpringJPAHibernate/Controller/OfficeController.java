package StudentApplication.SpringJPAHibernate.Controller;

import StudentApplication.SpringJPAHibernate.Model.Office;
import StudentApplication.SpringJPAHibernate.Model.User;
import StudentApplication.SpringJPAHibernate.Repository.OfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @PostMapping("/deletebyid")
    public void deleteById(@RequestParam(name = "id") int id){
        Optional<Office> tempObj = officeRepoObj.findById((id));
        try{
            if(!tempObj.isEmpty()){
                officeRepoObj.deleteById(id);
                System.out.println("Successfully deleted "+id);
            }
            else{
                System.out.println("No element with such id exists");
            }
        }catch (Exception e){
            System.out.println("Error deleting");
        }
    }
}
