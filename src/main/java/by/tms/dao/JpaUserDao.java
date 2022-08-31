package by.tms.dao;

import by.tms.entity.Telephone;
import by.tms.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.Optional;

@Repository
public class JpaUserDao implements UserDao<User> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        TypedQuery<User> namedQuery = entityManager.createNamedQuery("User.findByUsername", User.class);
        namedQuery.setParameter("username", username);
        User singleResult = null;
        try {
            singleResult = namedQuery.getSingleResult();
        } catch (NoResultException e) {

        }
        return Optional.ofNullable(singleResult);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void delete(User user) {
        entityManager.remove(user);
    }

    @Override
    public void deleteNumber(Telephone telephone) {
      entityManager.remove(telephone);
    }
}
