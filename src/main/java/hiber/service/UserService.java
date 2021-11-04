package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();
    void remove(long id);
    User get(long id);
    List<User> userWithCar(String model, int series);
}
