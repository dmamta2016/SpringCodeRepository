package com.demo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.demo.hibernate.model.Order;

public class OrderDAOImpl implements OrderDAO {

	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	public Order getOrder(final long orderid) {
		Session session = this.sessionFactory.openSession();
		return (Order)session.get(Order.class, orderid);
	}

	public void save(final Order order) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(order);
		tx.commit();
		session.close();
	}
}
