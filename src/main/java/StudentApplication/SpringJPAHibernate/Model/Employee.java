package StudentApplication.SpringJPAHibernate.Model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity                     //Used to identify a class as entity(in database)
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)     //
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNoOfChildren() {
        return noOfChildren;
    }

    public void setNoOfChildren(String noOfChildren) {
        this.noOfChildren = noOfChildren;
    }

    public boolean isSpouse() {
        return spouse;
    }

    public void setSpouse(boolean spouse) {
        this.spouse = spouse;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "noofchildren")
    private String noOfChildren;

    @Column(name = "spouse")
    private boolean spouse;

    @Column(name = "age")
    private int age;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", noOfChildren='" + noOfChildren + '\'' +
                ", spouse=" + spouse +
                ", age=" + age +
                ", addressList=" + addressList +
                '}';
    }

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL) //Creates an one to many dependency
    //on two tables
    //
//    @JoinColumn(name = "addressId")
    private List<Address> addressList = new ArrayList<>();

    public Employee(int id, String firstName, String lastName, String noOfChildren, boolean spouse, int age, List<Address> addressList) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.noOfChildren = noOfChildren;
        this.spouse = spouse;
        this.age = age;
        this.addressList = addressList;
    }
}

