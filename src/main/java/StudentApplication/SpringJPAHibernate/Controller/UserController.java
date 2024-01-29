package StudentApplication.SpringJPAHibernate.Controller;

import StudentApplication.SpringJPAHibernate.Model.User;
import StudentApplication.SpringJPAHibernate.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/getalluser")
    public List<User> getAlluser(){
        List<User> users = userRepoObj.findAll();
        System.out.println(users);

        return  users;
    };

    @DeleteMapping("/deleteuser")
    public void delete(@RequestBody User userObj){
        userRepoObj.delete(userObj);
    };
}

