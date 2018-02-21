package com.vecteurplus.inventory.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
//import com.vecteurplus.inventory.dao.StockDao;
import com.vecteurplus.inventory.dao.impl.StockDaoImpl;
import com.vecteurplus.inventory.model.Stock;
import com.vecteurplus.inventory.service.StockService;
import com.vecteurplus.inventory.service.core.impl.AbstractServiceSupport;

@Service("stockService")
public class StockServiceImpl extends AbstractServiceSupport<Stock, Integer> implements StockService {
	
	@Resource(name = "stockDao")
	private StockDaoImpl _stockDao;

	public void setStockDao(StockDaoImpl stockDao) {
		_stockDao = stockDao;
	}

	public StockDaoImpl getStockDao() {
		return _stockDao;
	}

	@Override
	public Stock getById(int identifierType) {
		return _stockDao.getById(identifierType);
	}

	@Override
	public List<Stock> getAll() {
		return _stockDao.getAll();
	}

	@Override
	public void save(Stock type) {
		_stockDao.save(type);
	}

	@Override
	public void update(Stock type) {
		_stockDao.update(type);
	}

	@Override
	public void deleteById(int id) {
		_stockDao.deleteById(id);
	}

	@Override
	public void delete(Stock type) {
		_stockDao.delete(type);
	}

	@Override
	public void refresh(Stock type) {
		_stockDao.refresh(type);
	}
}
