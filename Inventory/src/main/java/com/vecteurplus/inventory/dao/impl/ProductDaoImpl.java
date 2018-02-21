package com.vecteurplus.inventory.dao.impl;

//import javax.annotation.Resource;
//import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import com.vecteurplus.inventory.dao.ProductDao;
import com.vecteurplus.inventory.dao.core.impl.AbstractDaoSupport;
import com.vecteurplus.inventory.model.Product;

@Repository("productDao")
public class ProductDaoImpl extends AbstractDaoSupport<Product, Integer> implements ProductDao {

	@Override
	protected Class<? extends Product> getDomainClass() {
		return Product.class;
	}
	
//	@Override
//	@Resource(name = "sessionFactory")
//	public void setSessionFactoryCore(final SessionFactory sessionFactory) {
//		super.setSessionFactoryCore(sessionFactory);
//	}

}
