package com.vecteurplus.inventory.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import com.vecteurplus.inventory.model.Category;
import com.vecteurplus.inventory.model.Product;
import com.vecteurplus.inventory.service.impl.CategoryServiceImpl;
import com.vecteurplus.inventory.service.impl.ProductServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@SuiteClasses(ProductServiceTest.class)
@TransactionConfiguration(transactionManager = "transactionManager" , defaultRollback = false)
@ContextConfiguration(locations = "classpath:app-context.xml")
public class ProductServiceTest {
	
	private CategoryServiceImpl _categoryService;
	private Category _category;
	private ProductServiceImpl _productService;
	private Product _product;
	
	@Resource(name = "categoryService")
	public void setCategoryService(CategoryServiceImpl categoryService) {
		_categoryService = categoryService;
	}
	@Resource(name = "productService")
	public void setProductService(ProductServiceImpl productService) {
		_productService = productService;
	}
	
	@Before
	public void loadTest() {
		System.out.println("ProductService testing starts.........");
	}	
	
	@Test
	@Ignore
	@Transactional
	public void testSave() {
		_category = new Category();
		_category = _categoryService.getById(3);
		
		_product = new Product();
		_product.setCategory(_category);
		_product.setCode("PRO0007");
		_product.setName("Pentel Correction Pen");
		_product.setCost((float)0.8);
		_product.setPrice((float)1.5);
		_product.setDescription("Best quality");
		_productService.save(_product);
		
		String result = "\n==========================testInsert==========================\n";
		result += "Here is : ";
		result += _product.toString();
		System.out.println(result);
	}
	
	@Test
	@Ignore
	@Transactional
	public void testUpdate() {
		_product = new Product();
		_product = _productService.getById(5);
		_product.setCode("PRO0005");
		_productService.update(_product);
		
		String result = "\n==========================testUpdate==========================\n";
		result += "Here is : ";
		result += _product.toString();
		System.out.println(result);
	}
	
	@Test
	@Ignore
	@Transactional
	public void testDeleteById() {
		_product = new Product();
		_product = _productService.getById(6);
		
		String result = "\n==========================testDeleteById==========================\n";
		result += "The product to be deleted is : ";
		result += _product.toString();
		System.out.println(result);
		_productService.deleteById(6);
		System.out.println("**********************Done deleting the above product**********************");
	}
	
	@Test
	@Ignore
	@Transactional
	public void testDelete() {
		_product = new Product();
		_product = _productService.getById(7);
		
		String result = "\n==========================testDelete==========================\n";
		result += "The product to be deleted is : ";
		result += _product.toString();
		System.out.println(result);
		_productService.delete(_product);
		System.out.println("**********************Done deleting the above product**********************");
	}
	
	@Test
	@Ignore
	@Transactional
	public void testGetById() {
		_product = new Product();
		_product = _productService.getById(4);
		
		String result = "\n==========================testGetById==========================\n";
		result += "Here is : ";
		result += _product.toString();
		System.out.println(result);
	}
	
	@Test
	@Ignore
	@Transactional
	public void testGetAll() {
		
		List<Product> productList;
		productList = _productService.getAll();
		
		String result = "\n==========================testGetAll==========================\n";
		for(Product product: productList){
			result += "Here is : ";
			result += product.toString();
			result += "\n";
		}
		System.out.println(result);
	}

	@After
	public void endTest(){
		System.out.println("ProductService testing ends.........");
	}

}
