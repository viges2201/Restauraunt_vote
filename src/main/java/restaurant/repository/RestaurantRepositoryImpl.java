package restaurant.repository;

import restaurant.model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class RestaurantRepositoryImpl {
    @Autowired
    private CrudRestaurantRepository crudRestaurantRepository;

    @Autowired
    private CrudUserRepository crudUserRepository;

    @Transactional
    public Restaurant save(Restaurant restaurant, int userId) {
        if (!restaurant.isNew() && get(restaurant.getId(), userId) == null) {
            return null;
        }
        restaurant.setUser(crudUserRepository.getOne(userId));
        return crudRestaurantRepository.save(restaurant);
    }
    public boolean delete(int id, int userId) {
        return crudRestaurantRepository.delete(id, userId) != 0;
    }

    public Restaurant get(int id, int userId) {
        Restaurant restaurant1 = crudRestaurantRepository.findById(id).filter(restaurant -> restaurant.getUser().getId() == userId).orElse(null);
        return restaurant1;
    }

    public List<Restaurant> getAll() {
        return crudRestaurantRepository.getAll();
    }


    public Restaurant getWithUser(int id, int userId) {
        return crudRestaurantRepository.getWithUser(id, userId);
    }
}
