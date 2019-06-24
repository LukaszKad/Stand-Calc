package pl.coderslab.app.standitem;

import lombok.*;
import pl.coderslab.app.standelement.StandElement;
import pl.coderslab.app.standcart.StandCart;

import javax.persistence.*;

@Setter
@Getter
@Entity
@ToString
public class StandItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public StandItem(StandElement standElements, Integer quantity) {
        this.standElements = standElements;
        this.quantity = quantity;
    }

    @ManyToOne
    private StandElement standElements;

    @ManyToOne
    private StandCart standCart;

    private Integer quantity;
}


