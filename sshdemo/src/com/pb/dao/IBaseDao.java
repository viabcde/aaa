package com.pb.dao;

import java.util.List;

public interface IBaseDao<T> {
	/**
	 * 按属性查询
	 * @param propertyName
	 * @param value
	 * @return
	 */
	public List<T> findByProperty(String propertyName, Object value);
	
	/**
	 * 保存对象
	 * @param instance
	 * @return
	 */
	public boolean save(T instance);
}
