package br.com.gabrielcaio.specification.controller.mapper;

import br.com.gabrielcaio.specification.controller.request.CategoryRequest;
import br.com.gabrielcaio.specification.controller.response.CategoryResponse;
import br.com.gabrielcaio.specification.model.Category;

public class CategoryMapper {

    public static Category toCategory(CategoryRequest categoryRequest) {
        return new Category(categoryRequest.getId(), categoryRequest.getName());
    }

    public static CategoryResponse toResponseFromCategory(Category category) {
        return new CategoryResponse(category.getId(), category.getName());
    }
}
