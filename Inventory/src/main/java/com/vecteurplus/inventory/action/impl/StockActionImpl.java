package com.vecteurplus.inventory.action.impl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.vecteurplus.inventory.action.StockAction;
import com.vecteurplus.inventory.action.core.impl.AbstractActionSupport;
import com.vecteurplus.inventory.model.Stock;
import com.vecteurplus.inventory.service.impl.StockServiceImpl;

@Service("stockAction")
public class StockActionImpl extends AbstractActionSupport<Stock, Integer> implements StockAction {
	
	private static final long serialVersionUID = 1L;
	private Stock _stock;
	private List<Stock> _list = new ArrayList<Stock>();
	
	@Resource(name = "stockService")
	private StockServiceImpl _stockService;
	
	public void setStock(Stock stock) {
		_stock = stock;
	}
	public Stock getStock() {
		return _stock;
	}
	
	public void setList(List<Stock> list) {
		_list = list;
	}
	public List<Stock> getList() {
		return _list;
	}

	public void setStockService(StockServiceImpl stockService) {
		_stockService = stockService;
	}
	public StockServiceImpl getStockService() {
		return _stockService;
	}

	public Object getModel() {
		return _stock;
	}

	@Override
	public String getById(int identiferType) throws Exception {
		_stock = new Stock();
		setStock(getStockService().getById(identiferType));
		return "success";
	}

	@Override
	public String getAll() throws Exception {
		setList(null);
		setList(getStockService().getAll());
		return "success";
	}

	@Override
	public String save(Stock type) throws Exception {
		getStockService().save(type);
		setList(null);
		setList(getStockService().getAll());
		return "success";
	}

	@Override
	public String update(Stock type) throws Exception {
		getStockService().update(type);
		setList(null);
		setList(getStockService().getAll());
		return "success";
	}

	@Override
	public String deleteById(int id) throws Exception {
		getStockService().deleteById(id);
		setList(null);
		setList(getStockService().getAll());
		return "success";
	}

	@Override
	public String delete(Stock type) throws Exception {
		getStockService().delete(type);
		setList(null);
		setList(getStockService().getAll());
		return "success";
	}
}
