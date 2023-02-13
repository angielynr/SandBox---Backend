package com.example.springdatajpa;

import com.example.springdatajpa.entities.Product;
import com.example.springdatajpa.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class SpringdatajpaApplicationTests {

	@Autowired
	ApplicationContext applicationContext;

	@Test
	void saveProduct() {
		ProductRepository repository = applicationContext.getBean(ProductRepository.class);

		Product product = new Product();
		product.setId(2);
		product.setName("Tissue");;
		product.setDescription("Tissues");
		product.setPrice(12d);
		repository.save(product);

		Optional<Product> result = repository.findById(1L);
		System.out.println(result);

//		Iterable<Product> allProducts = repository.findAll();
		List<Product> allProducts = repository.findByName("Tissue");
		System.out.println(allProducts);
	}

}
