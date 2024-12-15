package models;

import java.io.Serializable;


// I could do some research on Bidirectional relationship but life's too short for that
public class User implements Serializable{
    private int userId;
    private String name;
    private String email;

    public User(){}

    public User(int userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
    }

    public int getUserId(){ return userId; }
    public String getName(){ return name; }
    public String getEmail(){ return email; }

    public void setUserId(int userId){ this.userId = userId; }
    public void setName(String name){ this.name = name; }
    public void setEmail(String email){ this.email = email; }
}
