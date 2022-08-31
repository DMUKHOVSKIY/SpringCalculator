package by.tms.service;

import by.tms.dao.OperationDao;
import by.tms.dao.UserDao;
import by.tms.entity.Address;
import by.tms.entity.Operation;
import by.tms.entity.Telephone;
import by.tms.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class ChangeService {
    @Autowired
    private OperationDao<Operation> operationDao;
    @Autowired
    private UserDao<User> userDao;

    public String changeName(String name, User user) {
        user.setName(name);
        userDao.updateUser(user);
        operationDao.updateNameOfOperations(name, user.getUsername());
        return user.getName();
    }

    public void changePassword(String newPassword, User user) {
        user.setPassword(newPassword);
        userDao.updateUser(user);
    }

    @Transactional
    public void deleteUser(User user) {
        Optional<User> byUsername = userDao.findByUsername(user.getUsername());
        User user1 = null;
        if(byUsername.isPresent()){
            user1 = byUsername.get();
        }
        userDao.delete(user1);
        operationDao.deleteOperationsByUserName(user1.getUsername());
    }

    public void deleteOperation(User user) {
        operationDao.deleteOperationsByUserName(user.getUsername());
    }

    public void changeAddress(String newCity, String newStreet, User user) {
        user.getAddress().setCity(newCity);
        user.getAddress().setStreet(newStreet);
        userDao.updateUser(user);

    }

    public void addTelephone(String number, User user) {
        User user1 = null;
        Optional<User> byUsername = userDao.findByUsername(user.getUsername());
        if (byUsername.isPresent()) {
            user1 = byUsername.get();
            user1.getTelephones().add(new Telephone(0, number));
        }
        userDao.updateUser(user1);
    }

    public boolean changeNumber(String oldNumber, String newNumber, User user) {
        Optional<User> byUsername = userDao.findByUsername(user.getUsername());
        User user1 = null;
        if (byUsername.isPresent()) {
            user1 = byUsername.get();
        }
        List<Telephone> telephones = user1.getTelephones();
        for (Telephone telephone : telephones) {
            if (telephone.getNumber().equals(oldNumber)) {
                telephones.get(telephones.indexOf(telephone)).setNumber(newNumber);
                userDao.updateUser(user1);
                return true;
            }
        }
        return false;
    }

    public boolean deleteNumber(String number, User user) {
        Optional<User> byUsername = userDao.findByUsername(user.getUsername());
        User user1 = null;
        if (byUsername.isPresent()) {
            user1 = byUsername.get();
        }
        List<Telephone> telephones = user1.getTelephones();
        for (Telephone telephone : telephones) {
            if (telephone.getNumber().equals(number)) {
                telephones.remove(telephone);
                userDao.deleteNumber(telephone);
                return true;
            }
        }
        return false;
    }
}
