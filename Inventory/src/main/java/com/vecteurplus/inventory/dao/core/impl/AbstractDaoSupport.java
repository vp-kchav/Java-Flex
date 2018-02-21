package com.vecteurplus.inventory.dao.core.impl;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
//import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public abstract class AbstractDaoSupport<EntityType extends Serializable, IdentifierType extends Serializable> extends HibernateDaoSupport {
	
	protected abstract Class<? extends EntityType> getDomainClass();
	
	public EntityType getById(final int identifierType) {
		return getDomainClass().cast(getSession().load(getDomainClass(), identifierType));
	}
	
	@SuppressWarnings("unchecked")
	public List<EntityType> getAll() {
		Session session = getSession();
		Criteria criteria = session.createCriteria(getDomainClass());
		return criteria.list();
	}
	
	public void save(final EntityType type) {
		getHibernateTemplate().save(type);
	}
	
	public void update(final EntityType type) {
		getHibernateTemplate().update(type);
		getHibernateTemplate().flush();
	}
	
	public void deleteById(final int id) {
		EntityType entityType = getHibernateTemplate().load(getDomainClass(), id);
		getHibernateTemplate().delete(entityType);
		getHibernateTemplate().flush();
	}
	
	public void delete(final EntityType type) {
		getHibernateTemplate().delete(type);
		getHibernateTemplate().flush();
	}
	
	public void refresh(final EntityType type) {
		getHibernateTemplate().refresh(type);
	}
}
