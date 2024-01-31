package StudentApplication.SpringJPAHibernate.Repository;

import StudentApplication.SpringJPAHibernate.Model.User;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}

//1.Application starts by using a thread with PID
//2.application.properties provide the port number to be used
//3.Server initialized in Apache Tomcat server to serve HTTP requests
//4.Default threading profile is used(Hikari pool) as multi-threading has not been configured
//5.Hikari creates another thread for h2
//6.Controller starts running and takes HTTP requests
