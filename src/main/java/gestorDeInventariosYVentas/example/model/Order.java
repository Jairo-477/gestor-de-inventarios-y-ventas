package gestorDeInventariosYVentas.example.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime date;

    @Column(nullable = false)
    private Double total;

    @Column(nullable = false)
    private Status status;

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
