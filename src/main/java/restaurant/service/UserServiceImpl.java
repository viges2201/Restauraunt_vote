package restaurant.service;

import org.springframework.transaction.annotation.Transactional;
import restaurant.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import restaurant.repository.UserRepositoryImpl;
import restaurant.util.NotFoundException;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepositoryImpl repository;

    @Autowired
    public UserServiceImpl(UserRepositoryImpl repository) {
        this.repository = repository;
    }

    @Override
    public User create(User user) {
        Assert.notNull(user, "user must not be null");
        return repository.save(user);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        repository.delete(id);
    }

    @Override
    public User get(int id) throws NotFoundException {
        return repository.get(id);
    }

    @Override
    public User getByEmail(String email) throws NotFoundException {
        return repository.getByEmail(email);
    }

    @Override
    public void update(User user) {
        repository.save(user);
    }

    @Override
    public List<User> getAll() {
        return repository.getAll();
    }

    @Override
    public User getWithRestaurant(int id) {
        return repository.getWithRestaurant(id);
    }

    @Transactional
    @Override
    public void vote(int idRestaurant, int idUser) {
        repository.voting(idRestaurant);
        repository.isVoted(idUser);
    }

    @Override
    public void voteDump() {
        repository.voteDump();
    }
}
