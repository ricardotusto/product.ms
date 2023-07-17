package ricardo.projetos.product.ms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ricardo.projetos.product.ms.dto.ProductDTO;
import ricardo.projetos.product.ms.model.Product;
import ricardo.projetos.product.ms.repository.ProductRepository;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository repository;

    @Override
    public Optional<ProductDTO> create(ProductDTO request) {
        Product product = new Product(
                request.getName(),
                request.getDescription(),
                request.getPrice(),
                request.isAvailable()
        );

        repository.saveAndFlush(product);

        ProductDTO response = new ProductDTO(
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.isAvailable()
        );

        return Optional.of(response);
    }
}
