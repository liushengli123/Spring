package dao;

import admin.User;

import java.util.List;

public interface UserDao {
    public List<User> findbyCollection(User user);
    public List<User> findlist(List<String> list);
}
