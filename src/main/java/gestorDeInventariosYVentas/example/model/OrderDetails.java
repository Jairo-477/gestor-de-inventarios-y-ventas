package gestorDeInventariosYVentas.example.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Service;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "orders details")
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long quantity;

    @Column(nullable = false)
    private Double subTotal;

    public OrderDetails(Long quantity, Double subTotal) {
        this.quantity = quantity;
        this.subTotal = subTotal;
    }
}
