package br.edu.ifba.redes.escalonamento.products;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final List<Product> products = List.of(
            new Product(1L, "Notebook", 3500.0),
            new Product(2L, "Mouse", 100.0),
            new Product(3L, "Teclado", 200.0)
    );

    public List<Product> findAll() {
        return products;
    }

    public Product findById(Long id) {
        return products.stream()
                .filter(p -> p.id().equals(id))
                .findFirst()
                .orElseThrow();
    }
}