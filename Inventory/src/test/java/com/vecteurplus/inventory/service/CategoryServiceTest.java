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
import com.vecteurplus.inventory.service.impl.CategoryServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@SuiteClasses(CategoryServiceTest.class)
@TransactionConfiguration(transactionManager = "transactionManager" , defaultRollback = false)
@ContextConfiguration(locations = "classpath:app-context.xml")
public class CategoryServiceTest {
	
	private CategoryServiceImpl _categoryService;
	private Category _category;

	@Resource(name="categoryService")
	public void setCategoryService(CategoryServiceImpl categoryService) {
		_categoryService = categoryService;
	}

	@Before
	public void loadTest() {
		System.out.println("CategoryService testing starts.........");
	}	

	@Test
	@Ignore
	@Transactional
	public void testSave() {
		_category = new Category();
		_category.setCode("CAT0006");
		_category.setName("Bubble");
		_categoryService.save(_category);
		
		String result = "\n==========================testInsert==========================\n";
		result += "Here is : ";
		result += _category.toString();
		System.out.println(result);
	}
		
	@Test
	@Ignore
	@Transactional
	public void testUpdate(){
		_category = new Category();
		_category = _categoryService.getById(5);
		_category.setName("Canned Food");
		_categoryService.update(_category);
		
		String result = "\n==========================testUpdate==========================\n";
		result += "Here is : ";
		result += _category.toString();
		System.out.println(result);
	}
	
	@Test
	@Ignore
	@Transactional
	public void testDeleteById() {
		_category = new Category();
		_category = _categoryService.getById(7);
		
		String result = "\n==========================testDeleteById==========================\n";
		result += "The category to be deleted is : ";
		result += _category.toString();
		System.out.println(result);
		_categoryService.deleteById(7);
		System.out.println("**********************Done deleting the above category**********************");
	}
	
	@Test
	@Ignore
	@Transactional
	public void testDelete(){
		_category = new Category();
		_category = _categoryService.getById(6);
		
		String result = "\n==========================testDelete==========================\n";
		result += "The category to be deleted is : ";
		result += _category.toString();
		System.out.println(result);
		_categoryService.delete(_category);
		System.out.println("**********************Done deleting the above category**********************");
	}
	
	@Test
	@Ignore
	@Transactional
	public void testGetById() {
		_category = new Category();
		_category = _categoryService.getById(4);
		
		String result = "\n==========================testGetById==========================\n";
		result += "Here is : ";
		result += _category.toString();
		System.out.println(result);
	}
	
	@Test
//	@Ignore
	@Transactional
	public void testGetAll() {
		
		List<Category> categoryList;
		categoryList = _categoryService.getAll();
		
		String result = "\n==========================testGetAll==========================\n";
		for(Category categroy: categoryList){
			result += "Here is : ";
			result += categroy.toString();
			result += "\n";
		}
		System.out.println(result);
	}

	@After
	public void endTest(){
		System.out.println("CategoryService testing ends.........");
	}

}
