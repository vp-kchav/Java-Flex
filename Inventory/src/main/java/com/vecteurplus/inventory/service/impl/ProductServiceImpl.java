package com.vecteurplus.inventory.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.vecteurplus.inventory.dao.impl.ProductDaoImpl;
import com.vecteurplus.inventory.model.Product;
import com.vecteurplus.inventory.service.ProductService;
import com.vecteurplus.inventory.service.core.impl.AbstractServiceSupport;

@Service("productService")
public class ProductServiceImpl extends AbstractServiceSupport<Product, Integer> implements ProductService {
	
	@Resource(name = "productDao")
	private ProductDaoImpl _productDao;

	public void setProductDao(ProductDaoImpl productDao) {
		_productDao = productDao;
	}
	public ProductDaoImpl getProductDao() {
		return _productDao;
	}

	@Override
	public Product getById(int identifierType) {
		return _productDao.getById(identifierType);
	}

	@Override
	public List<Product> getAll() {
		return _productDao.getAll();
	}

	@Override
	public void save(Product type) {
		_productDao.save(type);
	}

	@Override
	public void update(Product type) {
		_productDao.update(type);
	}

	@Override
	public void deleteById(int id) {
		_productDao.deleteById(id);
	}

	@Override
	public void delete(Product type) {
		_productDao.delete(type);
	}

	@Override
	public void refresh(Product type) {
		_productDao.refresh(type);
	}
}
