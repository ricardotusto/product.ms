package ricardo.projetos.product.ms.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ricardo.projetos.product.ms.dto.ProductDTO;
import ricardo.projetos.product.ms.model.Product;
import ricardo.projetos.product.ms.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public Optional<ProductDTO> create(ProductDTO request) {
        request.setAvailable(true);
        Product product = mapper.map(request, Product.class);

        repository.saveAndFlush(product);

        ProductDTO response = mapper.map(product, ProductDTO.class);

        return Optional.of(response);
    }

    @Override
    public List<ProductDTO> getAll() {
        List<Product> products = repository.findAll();
        List<ProductDTO> responses = new ArrayList<>();

        for (Product product : products) {
            ProductDTO response = mapper.map(product, ProductDTO.class);
            responses.add(response);
        }

        return responses;
    }

    @Override
    public Optional<ProductDTO> getById(Long id) {
        Optional<Product> product = repository.findById(id);

        if (product.isPresent()){
            return Optional.of(mapper.map(product, ProductDTO.class));
        }
        return Optional.empty();
    }

    @Override
    public Optional<ProductDTO> update(Long id, ProductDTO request) {
        Optional<Product> product = repository.findById(id);

        if (product.isPresent()){
            product.get().setDescription(request.getDescription());
            product.get().setPrice(request.getPrice());

            return Optional.of(mapper.map(product, ProductDTO.class));
        }

        return Optional.empty();
    }

    // delete logico
    @Override
    public boolean delete(Long id) {
        Optional<Product> product = repository.findById(id);

        if (product.isPresent()){
            product.get().setAvailable(false);
            repository.save(product.get());
            return true;
        }
        return false;
    }

    // delete fisico (elimina o registo do produto )
    private boolean hardDelete(Long id){
        Optional<Product> product = repository.findById(id);
        if (product.isPresent()){
            repository.deleteById(id);
            return true;
        }
        return false;
    }

}
