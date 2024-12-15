package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.User;
import dao.UserDao;
import utils.Database;


public class UserDaoImpl implements UserDao{

    private static final String LOOK_USERS = "SELECT * FROM users";
    private static final String INSERT_USER = "INSERT INTO users (name, email) VALUES (?, ?)";

    public List<User> getAllUsers(){

        List<User> users = new ArrayList<>();
        Connection connection = Database.getInstance().getConnection();

        try{
            PreparedStatement ps = connection.prepareStatement(LOOK_USERS);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                users.add(user);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public void insertUserRecord(String name, String email){

        Connection connection = Database.getInstance().getConnection();
        try{
            PreparedStatement ps = connection.prepareStatement(INSERT_USER);

            ps.setString(1, name);
            ps.setString(2, email);
            ps.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}
