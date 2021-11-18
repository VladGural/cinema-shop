package demo.spring.service;

import demo.spring.model.Order;
import demo.spring.model.ShoppingCart;
import demo.spring.model.User;
import java.util.List;

public interface OrderService {
    Order completeOrder(ShoppingCart shoppingCart);

    List<Order> getOrdersHistory(User user);
}
