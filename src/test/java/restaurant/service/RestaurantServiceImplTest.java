package restaurant.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.bridge.SLF4JBridgeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;
import restaurant.TimingExtension;
import restaurant.UserTestData;
import restaurant.model.Restaurant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static restaurant.RestaurantTestData.*;
import static restaurant.UserTestData.ADMIN_ID;
import static restaurant.UserTestData.USER_ID;

@SpringJUnitConfig(locations = {
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
@ExtendWith(TimingExtension.class)
class RestaurantServiceImplTest {
    static {
        // needed only for java.util.logging (postgres driver)
        SLF4JBridgeHandler.install();
    }

    @Autowired
    protected RestaurantService service;

    @Test
    void get() {
        Restaurant actual = service.get(ADMIN_2_RESTAURANT_ID, ADMIN_ID);
        assertMatch(actual, ADMIN_2_RESTAURANT_1);
    }

    //    @Transactional
    @Test
    void delete() {
        service.delete(USER_1_RESTAURANT_ID, USER_ID);
        assertMatch(service.getAll(), USER_RESTAURANT_2, USER_RESTAURANT_3, USER_RESTAURANT_4, ADMIN_2_RESTAURANT_1, ADMIN_2_RESTAURANT_2);

    }

    @Test
    void getAll() {
        Restaurant actual = service.get(ADMIN_2_RESTAURANT_ID + 1, ADMIN_ID);
        assertMatch(actual, ADMIN_2_RESTAURANT_2);
    }

    @Test
    void update() {
        Restaurant updated = getUpdated();
        service.update(updated, USER_ID);
        assertMatch(service.get(USER_1_RESTAURANT_ID, USER_ID), updated);
    }

//    @Transactional
    @Test
    void create() {
        Restaurant created = getCreated();
        service.create(created, USER_ID);
        assertMatch(service.getAll(), USER_RESTAURANT_1, USER_RESTAURANT_2, USER_RESTAURANT_3, USER_RESTAURANT_4, ADMIN_2_RESTAURANT_1, ADMIN_2_RESTAURANT_2, created);

    }

    @Test
    void getWithUser() {
        Restaurant adminMeal = service.getWithUser(ADMIN_2_RESTAURANT_ID, ADMIN_ID);
        assertMatch(adminMeal, ADMIN_2_RESTAURANT_1);
        UserTestData.assertMatch(adminMeal.getUser(), UserTestData.ADMIN);

    }
}