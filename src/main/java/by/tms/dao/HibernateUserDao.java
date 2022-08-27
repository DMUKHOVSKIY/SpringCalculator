package by.tms.dao;

import by.tms.entity.Telephone;
import by.tms.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.Optional;

@Repository
public class HibernateUserDao implements UserDao<User> {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    @Override
    public Optional findByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query<User> query = session.createQuery("from User where username =: un", User.class);
        User user = null;
        try {
            user = query.setParameter("un", username).getSingleResult();
        } catch (NoResultException nre) {

        }
        return Optional.ofNullable(user);
    }

    @Override
    public void updateUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
    }

    @Override
    public void delete(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(user);
    }

    @Override
    public void deleteNumber(Telephone telephone) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete Telephone where number =: number").setParameter("number", telephone.getNumber()).executeUpdate();
    }

}
