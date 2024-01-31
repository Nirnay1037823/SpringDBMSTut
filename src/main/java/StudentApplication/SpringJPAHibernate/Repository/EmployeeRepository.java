package StudentApplication.SpringJPAHibernate.Repository;

import StudentApplication.SpringJPAHibernate.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //This annotation helps in indicating that this class is a repository i.e. it is used
           //to create, update and manipulate the data from Database
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    //Creates an interface to be used for dependency injection of Jpa Repository(de coupling)
    //Contains methods like saveAll, deleteById, exists etc (CRUD Repo)
}
