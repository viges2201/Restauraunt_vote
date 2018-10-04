import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import restaurant.model.Role;
import restaurant.model.User;
import restaurant.service.UserService;
import restaurant.service.UserServiceImpl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

public class SpringMain {
    public static void main(String[] args) {
        // java 7 Automatic resource management
        try (GenericXmlApplicationContext appCtx = new GenericXmlApplicationContext()) {
            appCtx.load("spring/spring-app.xml", "spring/spring-db.xml");
            appCtx.refresh();

            UserService bean = appCtx.getBean(UserService.class);
            bean.create(new User(null, "userName", "email@mail.ru", "password", Role.ROLE_ADMIN));
//            User user = bean.get(100001);
//            System.out.println(user);
        }
    }
}
