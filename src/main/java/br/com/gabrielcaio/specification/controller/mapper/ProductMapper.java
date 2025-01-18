package br.com.gabrielcaio.specification.controller.mapper;

import br.com.gabrielcaio.specification.controller.request.ProductRequest;
import br.com.gabrielcaio.specification.controller.response.CategoryResponse;
import br.com.gabrielcaio.specification.controller.response.ProductResponse;
import br.com.gabrielcaio.specification.model.Category;
import br.com.gabrielcaio.specification.model.Product;

public class ProductMapper {

    public static Product toProduct(ProductRequest productRequest) {
        return new Product(productRequest.getName(), productRequest.getPrice());

    }

    public static ProductResponse toResponseFromProduct(Product product) {
        ProductResponse productResponse = new ProductResponse(
                product.getId(), product.getName(), product.getPrice());

        for (Category category : product.getCategories()) {
            CategoryResponse categoryResponse = new CategoryResponse(category.getId(), category.getName());
            productResponse.getCategories().add(categoryResponse);
        }
        return productResponse;
    }

}
