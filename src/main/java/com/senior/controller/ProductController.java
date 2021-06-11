package com.senior.controller;

import com.senior.dto.DemandDTO;
import com.senior.dto.PhysicalPersonDTO;
import com.senior.dto.ProductDTO;
import com.senior.model.Demand;
import com.senior.model.PhysicalPerson;
import com.senior.model.Product;
import com.senior.service.DemandService;
import com.senior.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/id/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable(value = "id") Long id) {

        ModelMapper modelMapper = new ModelMapper();

        Product product = productService.findProductId(id);

        ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);

        return ResponseEntity.ok().body(productDTO);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> findAll() {
        List<Product> products = productService.findAllProduct();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> add(@RequestBody Product product) {
        Product newProduct = productService.add(product);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> update(@PathVariable Long id, @RequestBody Product product) {

        ProductDTO productDTO = new ProductDTO(productService.update(id, product));

        return ResponseEntity.ok().body(productDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public Page<Product> findPage(Pageable pageable) {
        return productService.findPage(pageable);
    }
}