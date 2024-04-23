package com.demo.hibernate;

import com.demo.hibernate.model.Order;

public interface OrderDAO {
	Order getOrder(final long orderid);
	void save(final Order order);
}
