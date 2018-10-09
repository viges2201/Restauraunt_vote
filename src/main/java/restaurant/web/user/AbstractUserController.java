package restaurant.web.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import restaurant.model.Restaurant;
import restaurant.model.User;
import restaurant.service.RestaurantService;
import restaurant.service.UserService;

import java.util.List;

public abstract class AbstractUserController {
    protected final Logger log = LoggerFactory.getLogger(getClass());
    @Autowired
    RestaurantService restaurantService;

    @Autowired
    private UserService service;

    public List<User> getAll() {
        log.info("getAll");
        return service.getAll();
    }

    public User get(int id) {
        log.info("get {}", id);
        return service.get(id);
    }

    public User create(User user) {
        log.info("create {}", user);
        return service.create(user);
    }

    public void delete(int id) {
        log.info("delete {}", id);
        service.delete(id);
    }

    public void update(User user, int id) {
        log.info("update {} with id={}", user, id);
        service.update(user);
    }

    public User getByMail(String email) {
        log.info("getByEmail {}", email);
        return service.getByEmail(email);
    }

    public Restaurant vote(int idRestaurant, int idUser) {
        log.info("vote user with id {} to Restaurant {}", idRestaurant, idUser);

        service.vote(idRestaurant, idUser);

        return restaurantService.get(idRestaurant, idUser);
    }

    public String voteDump() {
        log.info("voteDump");
        restaurantService.voteDump();
        return "Vote is dump";
    }

    public String startVoting() {
        log.info("StartVoting");
        service.enableFalse();
        return "Start vote";
    }
}