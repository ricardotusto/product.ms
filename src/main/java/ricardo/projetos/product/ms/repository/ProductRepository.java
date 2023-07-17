package ricardo.projetos.product.ms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ricardo.projetos.product.ms.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
