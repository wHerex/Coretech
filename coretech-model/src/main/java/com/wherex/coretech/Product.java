package com.wherex.coretech;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @SequenceGenerator(name = "products_id_generator", sequenceName = "products_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "products_id_generator")
    private Long id;

    private Long price;

    public Product() {
    }

    public Product(Long price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", price=" + price +
                '}';
    }
}
