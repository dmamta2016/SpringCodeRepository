package com.demo;
	import com.demo.jdbc.OrderDAO;
	import com.demo.jdbc.model.Order;
	
import org.springframework.context.support.ClassPathXmlApplicationContext;

	public class OrderDemo {

		public static void main(String[] args) {
			
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Order order = new Order();
        order.setOrderId(652l);
        order.setCustId(1101L);
        order.setProductName("Bolts");
        order.setPrice(902.0F);
        order.setQuantity(10);
        
      //Get the OrderDAO Bean
      	    		        
       OrderDAO orderDao = (OrderDAO)context.getBean("OrderDAO", OrderDAO.class);
        orderDao.saveOrder(order);
        //Order result = orderDao.getOrder(652l);
        System.out.println("order saved successfully : " );
        context.close();
		
		    
		   
			
				}
}
