package restaurant.web.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import restaurant.model.User;

import static restaurant.web.SecurityUtil.authUserId;


@RestController
@RequestMapping(ProfileRestController.REST_URL)
public class ProfileRestController extends AbstractUserController {
    static final String REST_URL = "/rest/profile";

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public User get() {
        return super.get(authUserId());
    }


    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody User user) {
        super.update(user, authUserId());
    }

    @Override
    @PutMapping(value = "/{idUser}/restaurant/{idRestaurant}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void vote(@PathVariable("idRestaurant") int idRestaurant, @PathVariable("idUser") int idUser) {
        super.vote(idRestaurant, idUser);
    }
}