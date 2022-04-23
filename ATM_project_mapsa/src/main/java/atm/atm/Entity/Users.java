package atm.atm.Entity;

import atm.atm.enums.Roles;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "tbl_users")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Users extends BaseClass {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstname;

    private String lastname;

    private String username;

    private String password;

    private Boolean enabled=true;

    @ElementCollection(targetClass = Roles.class)
    @CollectionTable(name = "roles" , joinColumns = @JoinColumn(name = "username",referencedColumnName = "username") )
    @Enumerated(EnumType.STRING)
    private List<Roles> roles;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Users users = (Users) o;
        return id != null && Objects.equals(id, users.id);
    }




}
