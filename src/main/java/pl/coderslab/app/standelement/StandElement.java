package pl.coderslab.app.standelement;

import lombok.*;
import pl.coderslab.app.standitem.StandItem;
import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Data
@Entity
@ToString
@NoArgsConstructor
public class StandElement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "standElements", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<StandItem> standItems;

    private String element;
    private double price;
    private String type;
    private String description;

}
