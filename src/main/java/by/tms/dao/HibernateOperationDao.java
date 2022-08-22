package by.tms.dao;

import by.tms.entity.Operation;
import by.tms.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.util.StopWatch;

import java.util.List;

@Repository
public class HibernateOperationDao implements OperationDao<Operation> {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Operation operation) {
        Session session = sessionFactory.openSession();
        session.save(operation);
        session.close();
    }

    @Override
    public List<Operation> findAllOperationByUsername(String username) {
        Session session = sessionFactory.openSession();
        Query<Operation> query = session.createQuery("from Operation where username =: un", Operation.class);
        List<Operation> operations = query.setParameter("un", username).getResultList();
        session.close();
        return operations;
    }

    //@Override
    public void updateNameOfOperations(String name, String username) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("update Operation set name = :name where username = :username");
        query.setParameter("username", username);
        query.setParameter("name", name);
        query.executeUpdate();
        transaction.commit();
        session.close();
    }


    @Override
    public void deleteOperationsByUserName(String username) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("delete Operation o where o.username = :username");
        query.setParameter("username", username).executeUpdate();
        transaction.commit();
        session.close();
    }
}
