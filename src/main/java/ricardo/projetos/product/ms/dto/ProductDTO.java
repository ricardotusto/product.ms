package ricardo.projetos.product.ms.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProductDTO {

    @NotBlank
    private String name;

    @Size(min = 50)
    private String description;

    @Positive
    private double price;

    private boolean isAvailable;

    public ProductDTO(String name, String description, double price, boolean isAvailable) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    public ProductDTO() {
    }
}
