package com.demo;
	import com.demo.jdbc.OrderDAO;
	import com.demo.jdbc.model.Order;
	
import org.springframework.context.support.ClassPathXmlApplicationContext;

	public class OrderDemo {

		public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Order order = new Order();
        order.setOrderId(986L);
        order.setCustId(1101L);
        order.setProductName("Rivets");
        order.setPrice(452.0F);
        order.setQuantity(29);
        
      //Get the OrderDAO Bean
      	    		        
       OrderDAO orderDao = (OrderDAO)context.getBean("OrderDAO", OrderDAO.class);
        orderDao.saveOrder(order);
        System.out.println("order saved successfully : " );
        context.close();
	}
}
