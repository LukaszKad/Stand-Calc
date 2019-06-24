package pl.coderslab.app.user;

import io.micrometer.core.lang.Nullable;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import pl.coderslab.app.standcart.StandCart;

import javax.persistence.*;
import javax.validation.constraints.*;

@Getter
@Setter
@Entity
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private StandCart standCart;

    @NotBlank(message = "pole nie może być puste")
    @Column(unique = true)
    private String username;

    @NotBlank(message = "pole nie może być puste")
    @Length(min = 4, message = "Hasło dłuższe niż 4 znaki")
    private String password;

    @Email
    @Column(unique = true)
    @NotBlank(message = "pole nie może być puste")
    private String email;


    @Nullable
    private String firstName;

    @Nullable
    private String lastName;

    private boolean enabled = true;


    @Nullable
    private String companyName;

    @Nullable
    private String phone;

    @Nullable
    private String nip;

    @Nullable
    private String description;

}
