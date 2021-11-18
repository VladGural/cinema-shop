package demo.spring.service;

import demo.spring.model.MovieSession;
import demo.spring.model.ShoppingCart;
import demo.spring.model.User;

public interface ShoppingCartService {
    void addSession(MovieSession movieSession, User user);

    ShoppingCart getByUser(User user);

    void registerNewShoppingCart(User user);

    void clear(ShoppingCart shoppingCart);
}
