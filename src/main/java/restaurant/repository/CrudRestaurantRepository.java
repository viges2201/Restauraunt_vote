package restaurant.repository;

import restaurant.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface CrudRestaurantRepository extends JpaRepository<Restaurant, Integer> {
    @Modifying
    @Transactional
    @Query("DELETE FROM Restaurant r WHERE r.id=:id AND r.user.id=:userId")
    int delete(@Param("id") int id, @Param("userId") int userId);

    @Override
    @Transactional
    Restaurant save(Restaurant item);

    @Query("SELECT r FROM Restaurant r ")
    List<Restaurant> getAll();


    @Query("SELECT r FROM Restaurant r JOIN FETCH r.user WHERE r.id = ?1 and r.user.id = ?2")
    Restaurant getWithUser(int id, int userId);

    @Modifying
    @Transactional
    @Query("UPDATE Restaurant r SET r.vote=0")
    void voteDump();
}
