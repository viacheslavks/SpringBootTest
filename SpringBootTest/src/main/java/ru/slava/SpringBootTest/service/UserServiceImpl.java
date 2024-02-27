package ru.slava.SpringBootTest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.slava.SpringBootTest.dao.UserDao;
import ru.slava.SpringBootTest.model.User;


import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public void saveUser(String name, String lastName, int age, String email) {
        userDao.saveUser(name, lastName, age, email);
    }


    @Transactional
    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Transactional
    @Override
    public User getUserById(long id) {
        return userDao.getUserById(id);
    }

    @Transactional
    @Override
    public void delete(long id) {
        userDao.delete(id);
    }

    @Transactional
    @Override
    public void update(User userUpdate) {
        userDao.update(userUpdate);
    }

    @Transactional
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

}
