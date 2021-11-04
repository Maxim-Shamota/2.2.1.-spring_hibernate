package hiber.dao;

import hiber.model.User;

import java.util.List;

public interface UserDao {
   void add(User user);
   List<User> listUsers();
   void remove(long id);
   User get(long id);
   List<User> userWithCar(String model, int series);
}
