package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);


        User user1 = new User("User1", "Lastname1", "user1@mail.ru");
        Car car1 = new Car("BMW",7);
        user1.setCar(car1);
        userService.add(user1);

        User user2 = new User("User2", "Lastname2", "user2@mail.ru");
        Car car2 = new Car("AUDI",1);
        user2.setCar(car2);
        userService.add(user2);

        User user3 = new User("User3", "Lastname3", "user3@mail.ru");
        userService.add(user3);

        User user4 = new User("User4", "Lastname4", "user4@mail.ru");
        userService.add(user4);

        // метод извлечения user-a с заданной моделью и серийным номером машины
        System.out.println(userService.userWithCar("BMW", 7));

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            if (user.getCar() != null) {
                System.out.println("Car model = " + user.getCar().getModel());
                System.out.println("Car series = " + user.getCar().getSeries());
            }
            System.out.println();
        }

        context.close();
    }
}
