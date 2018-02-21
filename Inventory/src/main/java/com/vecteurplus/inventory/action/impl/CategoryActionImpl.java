package com.vecteurplus.inventory.action.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.vecteurplus.inventory.action.CategoryAction;
import com.vecteurplus.inventory.action.core.impl.AbstractActionSupport;
import com.vecteurplus.inventory.model.Category;
import com.vecteurplus.inventory.service.impl.CategoryServiceImpl;

@Service("categoryAction")
public class CategoryActionImpl extends AbstractActionSupport<Category, Integer> implements CategoryAction {
	
	private static final long serialVersionUID = 1L;
	private Category _category;
	private List<Category> _list = new ArrayList<Category>();
	
	@Resource(name = "categoryService")
	private CategoryServiceImpl _categoryService;

	public Category getCategory() {
		return _category;
	}
	public void setCategory(Category category) {
		_category = category;
	}
	
	public void setList(List<Category> list) {
		_list = list;
	}
	public List<Category> getList() {
		return _list;
	}

	public void setCategoryService(CategoryServiceImpl categoryService) {
		_categoryService = categoryService;
	}
	
	public CategoryServiceImpl getCategoryService() {
		return _categoryService;
	}
	
	public Object getModel() {
		return _category;
	}
	
	@Override
	public String getById(int identiferType) throws Exception {
		_category = new Category();
		setCategory(getCategoryService().getById(identiferType));
		return "success";
	}
	@Override
	public String getAll() throws Exception {
		setList(null);
		setList(getCategoryService().getAll());
		return "success";
	}
	@Override
	public String save(Category type) throws Exception {
		getCategoryService().save(type);
		setList(null);
		setList(getCategoryService().getAll());
		return "success";
	}
	@Override
	public String update(Category type) throws Exception {
		getCategoryService().update(type);
		setList(null);
		setList(getCategoryService().getAll());
		return "success";
	}
	@Override
	public String deleteById(int id) throws Exception {
		getCategoryService().deleteById(id);
		setList(null);
		setList(getCategoryService().getAll());
		return "success";
	}
	@Override
	public String delete(Category type) throws Exception {
		getCategoryService().delete(type);
		setList(null);
		setList(getCategoryService().getAll());
		return "success";
	}
}
