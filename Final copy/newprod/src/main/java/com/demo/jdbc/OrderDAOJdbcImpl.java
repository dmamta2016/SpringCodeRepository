package com.demo.jdbc;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

	/*@Override
	public Order getById(long id) {
		String query = "select OrderId, CustID, ProductName, Price, Quantity where orderid = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		//using RowMapper anonymous class, we can create a separate RowMapper for reuse
		Employee emp = jdbcTemplate.queryForObject(query, new Object[]{id}, new RowMapper<Employee>(){

			@Override
			public Employee mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				Employee emp = new Employee();
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setRole(rs.getString("role"));
				return emp;
			}});
		
		return emp;
	}*/

	/*@Override
	public void update(Employee employee) {
		String query = "update Employee set name=?, role=? where id=?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		Object[] args = new Object[] {employee.getName(), employee.getRole(), employee.getId()};
		
		int out = jdbcTemplate.update(query, args);
		if(out !=0){
			System.out.println("Employee updated with id="+employee.getId());
		}else System.out.println("No Employee found with id="+employee.getId());
	}

	@Override
	public void deleteById(int id) {

		String query = "delete from Employee where id=?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		int out = jdbcTemplate.update(query, id);
		if(out !=0){
			System.out.println("Employee deleted with id="+id);
		}else System.out.println("No Employee found with id="+id);
	}

	@Override
	public List<Employee> getAll() {
		String query = "select id, name, role from Employee";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Employee> empList = new ArrayList<Employee>();

		List<Map<String,Object>> empRows = jdbcTemplate.queryForList(query);
		
		for(Map<String,Object> empRow : empRows){
			Employee emp = new Employee();
			emp.setId(Integer.parseInt(String.valueOf(empRow.get("id"))));
			emp.setName(String.valueOf(empRow.get("name")));
			emp.setRole(String.valueOf(empRow.get("role")));
			empList.add(emp);
		}
		return empList;
	}*/

}
