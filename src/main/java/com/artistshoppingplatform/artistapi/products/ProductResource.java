package com.artistshoppingplatform.artistapi.products;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
public class ProductResource {
	
	private ProductRepository productRepository;
	
	public ProductResource(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	@GetMapping("/artist-platform/products")
	public List<Product> getProducts() {
		return productRepository.findAll();
	}
	
	@GetMapping("/artist-platform/products/{id}")
	public EntityModel<Product> retrieveProduct(@PathVariable UUID id) {
		Optional<Product> product = this.productRepository.findById(id);
		
		if(product.isEmpty())
			throw new RuntimeException("User not found");
		
		EntityModel<Product> entityModel = EntityModel.of(product.get());
		return entityModel;
	}
	
	@PostMapping("/artist-platform/products")
	public ResponseEntity<Product> saveProduct(@Valid @RequestBody Product product) {
		
		Product savedProduct = productRepository.save(product);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
					   .path("/{id}")
					   .buildAndExpand(savedProduct.getId())
					   .toUri();
		
		return ResponseEntity.created(location).build();
		
	}
	
	

}
