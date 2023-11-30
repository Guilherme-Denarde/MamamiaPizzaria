package com.pizzeria.MammaMia.Controller;

import com.pizzeria.MammaMia.Dto.ProductDTO;
import com.pizzeria.MammaMia.Entity.Product;
import com.pizzeria.MammaMia.Exceptions.ErrorResponse;
import com.pizzeria.MammaMia.Response.ResponseWrapper;
import com.pizzeria.MammaMia.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/findAll")
    @PreAuthorize("hasAnyRole('CLIENTE', 'MANAGER')")

    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<ProductDTO> products = productService.getAllProducts()
                .stream()
                .map(Product ::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(products);
    }

    @GetMapping("/search")
    @PreAuthorize("hasAnyRole('CLIENTE', 'MANAGER')")

    public ResponseEntity<List<ProductDTO>> searchProductsByName(@RequestParam("name") String name) {
        List<ProductDTO> products = productService.getProductsByName(name)
                .stream()
                .map(Product::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(products);
    }

    @GetMapping("/categoria")
    @PreAuthorize("hasAnyRole('CLIENTE', 'MANAGER')")

    public ResponseEntity<List<ProductDTO>> searchProductsByCategoria(@RequestParam("name") String categoria) {
        List<ProductDTO> products = productService.getProductsByCategoria(categoria)
                .stream()
                .map(Product::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(products);
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('CLIENTE', 'MANAGER')")
    public ResponseEntity<ResponseWrapper<ProductDTO>> getProductById(@RequestParam("id") Long id) {
        return productService.getProductById(id)
                .map(Product :: toDTO)
                .map(dto -> ResponseEntity.ok(new ResponseWrapper<>(dto)))
                .orElseGet(() -> ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body(new ResponseWrapper<>("Product with ID " + id + " not found.")));
    }

    @PostMapping
    @PreAuthorize("hasAnyRole( 'MANAGER')")

    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDto) {
        Product product = productService.createProduct(productDto);
        return ResponseEntity.ok(product.toDTO());
    }

    @PutMapping("/update")
    @PreAuthorize("hasAnyRole( 'MANAGER')")

    public ResponseEntity<Object> updateProduct(@RequestParam("id") Long id, @RequestBody ProductDTO productDTO) {
        if (!id.equals(Long.valueOf(productDTO.getId()))) {
            return ResponseEntity.badRequest().body(new ErrorResponse("ID na URL não corresponde ao ID no corpo da requisição", 400));
        }
        Product updatedProduct = productService.updateProductFromDTO(productDTO);
        return ResponseEntity.ok(updatedProduct.toDTO());
    }

    @DeleteMapping("/delete")
    @PreAuthorize("hasAnyRole( 'MANAGER')")

    public ResponseEntity<String> deleteProduct(@RequestParam("id") Long id) {
        boolean isDeleted = productService.deleteProduct(id);

        if (isDeleted) {
            return ResponseEntity.ok("Deleted successfully");
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Product with ID " + id + " does not exist");
        }
    }
}
