package com.wherex.coretech.Product;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "products")
public class Product {

    @Id
    @SequenceGenerator(name = "products_id_generator", sequenceName = "products_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "products_id_generator")
    private Long id;

    private String name;

    private String description;

    private Long price;

    private Long quantity;

    public Product(String name, String description, Long price, Long quantity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }
}
