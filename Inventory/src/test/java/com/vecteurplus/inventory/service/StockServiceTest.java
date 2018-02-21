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
import com.vecteurplus.inventory.model.Stock;
import com.vecteurplus.inventory.model.Product;
import com.vecteurplus.inventory.service.impl.StockServiceImpl;
import com.vecteurplus.inventory.service.impl.ProductServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@SuiteClasses(StockServiceTest.class)
@TransactionConfiguration(transactionManager = "transactionManager" , defaultRollback = false)
@ContextConfiguration(locations = "classpath:app-context.xml")
public class StockServiceTest {
	
	private ProductServiceImpl _productService;
	private Product _product;
	private StockServiceImpl _stockService;
	private Stock _stock;
	
	@Resource(name = "productService")
	public void setProductService(ProductServiceImpl productService) {
		_productService = productService;
	}

	@Resource(name = "stockService")
	public void setstockService(StockServiceImpl stockService) {
		_stockService = stockService;
	}
	
	@Before
	public void loadTest() {
		System.out.println("StockService testing starts.........");
	}	
	
	@Test
	@Ignore
	@Transactional
	public void testSave() {
		_product = new Product();
		_product = _productService.getById(5);
		
		_stock = new Stock();
		_stock.setProduct(_product);
		_stock.setCode("STO0005");
		_stock.setQuantity(50);
		_stockService.save(_stock);
		
		String result = "\n==========================testInsert==========================\n";
		result += "Here is : ";
		result += _stock.toString();
		System.out.println(result);
	}
	
	@Test
	@Ignore
	@Transactional
	public void testUpdate() {
		_stock = new Stock();
		_stock = _stockService.getById(3);
		_stock.setQuantity(200);
		_stockService.update(_stock);

		String result = "\n==========================testUpdate==========================\n";
		result += "Here is : ";
		result += _stock.toString();
		System.out.println(result);
	}
	
	@Test
	@Ignore
	@Transactional
	public void testDeleteById() {
		_stock = new Stock();
		_stock = _stockService.getById(5);
		
		String result = "\n==========================testDeleteById==========================\n";
		result += "The stock to be deleted is : ";
		result += _stock.toString();
		System.out.println(result);
		_stockService.deleteById(5);
		System.out.println("**********************Done deleting the above product**********************");
	}
	
	@Test
	@Ignore
	@Transactional
	public void testDelete() {
		_stock = new Stock();
		_stock = _stockService.getById(4);
		
		String result = "\n==========================testDelete==========================\n";
		result += "The stock to be deleted is : ";
		result += _stock.toString();
		System.out.println(result);
		_stockService.delete(_stock);
		System.out.println("**********************Done deleting the above product**********************");
	}
	
	@Test
	@Ignore
	@Transactional
	public void testGetById() {
		_stock = new Stock();
		_stock = _stockService.getById(4);
		
		String result = "\n==========================testGetById==========================\n";
		result += "Here is : ";
		result += _stock.toString();
		System.out.println(result);
	}
	
	@Test
	@Ignore
	@Transactional
	public void testGetAll() {
		List<Stock> stockList;
		stockList = _stockService.getAll();
		
		String result = "\n==========================testGetAll==========================\n";
		for(Stock stock: stockList){
			result += "Here is : ";
			result += stock.toString();
			result += "\n";
		}
		System.out.println(result);
	}

	@After
	public void endTest(){
		System.out.println("StockService testing ends.........");
	}


}
