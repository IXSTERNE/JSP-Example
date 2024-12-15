package dao;

import java.util.List;
import models.User;


public interface UserDao {
    List<User> getAllUsers();

    void insertUserRecord(String name, String email);
}
