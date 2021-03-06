package restaurant.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import restaurant.model.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public interface CrudUserRepository extends JpaRepository<User, Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM User u WHERE u.id=:id")
    int delete(@Param("id") int id);

    @Override
    @Transactional
    User save(User user);

    @Override
    Optional<User> findById(Integer id);

    @Override
    List<User> findAll(Sort sort);

    User getByEmail(String email);

    @Query("SELECT u FROM User u JOIN FETCH u.restaurants WHERE u.id=?1")
    User getWithRestaurant(int id);

    @Modifying
    @Query("UPDATE Restaurant r SET r.vote=r.vote+1 WHERE r.id=?1")
    void voting(int id);

    @Modifying
    @Query("UPDATE User u SET u.enabled=true WHERE u.id=?1")
    void enableTrue(int id);

    @Modifying
    @Query("UPDATE User u SET u.enabled=false")
    void enableFalse();

    @Override
    User getOne(Integer integer);
}
