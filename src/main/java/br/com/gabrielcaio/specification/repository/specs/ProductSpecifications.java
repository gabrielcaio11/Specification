package br.com.gabrielcaio.specification.repository.specs;

import org.springframework.data.jpa.domain.Specification;

import br.com.gabrielcaio.specification.model.Category;
import br.com.gabrielcaio.specification.model.Product;
import br.com.gabrielcaio.specification.model.ProductFilter;
import jakarta.persistence.criteria.*;

public class ProductSpecifications {

    public static Specification<Product> createSearchSpecification(ProductFilter filter) {
        return (Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.conjunction();

            if (filter.getName() != null && !filter.getName().isEmpty()) {
                predicate = criteriaBuilder.and(
                        predicate,
                        criteriaBuilder.like(root.get("name"), "%" + filter.getName().toLowerCase() + "%")
                );
            }

            if (filter.getMinPrice() != null && filter.getMaxPrice() != null) {
                predicate = criteriaBuilder.and(
                        predicate,
                        criteriaBuilder.between(root.get("price"), filter.getMinPrice(), filter.getMaxPrice())
                );
            }

            if (filter.getMinStock() != null) {
                predicate = criteriaBuilder.and(
                        predicate,
                        criteriaBuilder.greaterThanOrEqualTo(root.get("stock"), filter.getMinStock())
                );
            }

            if (filter.getCategoryName() != null && !filter.getCategoryName().isEmpty()) {
                Join<Product, Category> categoryJoin = root.join("category", JoinType.INNER);
                predicate = criteriaBuilder.and(
                        predicate,
                        criteriaBuilder.equal(categoryJoin.get("name"), filter.getCategoryName())
                );
            }

            return predicate;
        };
    }
}

