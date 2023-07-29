package ricardo.projetos.product.ms.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ricardo.projetos.product.ms.dto.ProductDTO;

import java.util.Optional;

@SpringBootTest
public class ProductServiceTest {
    @Autowired
    private ProductService service;

    private ProductDTO request;

    @BeforeEach // Runs before any unitTest
    public void setUp(){
        request = new ProductDTO(
                "PS5",
                "Consola da marca sony, ultima da sua geração. Vem incluida com 1 TB e 100 jogos.",
                1999.9,
                true
        );
    }

    @Test
    public void shouldCreateProduct(){

        Optional<ProductDTO> response = service.create(request);

        // Check null response
        Assertions.assertNotNull(response.get());

        // Check if request parameters equals to response parameters
        Assertions.assertEquals(request.getName(), response.get().getName());
        Assertions.assertEquals(request.getDescription(), response.get().getDescription());
        Assertions.assertEquals(request.getPrice(), response.get().getPrice());

        // Check if parameter "isAvailable" is created with valueble true
        Assertions.assertTrue(response.get().isAvailable());
    }
}
