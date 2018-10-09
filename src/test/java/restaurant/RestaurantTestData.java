package restaurant;

import org.springframework.test.web.servlet.ResultMatcher;
import restaurant.model.Restaurant;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static restaurant.model.AbstractBaseEntity.START_SEQ;
import static restaurant.web.json.JsonUtil.writeIgnoreProps;

public class RestaurantTestData {

    public static final int USER_1_RESTAURANT_ID = START_SEQ + 2;
    public static final int ADMIN_2_RESTAURANT_ID = START_SEQ + 6;

    public static final Restaurant USER_RESTAURANT_1 = new Restaurant(USER_1_RESTAURANT_ID, "firsRest", "borsh", 1234, 4);
    public static final Restaurant USER_RESTAURANT_2 = new Restaurant(USER_1_RESTAURANT_ID + 1, "secondRest", "pureshka", 897, 7);
    public static final Restaurant USER_RESTAURANT_3 = new Restaurant(USER_1_RESTAURANT_ID + 2, "thirdRest", "pureshka", 2434, 5);
    public static final Restaurant USER_RESTAURANT_4 = new Restaurant(USER_1_RESTAURANT_ID + 3, "fourRest", "pureshka", 34356, 2);

    public static final Restaurant ADMIN_2_RESTAURANT_1 = new Restaurant(ADMIN_2_RESTAURANT_ID, "fiveRest", "AdminKotletka", 34311, 3);
    public static final Restaurant ADMIN_2_RESTAURANT_2 = new Restaurant(ADMIN_2_RESTAURANT_ID + 1, "sixRest", "AdminGrecha", 34476, 9);


    public static Restaurant getCreated() {
        return new Restaurant(null, "NewRest", "wtf", 324, 4);
    }

    public static Restaurant getUpdated() {
        return new Restaurant(USER_1_RESTAURANT_ID, USER_RESTAURANT_1.getName(), "Обновленный завтрак", 200, 5);
    }

    public static void assertMatch(Restaurant actual, Restaurant expected) {
        assertThat(actual).isEqualToIgnoringGivenFields(expected, "user");
    }

    public static void assertMatch(Iterable<Restaurant> actual, Restaurant... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }

    public static void assertMatch(Iterable<Restaurant> actual, Iterable<Restaurant> expected) {
        assertThat(actual).usingElementComparatorIgnoringFields("user").isEqualTo(expected);
    }
    public static ResultMatcher contentJson(Restaurant... expected) {
        return content().json(writeIgnoreProps(Arrays.asList(expected), "registered"));
    }
}
