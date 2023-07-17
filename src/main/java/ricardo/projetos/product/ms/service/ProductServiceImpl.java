package ricardo.projetos.product.ms.service;

import org.modelmapper.ModelMapper;
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

        ModelMapper mapper = new ModelMapper();

        Product product = mapper.map(request, Product.class);

        repository.saveAndFlush(product);

        ProductDTO response = mapper.map(product, ProductDTO.class);

        return Optional.of(response);
    }
}
