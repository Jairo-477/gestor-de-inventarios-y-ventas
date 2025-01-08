package gestorDeInventariosYVentas.example.service;

import gestorDeInventariosYVentas.example.dto.output.ProductOutputDTO;

public interface ProductService {

    String getStock(Long id);

    void reduceStock (int quantity);

    void increaseStock(int quantity);

    String getPrice(Long id);

    void updatePrice(Double newPrice);

    ProductOutputDTO getProduct();
}
