package by.tms.dao;

import by.tms.entity.User;

import java.util.Optional;

public interface UserDao<T> {
    public void save(T user);

    public Optional<T> findByUsername(String username);

    void updateName (User user);
    void updatePassword (User user);

    void delete(User user);

}