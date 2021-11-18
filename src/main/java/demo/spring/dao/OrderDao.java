package demo.spring.dao;

import demo.spring.model.Order;
import demo.spring.model.User;
import java.util.List;

public interface OrderDao {
    Order add(Order order);

    List<Order> getOrdersHistory(User user);
}
