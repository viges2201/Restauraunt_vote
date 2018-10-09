package restaurant.service;

import restaurant.model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import restaurant.repository.RestaurantRepositoryImpl;
import restaurant.util.NotFoundException;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantRepositoryImpl repository;

    @Autowired
    public RestaurantServiceImpl(RestaurantRepositoryImpl restaurantRepository) {
        this.repository = restaurantRepository;
    }

    @Override
    public Restaurant get(int id, int userId) throws NotFoundException {
        return repository.get(id, userId);
    }

    @Override
    public void delete(int id, int userId) throws NotFoundException {
        repository.delete(id, userId);
    }

    @Override
    public List<Restaurant> getAll() {
        return repository.getAll();
    }

    @Override
    public void update(Restaurant restaurant, int userId) throws NotFoundException {
        repository.save(restaurant, userId);
    }

    @Override
    public Restaurant create(Restaurant restaurant, int userId) {
        Assert.notNull(restaurant, "Restaurant must not be null");
        return repository.save(restaurant, userId);
    }

    @Override
    public Restaurant getWithUser(int id, int userId) {
        return repository.getWithUser(id, userId);
    }

    @Override
    public void voteDump() {
        repository.voteDump();
    }
}
