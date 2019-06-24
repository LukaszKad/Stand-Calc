package pl.coderslab.app.standcart;

import lombok.*;
import pl.coderslab.app.standitem.StandItem;
import pl.coderslab.app.user.User;
import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
@ToString
public class StandCart {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double totalSum;

    @OneToOne
    private User user;

    @OneToMany(mappedBy = "standCart")
    private List<StandItem> standItems;

}
