package br.com.gabrielcaio.specification.controller;
import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.gabrielcaio.specification.controller.request.ProductRequest;
import br.com.gabrielcaio.specification.controller.response.ProductResponse;
import br.com.gabrielcaio.specification.model.Product;
import br.com.gabrielcaio.specification.model.ProductFilter;
import br.com.gabrielcaio.specification.service.ProductService;
import jakarta.validation.constraints.NotBlank;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductResponse> insertProduct(@RequestBody ProductRequest productRequest) {
        ProductResponse productResponse = productService.insert(productRequest);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(productResponse.getId()).toUri();
        return ResponseEntity.created(uri).body(productResponse);
    }
    

    @GetMapping
    public List<Product> getProducts(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(required = false) Integer minStock,
            @RequestParam(required = false) String categoryName) {

        ProductFilter filter = new ProductFilter(name, minPrice, maxPrice, minStock, categoryName);
        return productService.searchProducts(filter);
    }
}
