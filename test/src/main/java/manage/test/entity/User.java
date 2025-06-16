package manage.test.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;

    @Column
    private String Name;

    @Column(name = "user_name")
    private String userName;

    @Column
    private String Password;

    @Column
    private String Email;

    @Column
    private String Phone;

    @Column
    private String Avatar;

    @Column(nullable = false)
    private boolean Status = false;

    @Column
    private String Role;

}
