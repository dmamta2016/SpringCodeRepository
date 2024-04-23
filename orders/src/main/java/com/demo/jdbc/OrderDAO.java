package com.demo.jdbc;
import org.springframework.jdbc.core.JdbcTemplate;
import com.demo.jdbc.model.Order;
public interface OrderDAO {
	//Create
	//	public void save(Order order);
		//Read
		//public Order getById(long orderid);
		//Update
		//public void update(Order order);
		public void saveOrder(Order o);

}
