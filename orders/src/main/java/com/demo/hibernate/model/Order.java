package com.demo.hibernate.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order")
public class Order {

	@Id
	@Column(name = "orderid", nullable = false)
	private Long orderid;
	
	@Column(name = "custid")
	private Long custid;
	
	@Column(name = "productname")
	private String productname;
	
	@Column(name = "price")
	private Float price;

	
	@Column(name = "qty")
	private Integer quantity;

	public Long getOrderId() {
		return orderid;
	}

	public void setOrderId(Long orderid) {
		this.orderid = orderid;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}
	
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	/*public String getName() {
		return name;
	}
*/
	public void setProductName(String name) {
		this.productname = name;
	}
/*	public Integer getMarks() {
		return marks;
	}
*/
	public void setCustId(Long custid) {
		this.custid = custid;
	}

	@Override
	public String toString() {
		return "Order [orderid=" + orderid + ", custid=" + custid + ", productname=" + productname + ", price=" + price + ",quantity="+quantity+"]";
	}

}

