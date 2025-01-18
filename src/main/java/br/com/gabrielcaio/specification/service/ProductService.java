package br.com.gabrielcaio.specification.service;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.com.gabrielcaio.specification.controller.mapper.ProductMapper;
import br.com.gabrielcaio.specification.controller.request.CategoryRequest;
import br.com.gabrielcaio.specification.controller.request.ProductRequest;
import br.com.gabrielcaio.specification.controller.response.ProductResponse;
import br.com.gabrielcaio.specification.model.Category;
import br.com.gabrielcaio.specification.model.Product;
import br.com.gabrielcaio.specification.model.ProductFilter;
import br.com.gabrielcaio.specification.repository.CategoryRepository;
import br.com.gabrielcaio.specification.repository.ProductRepository;
import br.com.gabrielcaio.specification.repository.specs.ProductSpecifications;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;


    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<Product> searchProducts(ProductFilter filter) {
        Specification<Product> spec = ProductSpecifications.createSearchSpecification(filter);
        return productRepository.findAll(spec);
    }
    public ProductResponse insert(ProductRequest productRequest) {

        Product product = ProductMapper.toProduct(productRequest); // converter os atributos que não são coleções

        // a cada  categoria request do produto request eu instancio uma categoria e adiciono no produto
        for (CategoryRequest categoryRequest : productRequest.getCategories()) {
            //Category category = categoryRepository.findById(categoryRequest.getId()).get();
            Category category = categoryRepository.getReferenceById(categoryRequest.getId());
            category.getProducts().add(product);
            product.getCategories().add(category);
        }
        product = productRepository.save(product);
        return ProductMapper.toResponseFromProduct(product);
    }
}

