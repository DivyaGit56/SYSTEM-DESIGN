package Zomato.factories;

import java.util.List;
import Zomato.models.*;
import Zomato.models.Order;
import Zomato.strategies.PaymentStrategy;

public interface OrderFactory {

    Order createOrder(User user, Cart cart, Restaurant restaurant,
                      List<MenuItem> menuItems,
                      PaymentStrategy paymentStrategy,
                      double totalCost, String orderType);
}