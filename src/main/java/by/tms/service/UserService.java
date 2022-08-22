package by.tms.service;

import by.tms.entity.User;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public interface UserService {
    boolean save(User user);

    Optional<User> findByUsername(String username);

}
