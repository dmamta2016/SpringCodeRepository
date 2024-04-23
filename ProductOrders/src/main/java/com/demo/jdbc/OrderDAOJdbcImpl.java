package com.demo.jdbc;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.demo.jdbc.model.Order;

public class OrderDAOJdbcImpl implements OrderDAO {
	private DataSource dataSource;
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public void saveOrder(Order o) {
		String insertOrder = "INSERT INTO mydatabase.order (ORDERID, CUSTID, PRODUCTNAME, PRICE, QUANTITY) VALUES(?, ?, ?, ?, ?)";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String query = "insert into mydatabase.order values("+o.getOrderId() + "," + o.getCustId() + ",'" + o.getProductName() + "',"  + o.getPrice()+  "," +o.getQuantity()+ ")";
		System.out.println("query :"+ query);
		int rows=0;
		try {
		 rows = jdbcTemplate.update(query);
		 System.out.println(rows);
		 if(rows !=0){
				System.out.println("Order saved with id="+o.getOrderId());
			}else System.out.println("Order save failed with id="+o.getOrderId());
		}
		 catch (Exception e) {System.out.println(e.getStackTrace());System.out.println(e.getMessage());}
	}
}
