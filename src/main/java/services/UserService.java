package services;

import java.util.List;

import models.User;
import utils.DataAccessException;
import dao.impl.UserDaoImpl;
import dao.UserDao;

public class UserService {
    
    private UserDao userDao = new UserDaoImpl();

    public List<User> displayAllUsers() throws DataAccessException{
        return userDao.getAllUsers();
    }

    public void addUser(String name, String email) throws DataAccessException{
        userDao.insertUserRecord(name, email);
    }
}
