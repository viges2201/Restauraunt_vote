package restaurant.repository;

import restaurant.model.AbstractBaseEntity;
import restaurant.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

import static restaurant.web.SecurityUtil.authUserId;

@Repository
public class UserRepositoryImpl {
    private static final Sort SORT_NAME_EMAIL = new Sort(Sort.Direction.ASC, "name", "email");

    private final CrudUserRepository crudRepository;

    @Autowired
    public UserRepositoryImpl(CrudUserRepository crudRepository) {
        this.crudRepository = crudRepository;
    }

    public User save(User user) {
        return crudRepository.save(user);
    }

    public boolean delete(int id) {
        return crudRepository.delete(id) != 0;
    }

    public User get(int id) {
        return crudRepository.findById(id).orElse(null);
    }

    public User getProxy(int id){
        return crudRepository.getOne(id);
    }

    public User getByEmail(String email) {
        return crudRepository.getByEmail(email);
    }

    public List<User> getAll() {
        return crudRepository.findAll(SORT_NAME_EMAIL);
    }

    public User getWithRestaurant(int id) {
        return crudRepository.getWithRestaurant(id);
    }

    public void voting(int id) {
        crudRepository.voting(id);
    }

    public void isVoted(int id) {
        crudRepository.enableTrue(id);
    }

    public void enableFalse() {
        crudRepository.enableFalse();
    }


}
