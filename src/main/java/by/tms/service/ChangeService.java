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
        userDao.delete(user);
        operationDao.deleteOperationsByUserName(user.getUsername());
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
        List<Telephone> telephones = user.getTelephones();
        telephones.add(new Telephone(0, number));
        user.setTelephones(telephones);
        userDao.updateUser(user);
    }

    public boolean changeNumber(String oldNumber, String newNumber, User user) {
        List<Telephone> telephones = user.getTelephones();
        for (Telephone telephone : telephones) {
            if (telephone.getNumber().equals(oldNumber)) {
               telephones.get(telephones.indexOf(telephone)).setNumber(newNumber);
               userDao.updateUser(user);
               return true;
            }
        }
        return false;
    }

    public boolean deleteNumber(String number, User user) {
        List<Telephone> telephones = user.getTelephones();
        for (Telephone telephone : telephones) {
            if (telephone.getNumber().equals(number)) {
                telephones.remove(telephone);
                userDao.updateUser(user);
                userDao.deleteNumber(telephone);
                return true;
            }
        }
        return false;
    }
}
