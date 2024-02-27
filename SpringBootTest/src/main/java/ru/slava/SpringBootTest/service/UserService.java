package ru.slava.SpringBootTest.service;


import ru.slava.SpringBootTest.model.User;

import java.util.List;

public interface UserService {


    void saveUser(String name, String lastName, int age, String email);

    public void save(User user);

    User getUserById(long id);

    void delete(long id);

    public void update(User userUpdate);

    List<User> findAll();


}
