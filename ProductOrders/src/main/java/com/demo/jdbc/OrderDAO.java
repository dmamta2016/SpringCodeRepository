package com.demo.jdbc;
import org.springframework.jdbc.core.JdbcTemplate;
import com.demo.jdbc.model.Order;
public interface OrderDAO {
			public void saveOrder(Order o);
}
