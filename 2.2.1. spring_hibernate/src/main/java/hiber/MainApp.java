package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User("Ivan", "Petrov", "Ipetrov@mail.ru");
      user1.setCar(new Car(150, "Prado", user1));
      userService.add(user1);

      User user2 = new User("Marya", "Ivanova", "MIvanova@bk.ru");
      user2.setCar(new Car(206, "Peugeot", user2));
      userService.add(user2);

      User user3 = new User("Petya", "Ryushin", "PRyushin@yandex.ru");
      user3.setCar(new Car(1, "Maclaren", user3));
      userService.add(user3);

      List<User> users = userService.listUsers();
//      System.out.println("\033[0;32m" + "Just all users toString output" + "\033[0m");
      users.forEach(System.out::println);

      System.out.println("Users in reversed order by hql");
      System.out.println(userService.getUser("Maclaren", 1));
      System.out.println(userService.getUser("Peugeot", 206));
      System.out.println(userService.getUser("Prado", 150));


      context.close();
   }
}
