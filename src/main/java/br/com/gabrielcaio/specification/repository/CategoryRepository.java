package br.com.gabrielcaio.specification.repository;

import br.com.gabrielcaio.specification.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.com.gabrielcaio.specification.model.Product;

public interface CategoryRepository extends JpaRepository<Category, Long>, JpaSpecificationExecutor<Product> {
}

