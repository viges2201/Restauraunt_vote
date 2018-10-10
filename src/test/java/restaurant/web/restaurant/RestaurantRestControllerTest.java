package restaurant.web.restaurant;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import restaurant.model.Restaurant;
import restaurant.service.RestaurantService;
import restaurant.web.AbstractControllerTest;
import restaurant.web.json.JsonUtil;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static restaurant.RestaurantTestData.*;
import static restaurant.TestUtil.contentJsonUtil;
import static restaurant.TestUtil.readFromJson;
import static restaurant.model.AbstractBaseEntity.START_SEQ;

class RestaurantRestControllerTest extends AbstractControllerTest {

    private static final String REST_URL = RestaurantRestController.REST_URL + '/';

    @Autowired
    private RestaurantService service;

    @Test
    void testGet() throws Exception {
        mockMvc.perform(get(REST_URL + USER_1_RESTAURANT_ID ))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(contentJsonUtil(USER_RESTAURANT_1));
    }

    @Test
    void testDelete() throws Exception {
        mockMvc.perform(delete(REST_URL + USER_1_RESTAURANT_ID))
                .andExpect(status().isNoContent());
        assertMatch(service.getAll(),  USER_RESTAURANT_2, USER_RESTAURANT_3, USER_RESTAURANT_4, ADMIN_2_RESTAURANT_1,ADMIN_2_RESTAURANT_2);
    }

    @Test
    void testUpdate() throws Exception {
        Restaurant updated = getUpdated();

        mockMvc.perform(put(REST_URL + USER_1_RESTAURANT_ID).contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(updated)))
                .andDo(print())
                .andExpect(status().isOk());

        assertMatch(service.get(USER_1_RESTAURANT_ID, START_SEQ), updated);
    }

    @Test
    void testCreate() throws Exception {
        Restaurant created = getCreated();
        ResultActions action = mockMvc.perform(post(REST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(created)));

        Restaurant returned = readFromJson(action, Restaurant.class);
        created.setId(returned.getId());

        assertMatch(returned, created);
        assertMatch(service.getAll(), USER_RESTAURANT_1, USER_RESTAURANT_2, USER_RESTAURANT_3, USER_RESTAURANT_4,ADMIN_2_RESTAURANT_1,ADMIN_2_RESTAURANT_2, created);
    }

    @Test
    void testGetAll() throws Exception {
        mockMvc.perform(get(REST_URL))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(contentJsonArray(USER_RESTAURANT_1, USER_RESTAURANT_2, USER_RESTAURANT_3, USER_RESTAURANT_4,ADMIN_2_RESTAURANT_1,ADMIN_2_RESTAURANT_2));
    }


}