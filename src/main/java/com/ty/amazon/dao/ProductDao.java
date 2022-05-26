package com.ty.amazon.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.amazon.dto.Product;

@Repository
public class ProductDao {
	
	@Autowired
	EntityManager entityManager;
	
	@Autowired
	EntityTransaction entityTransaction;
	
	public void saveProduct(Product product) {
		entityTransaction.begin();
		entityManager.persist(product);
		entityTransaction.commit();
		
	}
	public void deleteProductById(int id) {
		Product product = entityManager.find(Product.class, id);
		entityTransaction.begin();
		entityManager.remove(product);
		entityTransaction.commit();
	}
	public void updateProduct(Product product) {
		entityTransaction.begin();
		entityManager.merge(product);
		entityTransaction.commit();
	}
	public Product getproductByid(int id) {
		return entityManager.find(Product.class, id);
	}
	public List<Product> getAllProduct(){
		return entityManager.createQuery("SELECT p FROM Product p").getResultList();
	}

}
