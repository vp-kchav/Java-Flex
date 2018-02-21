package com.vecteurplus.inventory.dao.impl;

//import javax.annotation.Resource;
//import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import com.vecteurplus.inventory.dao.StockDao;
import com.vecteurplus.inventory.dao.core.impl.AbstractDaoSupport;
import com.vecteurplus.inventory.model.Stock;

@Repository("stockDao")
public class StockDaoImpl extends AbstractDaoSupport<Stock, Integer> implements StockDao {

	@Override
	protected Class<? extends Stock> getDomainClass() {
		return Stock.class;
	}
	
//	@Override
//	@Resource(name = "sessionFactory")
//	public void setSessionFactoryCore(final SessionFactory sessionFactory) {
//		super.setSessionFactoryCore(sessionFactory);
//	}

}
