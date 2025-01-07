package gestorDeInventariosYVentas.example.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "orders")
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime date;

    @Column(nullable = false)
    private Double total;

    @Column(nullable = false)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "order")
    private List<OrderDetails> orderDetailsList;

    public Order(LocalDateTime date, Double total, Status status) {
        this.date = date;
        this.total = total;
        this.status = status;
    }

    public enum Status{
        PENDING,
        COMPLETED
    }
}
