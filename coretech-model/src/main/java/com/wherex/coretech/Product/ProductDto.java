package com.wherex.coretech.Product;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductDto {

    private Long id;
    private String name;
    private String description;
    private Long price;
    private Long quantity;

}
