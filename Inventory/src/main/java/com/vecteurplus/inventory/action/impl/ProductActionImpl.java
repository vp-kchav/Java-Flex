package com.vecteurplus.inventory.action.impl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.vecteurplus.inventory.action.ProductAction;
import com.vecteurplus.inventory.action.core.impl.AbstractActionSupport;
import com.vecteurplus.inventory.model.Product;
import com.vecteurplus.inventory.service.impl.ProductServiceImpl;

@Service("productAction")
public class ProductActionImpl extends AbstractActionSupport<Product, Integer> implements ProductAction {
	
	private static final long serialVersionUID = 1L;
	private Product _product;
	private List<Product> _list = new ArrayList<Product>();
	
	@Resource(name = "productService")
	private ProductServiceImpl _productService;
	
	public Product getProduct() {
		return _product;
	}
	public void setProduct(Product product) {
		_product = product;
	}

	public List<Product> getList() {
		return _list;
	}
	public void setList(List<Product> list) {
		_list = list;
	}
	
	public void setProductService(ProductServiceImpl productService) {
		_productService = productService;
	}

	public ProductServiceImpl getProductService() {
		return _productService;
	}

	public Object getModel() {
		return _product;
	}

	@Override
	public String getById(int identiferType) throws Exception {
		_product = new Product();
		setProduct(getProductService().getById(identiferType));
		return "success";
	}

	@Override
	public String getAll() throws Exception {
		setList(null);
		setList(getProductService().getAll());
		return "success";
	}

	@Override
	public String save(Product type) throws Exception {
		getProductService().save(type);
		setList(null);
		setList(getProductService().getAll());
		return "success";
	}

	@Override
	public String update(Product type) throws Exception {
		getProductService().update(type);
		setList(null);
		setList(getProductService().getAll());
		return "success";
	}

	@Override
	public String deleteById(int id) throws Exception {
		getProductService().deleteById(id);
		setList(null);
		setList(getProductService().getAll());
		return "success";
	}

	@Override
	public String delete(Product type) throws Exception {
		getProductService().delete(type);
		setList(null);
		setList(getProductService().getAll());
		return "success";
	}
	
}
