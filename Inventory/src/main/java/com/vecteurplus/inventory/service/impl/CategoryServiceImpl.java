package com.vecteurplus.inventory.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
//import com.vecteurplus.inventory.dao.CategoryDao;
import com.vecteurplus.inventory.dao.impl.CategoryDaoImpl;
import com.vecteurplus.inventory.model.Category;
import com.vecteurplus.inventory.service.CategoryService;
import com.vecteurplus.inventory.service.core.impl.AbstractServiceSupport;

@Service("categoryService")
public class CategoryServiceImpl extends AbstractServiceSupport<Category, Integer> implements CategoryService {
	
	@Resource(name = "categoryDao")
	private CategoryDaoImpl _categoryDao;

	public void setCategoryDao(CategoryDaoImpl categoryDao) {
		_categoryDao = categoryDao;
	}

	public CategoryDaoImpl getCategoryDao() {
		return _categoryDao;
	}

	@Override
	public Category getById(int identifierType) {
		return _categoryDao.getById(identifierType);
	}

	@Override
	public List<Category> getAll() {
		return _categoryDao.getAll();
	}

	@Override
	public void save(Category type) {
		_categoryDao.save(type);
	}

	@Override
	public void update(Category type) {
		_categoryDao.update(type);
	}

	@Override
	public void deleteById(int id) {
		_categoryDao.deleteById(id);
	}

	@Override
	public void delete(Category type) {
		_categoryDao.delete(type);
		
	}

	@Override
	public void refresh(Category type) {
		_categoryDao.refresh(type);
		
	}
	
}
