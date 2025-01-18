package br.com.gabrielcaio.specification.model;

public class ProductFilter {

    private String name;
    private Double minPrice;
    private Double maxPrice;
    private Integer minStock;
    private String categoryName;


    public ProductFilter(String name, Double minPrice, Double maxPrice, Integer minStock, String categoryName) {
        this.name = name;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.minStock = minStock;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getMinPrice() {
        return minPrice;
    }
    public void setMinPrice(Double minPrice) {
        this.minPrice = minPrice;
    }
    public Double getMaxPrice() {
        return maxPrice;
    }
    public void setMaxPrice(Double maxPrice) {
        this.maxPrice = maxPrice;
    }
    public Integer getMinStock() {
        return minStock;
    }
    public void setMinStock(Integer minStock) {
        this.minStock = minStock;
    }
    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    
}

