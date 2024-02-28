package ru.slava.SpringBootTest.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import ru.slava.SpringBootTest.model.User;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext()
    private EntityManager entityManager;


    @Override
    public void saveUser(String name, String lastName, int age, String email) {
        User user = new User(name, lastName, age, email);
        entityManager.persist(user);
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void delete(Long id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
        }
    }

    @Override
    public void update(User userUpdate) {
        User userToBeUpdate = entityManager.find(User.class, userUpdate.getId());

        if (userToBeUpdate != null) {
            userToBeUpdate.setName(userUpdate.getName());
            userToBeUpdate.setLastName(userUpdate.getLastName());
            userToBeUpdate.setAge(userUpdate.getAge());
            userToBeUpdate.setEmail(userUpdate.getEmail());

            entityManager.merge(userToBeUpdate);
        }
    }


    @Override
    public List<User> findAll() {
        String hql = "SELECT u FROM User u";
        Query query = entityManager.createQuery(hql, User.class);
        return query.getResultList();
    }
}
