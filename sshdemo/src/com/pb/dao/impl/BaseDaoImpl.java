package com.pb.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.pb.dao.IBaseDao;

public abstract class BaseDaoImpl<T> implements IBaseDao<T> {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private Class<T> entityClass;
	private String className;
	private HibernateTemplate hibernateTemplate;
	private PlatformTransactionManager ptm; // 用于对事务进行处理
	private DefaultTransactionDefinition dtd; // 默认事务定义
	
	@SuppressWarnings("all")
	public BaseDaoImpl() {
		// 对泛型T所表示的类进行读取显示
		try {
			entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		} catch (Exception e) {
			entityClass = (Class<T>) Object.class;
			e.printStackTrace();
		}
		className = entityClass.getSimpleName(); // 泛型类的名称(非完全限定名)
	}
	/**
	 * 通过IOC方式注入SessionFactory
	 * @param sessionFactory
	 */
	public void setSessionFactory(SessionFactory sessionFactory){
		// 实例化HibernateTemplate对象
		hibernateTemplate =new HibernateTemplate(sessionFactory);
	}
	/**
	 * 通过IOC方式注入ptm
	 * @param ptm
	 */
	public void setPtm(PlatformTransactionManager ptm) {
		this.ptm=ptm;
		// 实例化默认事务定义
		dtd=new DefaultTransactionDefinition();
		// 设置传播特性
		dtd.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
	}
	/**
	 * 按属性查询
	 */
	@SuppressWarnings("unchecked")
	public List<T> findByProperty(String propertyName, Object value) {
		List<T> list = new ArrayList<T>();
		log.debug("finding " + className + " instance with property: "
				+ propertyName + ", value: " + value);
		try {
			// 定义查询语句
			String queryString = "from " + className + " as model where model."
					+ propertyName + "= ?";
			list=hibernateTemplate.find(queryString,new Object[]{value});
		} catch (Exception e) {
			log.error("find by property name failed", e);
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 保存对象
	 */
	public boolean save(T instance) {
		TransactionStatus ts=null;
		try {
			// 取得事务状态,即：开始一个事务
			ts=ptm.getTransaction(dtd);
			hibernateTemplate.save(instance);
			ptm.commit(ts); // 提交事务
			return true;
		} catch (Exception e) {
			ptm.rollback(ts); // 回滚事务
			e.printStackTrace();
		}
		return false;
	}

}
