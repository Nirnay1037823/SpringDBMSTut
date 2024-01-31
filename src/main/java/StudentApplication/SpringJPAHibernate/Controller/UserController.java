package StudentApplication.SpringJPAHibernate.Controller;

import StudentApplication.SpringJPAHibernate.Model.User;
import StudentApplication.SpringJPAHibernate.Repository.UserRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository userRepoObj;
    @PostMapping("/signup")
    public User save(@RequestBody User userObj){
        System.out.println(userObj);
        User userResponse = userRepoObj.save(userObj);

        return userResponse;
    };

    @GetMapping("/")
    public String index() {
        return "Hello!!!";
    }

    //Get All Users
    @GetMapping("/getalluser")
    public List<User> getAlluser(){
        List<User> users = userRepoObj.findAll();
//        System.out.println(users);
        return  users;
    };

    //Delete a user
    @DeleteMapping("/deleteuser")
    public void delete(@RequestBody User userObj){
        userRepoObj.delete(userObj);
    };

//    @GetMapping("/findbyid")
//    public User findByUserId(@RequestParam(name = "id") int id){
//        //Optimal class for null pointer
//        Optional<User> tempObj = userRepoObj.findById((id));
//        if(tempObj.isEmpty()){
//            System.out.println("User id is not found" + id);
//        }
//        return userRepoObj.findById(id).get();
//    }

    //Find user by id
    @GetMapping("/findbyid")
    public User findByUserId(@PathVariable("id") int id){
        //Optimal class for null pointer
        Optional<User> tempObj = userRepoObj.findById((id));
        if(tempObj.isEmpty()){
            System.out.println("User id is not found" + id);
        }
        return userRepoObj.findById(id).get();
    }

    //Delete user by id
    @PostMapping("/deletebyid")
    public void deleteById(@RequestParam(name = "id") int id){
        Optional<User> tempObj = userRepoObj.findById((id));
        try{
            if(!tempObj.isEmpty()){
                userRepoObj.deleteById(id);
                System.out.println("Successfully deleted "+id);
            }
            else{
                System.out.println("No element with such id exists");
            }
        }catch (Exception e){
            System.out.println("Error deleting");
        }
    }

    //Exist by id
    @GetMapping("/existbyid/{id}")
    public Boolean exist(@PathVariable("id") int id){
        return userRepoObj.existsById(id);
    }
}

