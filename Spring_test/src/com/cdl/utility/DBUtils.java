package com.cdl.utility;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

@Transactional
//@Service("db")
public class DBUtils{
	
	//@Resource(name="sessionFactory")
	
	static SessionFactory sessionFactory;
	
	/*static{
		ApplicationContext b=new ClassPathXmlApplicationContext("hibernate-context.xml");
		sessionFactory = (SessionFactory) b.getBean("sessionFactory");
	}*/
	
	private Session getSession() 
	{
		Session s = null;
		try 
		{
			//sessionFactory = new Configuration().configure("hibernate-context.xml").buildSessionFactory();
			ApplicationContext b=new ClassPathXmlApplicationContext("hibernate-context.xml");
			sessionFactory = (SessionFactory) b.getBean("sessionFactory");
			s = sessionFactory.openSession();
		} 
		catch (HibernateException e) 
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return s;
	}
	
	public List getList()
	{
		List list=null;
		try
		{
			
			Session session=this.getSession();
			Transaction tx=session.beginTransaction();
			if(session.isOpen() && session.isConnected()){
				list=session.createQuery("from Login").list();
				System.out.println("List:"+list.toString());
				tx.commit();
				session.clear();
				session.close();
			}
		}
		catch(HibernateException ex)
		{
			ex.printStackTrace();
			System.out.println(ex);
		}
		
//		Session session = sessionFactory.openSession();
//		System.out.println("Ger Current Session::"+session.toString());
//		session.beginTransaction();
//		List list;
//		if(session.isOpen() && session.isConnected()){
//			System.out.println("in if "+session.isDirty());
//			list=session.createQuery("from Login").list();
//		}else{
//			System.out.println("in else");
//			session = sessionFactory.getCurrentSession();
//			session.beginTransaction();
//			list=session.createQuery("from Login").list();
//		}
//		System.out.println(list);
//		session.getTransaction().commit();
//		session.
//		session.clear();
//		session.close();
		return list;
	}
	
	

	

}
