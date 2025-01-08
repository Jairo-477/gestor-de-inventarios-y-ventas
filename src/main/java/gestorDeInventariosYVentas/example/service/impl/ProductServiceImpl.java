package gestorDeInventariosYVentas.example.service.impl;

import gestorDeInventariosYVentas.example.dto.output.ProductOutputDTO;
import gestorDeInventariosYVentas.example.service.ProductService;

public class ProductServiceImpl implements ProductService {

    @Override
    public String getStock(Long id) {
        return "";
    }

    @Override
    public void reduceStock(int quantity) {

    }

    @Override
    public void increaseStock(int quantity) {

    }

    @Override
    public String getPrice(Long id) {
        return "";
    }

    @Override
    public void updatePrice(Double newPrice) {

    }

    @Override
    public ProductOutputDTO getProduct() {
        return null;
    }
}
