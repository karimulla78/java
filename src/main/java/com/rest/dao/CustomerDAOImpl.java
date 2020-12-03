package com.rest.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Query;


import com.rest.service.Customer;

public class CustomerDAOImpl implements CustomerDAO{
	 private SessionFactory sessionFactory;

	    public void setSessionFactory(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }
	    
		public void save(Customer emp) {
			Session session = this.sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.persist(emp);
			tx.commit();
			session.close();
		}

		@SuppressWarnings("unchecked")
		public List<Customer> list() {
			Session session = this.sessionFactory.openSession();
			List<Customer> empList = session.createQuery("from com.rest.service.Customer").list();
			session.close();
			return empList;
		}
	        
	        @SuppressWarnings("unchecked")
		public void update(Customer emp) {
			Session session = this.sessionFactory.openSession();
	                Transaction tx = session.beginTransaction();
	                Query query =session.createQuery("update com.rest.service.Customer set name=:n , country=:country where no=:i");
	                query.setParameter("n", emp.getCustName());
	                query.setParameter("country",emp.getCustCountry());
	                query.setParameter("i",emp.getCustNo());
	                int status =query.executeUpdate();
	                System.out.println("-------status---"+status);
	                tx.commit();
			session.close();
		}

	        @SuppressWarnings("unchecked")
		public void delete(Customer emp) {
			Session session = this.sessionFactory.openSession();
	                Transaction tx = session.beginTransaction();
	                Query query =session.createQuery("delete from com.rest.service.Customer where no=:i");
	                query.setParameter("i",emp.getCustNo());
	                int status =query.executeUpdate();
	                System.out.println("-------status---"+status);
	                tx.commit();
			session.close();
		}

}
