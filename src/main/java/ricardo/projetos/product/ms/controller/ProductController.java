package ricardo.projetos.product.ms.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ricardo.projetos.product.ms.dto.ProductDTO;
import ricardo.projetos.product.ms.service.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService service;

    @PostMapping
    public ResponseEntity<ProductDTO> create(@RequestBody @Valid ProductDTO request){
        Optional<ProductDTO> response = service.create(request);

        if (response.isPresent()){
            return new ResponseEntity<>(response.get(), HttpStatus.CREATED);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getById(@PathVariable Long id){
        Optional<ProductDTO> response = service.getById(id);

        if (response.isPresent()){
            return ResponseEntity.ok(response.get());
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
