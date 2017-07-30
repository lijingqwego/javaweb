package com.huiji.utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 会话工厂操作
 * @author Administrator
 *
 */
public class HibernateUtil {
	
	private static SessionFactory sessionFactory=null;
	
	/**
	 * 初始化配置，加载配置文件，并且创建SessionFactory会话工厂
	 */
	static{
		try {
			Configuration configure = new Configuration().configure();//加载hibernate.cfg.xml配置文件
			sessionFactory=configure.buildSessionFactory();//创建session工厂
		} catch (HibernateException e) {
			throw new RuntimeException("创建会话工厂失败");
		}
	}
	
	/**
	 * 获取Session
	 * @return
	 */
	public static Session getSession(){
		
		Session session = sessionFactory.openSession();
		if(session==null || !session.isOpen()){
			try {
				Configuration configure = new Configuration().configure();//加载hibernate.cfg.xml配置文件
				sessionFactory=configure.buildSessionFactory();//创建session工厂
			} catch (HibernateException e) {
				throw new RuntimeException("创建会话工厂失败");
			}
		}
		return session;
	}
	
	/**
	 * 获取SessionFactory
	 * @return
	 */
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	
	/**
	 * 关闭Session
	 */
	public static void closeSession(){
		Session session=sessionFactory.openSession();
		if(session!=null){
			session.close();
		}
	}
}
