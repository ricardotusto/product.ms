package ricardo.projetos.product.ms.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tb_product")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "price")
    private double price;

    @Column(name = "isAvailable")
    private boolean isAvailable;

    /***
     {
     "id": 1,
     "name": "Iphone 13 Pro max",
     "description": "Ultima geracao",
     "price": 999.00,
     "isAvailable": true
     }
     */

}
