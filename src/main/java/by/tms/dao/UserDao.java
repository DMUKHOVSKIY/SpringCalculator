package by.tms.dao;

import by.tms.entity.Telephone;
import by.tms.entity.User;

import java.util.Optional;

public interface UserDao<T> {
    public void save(T user);

    public Optional<T> findByUsername(String username);

    void updateUser(User user);

    void delete(User user);

    void deleteNumber(Telephone telephone);

}