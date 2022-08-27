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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StopWatch;

import java.util.List;
//If I use "sessionFactory.openSession" (in method:updateNameOfOperations) and then try "query.executeUpdate();"
//it's throws Exception named: javax.persistence.TransactionRequiredException: Executing an update/delete query
//Maybe I use @Transactional not correct or openSession always open new session, but I try to use it in a different dao
//My transaction doesn't work correctly and throws Exception. In debug everything stops in "query.executeUpdate();".
//It's happened when I want to change name of my user.
//Now I use "getCurrentSession" instead of old "openSession" and all works fine despite tha fact that when I have an
//Exception, all works good, but then, when I started to do another operations with user, fore example
//(method deleteOperationsByUserName) Hibernate change the name of the user in "hibernateusers" table, but not at the
//hibernateoperations table.
@Repository
public class HibernateOperationDao implements OperationDao<Operation> {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Operation operation) {
        Session session = sessionFactory.getCurrentSession();
        session.save(operation);
    }

    @Override
    public List<Operation> findAllOperationByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query<Operation> query = session.createQuery("from Operation where username =: un", Operation.class);
        List<Operation> operations = query.setParameter("un", username).getResultList();
        return operations;
    }

    @Override
    public void updateNameOfOperations(String name, String username) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("update Operation set name = :name where username = :username");
        query.setParameter("username", username);
        query.setParameter("name", name);
        query.executeUpdate();
    }


    @Override
    public void deleteOperationsByUserName(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete Operation o where o.username = :username");
        query.setParameter("username", username).executeUpdate();
    }
}
