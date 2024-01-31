package StudentApplication.SpringJPAHibernate.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Office {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "companyname")
    private String companyName;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "addressId", referencedColumnName = "addressId")
    private Address address;
}
