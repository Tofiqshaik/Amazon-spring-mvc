package com.ty.amazon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.amazon.dao.ProductDao;
import com.ty.amazon.dto.Product;

@Service
public class ProductService {
	
	@Autowired
	private ProductDao productDao;
	
	public void saveProduct(Product product) {
		productDao.saveProduct(product);
	}
	public void deleteProductById(int id) {
		productDao.deleteProductById(id);
	}
	public void updateProduct(Product product) {
		productDao.updateProduct(product);
	}
}
