package by.tms.service;

import by.tms.dao.UserDao;
import by.tms.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserDao userDao;

    public boolean save(User user) {
        Optional<User> byUsername = findByUsername(user.getUsername());
        if (byUsername.isPresent()) {
            return false;
        }
        userDao.save(user);
        return true;
    }

    @Transactional(readOnly = true)
    public Optional<User> findByUsername(String username) {
        return userDao.findByUsername(username);
    }

}
