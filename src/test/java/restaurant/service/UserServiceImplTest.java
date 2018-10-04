package restaurant.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.bridge.SLF4JBridgeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import restaurant.RestaurantTestData;
import restaurant.TimingExtension;
import restaurant.model.Role;
import restaurant.model.User;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static restaurant.UserTestData.*;

@SpringJUnitConfig(locations = {
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
@ExtendWith(TimingExtension.class)
class UserServiceImplTest {
    static {
        // needed only for java.util.logging (postgres driver)
        SLF4JBridgeHandler.install();
    }
    @Autowired
    protected UserService service;

    @Test
    void create() throws Exception{
        User newUser = new User(null, "New", "new@gmail.com", "newPass",  false, Collections.singleton(Role.ROLE_USER));
        User created = service.create(new User(newUser));
        newUser.setId(created.getId());
        assertMatch(service.getAll(), ADMIN, newUser, USER);
    }

    @Test
    void delete() throws Exception{
        service.delete(USER_ID);
        assertMatch(service.getAll(), ADMIN);
    }

    @Test
    void get() throws Exception{
        User user = service.get(ADMIN_ID);
        assertMatch(user, ADMIN);
    }

    @Test
    void getByEmail() {
        User user = service.getByEmail("admin@gmail.com");
        assertMatch(user, ADMIN);
    }

    @Test
    void update() {
        User updated = new User(USER);
        updated.setName("UpdatedName");
        updated.setRoles(Collections.singletonList(Role.ROLE_ADMIN));
        service.update(new User(updated));
        assertMatch(service.get(USER_ID), updated);
    }

    @Test
    void getAll() {
        List<User> all = service.getAll();
        assertMatch(all, ADMIN, USER);
    }

    @Test
    void getWithRestaurant() {
        User admin = service.getWithRestaurant(ADMIN_ID);
        assertMatch(admin, ADMIN);
        RestaurantTestData.assertMatch(admin.getRestaurants(), RestaurantTestData.ADMIN_2_RESTAURANT_1, RestaurantTestData.ADMIN_2_RESTAURANT_2);
    }
}