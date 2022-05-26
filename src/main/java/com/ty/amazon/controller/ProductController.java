package com.ty.amazon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ty.amazon.dao.ProductDao;
import com.ty.amazon.dto.Product;
import com.ty.amazon.service.ProductService;
import com.ty.amazon.service.UserService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("saveproduct")
	public ModelAndView saveProduct() {
		ModelAndView view = new ModelAndView();
		view.addObject("product", new Product());
		view.setViewName("createproduct.jsp");
		return view;
	}
	@RequestMapping("createproduct")
	public void saveProduct(@ModelAttribute Product product) {
		 productService.saveProduct(product);
	}
	@RequestMapping("deleteproduct")
	public ModelAndView deleteProductById() {
		ModelAndView view = new ModelAndView();
		view.addObject("product", new Product());
		view.setViewName("deleteproduct.jsp");
		return view;
	}
	@RequestMapping("delete")
	public void deleteProductById(@ModelAttribute Product product) {
		productService.deleteProductById(product.getId());
	}
	@RequestMapping("updateproduct")
	public ModelAndView updateProduct() {
		ModelAndView view = new ModelAndView();
		view.addObject("product", new Product());
		view.setViewName("update.jsp");
		return view;
	}
	@RequestMapping("update")
	public void updateProduct(@ModelAttribute Product product) {
		productService.updateProduct(product);
	}
	
	
}
