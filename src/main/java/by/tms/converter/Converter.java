package by.tms.converter;

import by.tms.entity.Address;
import by.tms.entity.Telephone;
import by.tms.entity.User;
import by.tms.model.RegistrationModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Converter {
    public User convertModelToUser(RegistrationModel u){
        User user = new User();
        List<Telephone> telephones = new ArrayList<>();
        telephones.add(new Telephone(0, u.getNumberA1()));
        telephones.add(new Telephone(0, u.getNumberMTC()));
        telephones.add(new Telephone(0, u.getNumberLife()));
        user.setName(u.getName());
        user.setUsername(u.getUsername());
        user.setPassword(u.getPassword());
        user.setAddress(new Address(0, u.getCity(), u.getStreet()));
        user.setTelephones(telephones);
        return user;
    }
}
