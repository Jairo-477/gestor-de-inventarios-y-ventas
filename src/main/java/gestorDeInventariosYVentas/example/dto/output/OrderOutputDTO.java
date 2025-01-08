package gestorDeInventariosYVentas.example.dto.output;

import gestorDeInventariosYVentas.example.model.Customer;
import gestorDeInventariosYVentas.example.model.Order;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor

public class OrderOutputDTO {

    private Long id;

    private LocalDateTime date;

    private Double total;

    private Order.Status status;

    private Customer customer;

    public OrderOutputDTO(Long id, LocalDateTime date, Double total, Order.Status status, Customer customer) {
        this.id = id;
        this.date = date;
        this.total = total;
        this.status = status;
        this.customer = customer;
    }
}
