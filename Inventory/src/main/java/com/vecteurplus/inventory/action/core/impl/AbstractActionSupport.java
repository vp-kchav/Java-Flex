package com.vecteurplus.inventory.action.core.impl;

import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.List;
//import com.vecteurplus.inventory.service.core.impl.AbstractServiceSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.ActionSupport;

public abstract class AbstractActionSupport<EntityType extends Serializable, IdentifierType extends Serializable> extends ActionSupport implements ModelDriven<Object> {

	private static final long serialVersionUID = 1L;
/*
	private AbstractServiceSupport<EntityType, IdentifierType> _abstractServiceSupport;
	private EntityType _type;
	
	@SuppressWarnings("unused")
	private List<EntityType> _list = new ArrayList<EntityType>();
	
	@Override
	public Object getModel() {
		return _type;
	}
	
 */
	
	public abstract String getById(final int identiferType) throws Exception;
/*
	public String getById(final int identifierType) throws Exception {
		_type = _abstractServiceSupport.getById(identifierType);
		return "success";
	}
*/
	
	public abstract String getAll() throws Exception;
/*	
	public String getAll() throws Exception {
		_list = null;
		_list = _abstractServiceSupport.getAll();
		return "success";
	}
*/

	public abstract String save(final EntityType type) throws Exception;
/*
	public String save(final EntityType type) throws Exception {
		_abstractServiceSupport.save(type);
		_list = null;
		_list = _abstractServiceSupport.getAll();
		return "success";
	}
*/	
	
	public abstract String update(final EntityType type) throws Exception;
/*	
	public String update(final EntityType type) throws Exception {
		_abstractServiceSupport.update(type);
		_list = null;
		_list = _abstractServiceSupport.getAll();
		return "success";
	}
*/	
	
	public abstract String deleteById(final int id) throws Exception;
/*	
	public String deleteById(final int id) throws Exception {
		_abstractServiceSupport.deleteById(id);
		_list = null;
		_list = _abstractServiceSupport.getAll();
		return "success";
	}
*/	
	
/*	
	public String delete(final EntityType type) throws Exception {
		_abstractServiceSupport.delete(type);
		_list = null;
		_list = _abstractServiceSupport.getAll();
		return "success";
	}
*/	
	public abstract String delete(final EntityType type) throws Exception;

}
