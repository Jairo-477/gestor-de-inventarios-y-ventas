package gestorDeInventariosYVentas.example.controller;

import gestorDeInventariosYVentas.example.dto.input.OrderInputDTO;
import gestorDeInventariosYVentas.example.dto.output.CustomerOutputDTO;
import gestorDeInventariosYVentas.example.dto.output.OrderDetailsOutputDTO;
import gestorDeInventariosYVentas.example.dto.output.OrderOutputDTO;
import gestorDeInventariosYVentas.example.model.Order;
import gestorDeInventariosYVentas.example.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderRestController {

    private final OrderService orderService;

    public OrderRestController(OrderService orderService){
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderOutputDTO> createOrder(@RequestBody OrderInputDTO orderInputDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.createOrder(orderInputDTO));
    }

    @GetMapping("/total/{id}")
    public ResponseEntity<String> calculateTotal(@PathVariable Long id){
        orderService.calculateTotal(id);
        return ResponseEntity.ok().body("Total calculated successfully.");
    }

    @PatchMapping("/{idOrder}/add-order-details/{idOrderDetails}")
    public ResponseEntity<String> addOrderDetail(@PathVariable Long idOrder,@PathVariable Long idOrderDetails){
        orderService.addOrderDetail(idOrder,idOrderDetails);
        return ResponseEntity.ok().body("The orderDetails with ID " + idOrderDetails + " has been added to the order with ID " + idOrder);
    }

    @PatchMapping("/{idOrder}/remove-order-details/{idOrderDetails}")
    public ResponseEntity<String> removeOrderDetails(@PathVariable Long idOrder,@PathVariable Long idOrderDetails){
        orderService.removeOrderDetails(idOrder,idOrderDetails);
        return ResponseEntity.ok().body("The order details with ID " + idOrderDetails +
                " has been removed from the order with ID " + idOrder);
    }

    @PatchMapping("/{id}/status/{newStatus}")
    public ResponseEntity<String> changeStatus(@PathVariable Long id,@PathVariable Order.Status newStatus){
        orderService.changeStatus(id, newStatus);
        return ResponseEntity.ok().body("The status of the order with ID " + id +  " has been updated");
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<CustomerOutputDTO> getCustomer(@PathVariable Long id) {
        return ResponseEntity.ok().body(orderService.getCustomer(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderOutputDTO> getOrder(@PathVariable Long id){
        return ResponseEntity.ok().body(orderService.getOrder(id));
    }

    @GetMapping("/{id}/order-details")
    public ResponseEntity<List<OrderDetailsOutputDTO>> getOrdersDetailsByOrder(@PathVariable Long id){
        return ResponseEntity.ok().body(orderService.getOrdersDetailsByOrder(id));
    }

    @PatchMapping("/{id}/completeOrder")
    public ResponseEntity<OrderOutputDTO> completeOrder(@PathVariable Long id){
        return ResponseEntity.ok(orderService.completeOrder(id));
    }

    @GetMapping
    public ResponseEntity<List<OrderOutputDTO>> GetAllOrders(){
        return ResponseEntity.ok(orderService.GetAllOrders());
    }
}
