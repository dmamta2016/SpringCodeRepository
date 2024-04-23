package com.demo;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.demo.hibernate.OrderDAO;
import com.demo.hibernate.model.Order;

public class SpringHibernateTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Order order = new Order();
        order.setOrderId(652l);
        order.setCustId(1101L);
        order.setProductName("Bolts");
        order.setPrice(902.0F);
        order.setQuantity(10);
       OrderDAO orderDao = (OrderDAO)context.getBean("orderDAO");
        orderDao.save(order);
        Order stdResult = orderDao.getOrder(652l);
        System.out.println("order enrolled successfully : " + stdResult);
        context.close();
    }

}
