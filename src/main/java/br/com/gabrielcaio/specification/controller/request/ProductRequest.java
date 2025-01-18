package br.com.gabrielcaio.specification.controller.request;

import java.util.ArrayList;
import java.util.List;

public class ProductRequest {


    private String name;
    private Double price;
    private List<CategoryRequest> categories = new ArrayList<CategoryRequest>();

    public ProductRequest() {
    }

    public ProductRequest(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<CategoryRequest> getCategories() {
        return categories;
    }
}
