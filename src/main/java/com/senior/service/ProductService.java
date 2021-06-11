package com.senior.service;

import com.senior.exception.UserNotFoundException;
import com.senior.model.PhysicalPerson;
import com.senior.model.Product;
import com.senior.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product add(Product product) {
        return productRepository.save(product);
    }

    public List<Product> findAllProduct() {
        return productRepository.findAll();
    }

    public Product update(Long id, Product productUpdated) {
        Product product = this.findProductId(id);

        product.setCode(product.getCode());
        product.setDescription(productUpdated.getDescription());
        product.setUnitOfmeasurement(productUpdated.getUnitOfmeasurement());
        product.setTotalAmount(productUpdated.getTotalAmount());
        product.setUnitaryValue(productUpdated.getUnitaryValue());
        product.setStatus(productUpdated.getStatus());

        return productRepository.save(product);
    }

    public Product findProductId(Long id) {
        return productRepository.findProductById(id)
                .orElseThrow(() -> new UserNotFoundException("Address by id " + id + " was not found"));
    }

    public void deleteProduct(Long id) {
        productRepository.deleteProductById(id);
    }

    public Page<Product> findPage(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

}