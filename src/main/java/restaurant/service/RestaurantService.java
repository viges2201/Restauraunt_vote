package restaurant.service;

import restaurant.model.Restaurant;
import restaurant.util.NotFoundException;

import java.util.List;

public interface RestaurantService {
    Restaurant get(int id, int userId) throws NotFoundException;

    void delete(int id, int userId) throws NotFoundException;

    List<Restaurant> getAll();

    void update(Restaurant restaurant, int userId) throws NotFoundException;

    Restaurant create(Restaurant restaurant, int userId);

    Restaurant getWithUser(int id, int userId);
}
