package gestorDeInventariosYVentas.example.controller;

import gestorDeInventariosYVentas.example.dto.input.ProductInputDTO;
import gestorDeInventariosYVentas.example.dto.output.ProductOutputDTO;
import gestorDeInventariosYVentas.example.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
public class ProductRestController {

    private final ProductService productService;

    public ProductRestController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductOutputDTO> createProduct(@RequestBody ProductInputDTO productInputDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(productInputDTO));
    }

    @GetMapping("/{id}/stock")
    public ResponseEntity<String> getStock(@PathVariable Long id){
        return  ResponseEntity.ok().body(productService.getStock(id));
    }

    @PatchMapping("/{id}/quantity/{quantity}")
    public ResponseEntity<String> reduceStock(@PathVariable Long id,@PathVariable Long quantity){
        productService.reduceStock(id, quantity);
        return ResponseEntity.ok().body("The stock of the product with the ID " + id + " has been reduced.");
    }

    @PatchMapping("/{id}/increases/{quantity}")
    public ResponseEntity<String> increaseStock(Long id,Long quantity){
        productService.increaseStock(id, quantity);
        return ResponseEntity.ok().body("The stock of the product with ID " + id + " has been increased.");
    }

    @GetMapping("/{id}/price")
    public ResponseEntity<String> getPrice(@PathVariable Long id){
        return ResponseEntity.ok().body(productService.getPrice(id));
    }

    @PatchMapping("/{id}/price/{newPrice}")
    public ResponseEntity<String> updatePrice(@PathVariable Long id,@PathVariable Double newPrice){
        productService.updatePrice(id,newPrice);
        return ResponseEntity.ok().body("The price of the product with ID " + id + " has been updated.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductOutputDTO> getProduct(@PathVariable Long id){
        return ResponseEntity.ok().body(productService.getProduct(id));
    }
}
