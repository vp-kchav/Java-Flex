package com.vecteurplus.inventory.service.core.impl;

import java.io.Serializable;
import java.util.List;
//import com.vecteurplus.inventory.dao.core.impl.AbstractDaoSupport;

public abstract class AbstractServiceSupport<EntityType extends Serializable, IdentifierType extends Serializable> {
	
	public abstract EntityType getById(final int identifierType);
	
	public abstract List<EntityType> getAll();
	
	public abstract void save(final EntityType type);
	
	public abstract void update(final EntityType type);
	
	public abstract void deleteById(final int id);
	
	public abstract void delete(final EntityType type);
	
	public abstract void refresh(final EntityType type);
	
}
