package by.tms.service;

import by.tms.dao.OperationDao;
import by.tms.dao.UserDao;
import by.tms.entity.Operation;
import by.tms.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
//@Transactional
public class ChangeService {
    @Autowired
    private OperationDao<Operation> operationDao;
    @Autowired
    private UserDao<User> userDao;

    public String changeName(String name, User user) {
        user.setName(name);
        userDao.updateName(user);
        operationDao.updateNameOfOperations(name, user.getUsername());
        return user.getName();
    }

    public void changePassword(String newPassword, User user) {
        user.setPassword(newPassword);
        userDao.updatePassword(user);
    }

    @Transactional
    public void deleteUser(User user) {
        userDao.delete(user);
        operationDao.deleteOperationsByUserName(user.getUsername());
    }

    public void deleteOperation(User user) {
        operationDao.deleteOperationsByUserName(user.getUsername());
    }
}
