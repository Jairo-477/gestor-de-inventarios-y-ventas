package gestorDeInventariosYVentas.example.dto.output;

import gestorDeInventariosYVentas.example.model.Order;
import gestorDeInventariosYVentas.example.model.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderDetailsOutputDTO {

    private Long id;

    private Long quantity;

    private Double subTotal;

    private Long product;

    private Long order;

    public OrderDetailsOutputDTO(Long id, Long quantity, Double subTotal, Long product, Long order) {
        this.id = id;
        this.quantity = quantity;
        this.subTotal = subTotal;
        this.product = product;
        this.order = order;
    }
}
