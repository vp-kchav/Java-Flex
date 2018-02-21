package com.vecteurplus.inventory.dao.impl;

//import javax.annotation.Resource;
//import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import com.vecteurplus.inventory.dao.CategoryDao;
import com.vecteurplus.inventory.dao.core.impl.AbstractDaoSupport;
import com.vecteurplus.inventory.model.Category;

@Repository("categoryDao")
public class CategoryDaoImpl extends AbstractDaoSupport<Category, Integer> implements CategoryDao {

	@Override
	protected Class<? extends Category> getDomainClass() {
		return Category.class;
	}
	
//	@Override
//	@Resource(name = "sessionFactory")
//	public void setSessionFactoryCore(final SessionFactory sessionFactory) {
//		super.setSessionFactoryCore(sessionFactory);
//	}
}
