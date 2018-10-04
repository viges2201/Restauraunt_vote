package restaurant.web.restaurant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import restaurant.model.Restaurant;
import restaurant.service.RestaurantService;
import restaurant.web.SecurityUtil;

import java.util.List;

public abstract class AbstractRestaurantController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private RestaurantService service;

    public Restaurant get(int id) {
        int userId = SecurityUtil.authUserId();
        log.info("get meal {} for user {}", id, userId);
        return service.get(id, userId);
    }

    public void delete(int id) {
        int userId = SecurityUtil.authUserId();
        log.info("delete meal {} for user {}", id, userId);
        service.delete(id, userId);
    }

    public List<Restaurant> getAll() {
        int userId = SecurityUtil.authUserId();
        log.info("getAll for user {}", userId);
        return service.getAll();
    }

    public Restaurant create(Restaurant meal) {
        int userId = SecurityUtil.authUserId();
        log.info("create {} for user {}", meal, userId);
        return service.create(meal, userId);
    }

    public void update(Restaurant meal, int id) {
        int userId = SecurityUtil.authUserId();
        log.info("update {} for user {}", meal, userId);
        service.update(meal, userId);
    }
}
