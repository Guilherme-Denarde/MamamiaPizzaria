package com.pizzeria.MammaMia.Service;

import com.pizzeria.MammaMia.Dto.ProductDTO;
import com.pizzeria.MammaMia.Entity.Categoria;
import com.pizzeria.MammaMia.Entity.Product;
import com.pizzeria.MammaMia.Entity.Sabor;
import com.pizzeria.MammaMia.Repository.ProductRepository;
import com.pizzeria.MammaMia.Repository.SaborRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private SaborRepository saborRepository;


    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public List<Product> getProductsByName(String name) {
        return productRepository.findByNameContainingIgnoreCase(name);
    }
    public Product createProduct(ProductDTO productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setSabor(productDto.getSabor());
        product.setImageUrl(productDto.getImageUrl());
        product.setStars(productDto.getStars());

        if (productDto.getSabor() != null) {
            List<Sabor> sabor = productDto.getSabor();
            product.setSabor(sabor);
        }

        return productRepository.save(product);
    }

    public Product updateProductFromDTO(ProductDTO productDTO) {
        Optional<Product> existingProduct = productRepository.findById(Long.valueOf(productDTO.getId()));

        if (existingProduct.isPresent()) {
            Product product = existingProduct.get();
            product.setName(productDTO.getName());
            product.setDescription(productDTO.getDescription());
            product.setPrice(productDTO.getPrice());
            product.setSabor(productDTO.getSabor());
            product.setImageUrl(productDTO.getImageUrl());
            product.setStars(productDTO.getStars());

            if (productDTO.getSabor() != null) {
                List<Sabor> sabor = productDTO.getSabor();
                product.setSabor(sabor);
            } else {
                throw new EntityNotFoundException("O ID de Sabor não foi fornecido");
            }

            return productRepository.save(product);
        } else {
            throw new EntityNotFoundException("Product com o ID " + productDTO.getId() + " não encontrado");
        }
    }

    public boolean deleteProduct(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public List<Product> getProductsByCategoria(String categoria) {
        List<Product> produtos = productRepository.findByCategoria(Categoria.valueOf(categoria));

        return produtos;




    }
}
