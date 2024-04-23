package com.demo.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import com.demo.jdbc.model.Order;

public class OrderDAOImpl implements OrderDAO{
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void save(Order o) {
		String insertStudent = "INSERT INTO mydatabase.order (ORDERID, CUSTID, PRODUCTNAME, PRICE, QUANTITY) VALUES(?, ?, ?, ?, ?)";
		String driver = "com.mysql.jdbc.Driver";
		String connection = "jdbc:mysql://localhost:3306/mydatabase";
		String user = "root";
		String password = "";
		try {
			Class.forName(driver);
			Connection con;
			con = DriverManager.getConnection(connection, user, password);
			PreparedStatement preparedStatement = con.prepareStatement(insertStudent);
			preparedStatement.setLong(1, 1101);
			preparedStatement.setLong(2, 99);
			preparedStatement.setString(3, "Rivets");
			preparedStatement.setFloat(4, 5.5F);
			preparedStatement.setInt(5, 15);
			System.out.println(preparedStatement);
			preparedStatement.addBatch();

			preparedStatement.executeBatch();
			System.out.println("success");
		}
		catch (Exception e) {System.out.println(e.getStackTrace());System.out.println(e.getMessage());}
	}
	public void saveOrder(Order o) {

	String query = "insert into mydatabase.order values("+o.getOrderId() + "," + o.getCustId() + ",'" + o.getProductName() + "',"  + o.getPrice()+  "," +o.getQuantity()+ ")";
	System.out.println("query :"+ query);
	int rows=0;
	try {
	 rows = jdbcTemplate.update(query);
	 System.out.println(rows);
	}
	 catch (Exception e) {System.out.println(e.getStackTrace());System.out.println(e.getMessage());}
	// return rows;

	}


	public Order getById(long orderid) {
		String query = "select OrderId, CustID, ProductName, Price, Quantity where orderid = ?";
		Order order = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setLong(1, orderid);
			rs = ps.executeQuery();
			if(rs.next()){
				order = new Order();
				order.setOrderId(orderid);
				order.setProductName(rs.getString("ProductName"));
				order.setPrice(rs.getFloat("price"));
				System.out.println("Order Found::"+order);
			}else{
				System.out.println("No Order found with id="+orderid);
			}
		}
		catch (SQLException e) {System.out.println(e.getStackTrace());System.out.println(e.getMessage());}
		catch (Exception e) {System.out.println(e.getStackTrace());System.out.println(e.getMessage());}
		finally{
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return order;
	}

	/*@Override
	public void update(Employee employee) {
		String query = "update Employee set name=?, role=? where id=?";
		Connection con = null;
		PreparedStatement ps = null;
		try{
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, employee.getName());
			ps.setString(2, employee.getRole());
			ps.setInt(3, employee.getId());
			int out = ps.executeUpdate();
			if(out !=0){
				System.out.println("Employee updated with id="+employee.getId());
			}else System.out.println("No Employee found with id="+employee.getId());
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}*/

	/*	@Override
	public void deleteById(int id) {
		String query = "delete from Employee where id=?";
		Connection con = null;
		PreparedStatement ps = null;
		try{
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			int out = ps.executeUpdate();
			if(out !=0){
				System.out.println("Employee deleted with id="+id);
			}else System.out.println("No Employee found with id="+id);
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<Employee> getAll() {
		String query = "select id, name, role from Employee";
		List<Employee> empList = new ArrayList<Employee>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()){
				Employee emp = new Employee();
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setRole(rs.getString("role"));
				empList.add(emp);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return empList;
	}*/

}
