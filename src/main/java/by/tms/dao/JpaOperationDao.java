package by.tms.dao;

import by.tms.entity.Operation;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class JpaOperationDao implements OperationDao<Operation> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Operation operation) {
        entityManager.persist(operation);
    }

    @Override
    public List<Operation> findAllOperationByUsername(String username) {
        TypedQuery<Operation> namedQuery = entityManager.createNamedQuery("Operation.findAllOperationByUsername", Operation.class);
        namedQuery.setParameter("username", username);
        return namedQuery.getResultList();
    }

    @Override
    public void updateNameOfOperations(String name, String username) {
        entityManager.createNamedQuery("Operation.updateNameOfOperations")
                .setParameter("name", name)
                .setParameter("username", username)
                .executeUpdate();
    }

    @Override
    public void deleteOperationsByUserName(String username) {
        entityManager.createNamedQuery("Operation.deleteOperationsByUserName")
                .setParameter("username", username)
                .executeUpdate();
    }
}
