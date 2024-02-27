package ru.slava.SpringBootTest.dao;

import ru.slava.SpringBootTest.model.User;

import java.util.List;

public interface UserDao {

    void saveUser(String name, String lastName, int age, String email);

    public void save(User user);

    User getUserById(Long id);

    void delete(Long id);

    public void update(User userUpdate);

    List<User> findAll();


}
