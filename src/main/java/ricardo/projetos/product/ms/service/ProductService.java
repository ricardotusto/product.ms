package ricardo.projetos.product.ms.service;

import ricardo.projetos.product.ms.dto.ProductDTO;

import java.util.Optional;

public interface ProductService {
    Optional<ProductDTO> create(ProductDTO request);
}
