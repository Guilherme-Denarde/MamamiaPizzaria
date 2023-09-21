package com.pizzeria.MammaMia.Mapper;

import com.pizzeria.MammaMia.Dto.ProductDTO;
import com.pizzeria.MammaMia.Entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {

//    @Mapping(source = "product_name", target = "productName")
//    @Mapping(source = "product_description", target = "productDescription")
//    ProductDTO productToProductDTO(Product product);
//
//    @Mapping(source = "productName", target = "product_name")
//    @Mapping(source = "productDescription", target = "product_description")
//    Product productDTOToProduct(ProductDTO dto);
}
