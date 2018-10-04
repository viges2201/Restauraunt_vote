package restaurant.service;

import restaurant.model.User;
import restaurant.util.NotFoundException;

import java.util.List;

public interface UserService {
    User create(User user);

    void delete(int id) throws NotFoundException;

    User get(int id) throws NotFoundException;

    User getByEmail(String email) throws NotFoundException;

    void update(User user);

    List<User> getAll();

    User getWithRestaurant(int id);

    void  vote(int idRestaurant, int idUser);

    void voteDump();
}
