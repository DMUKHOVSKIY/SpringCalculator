package by.tms.dao;

import by.tms.entity.User;

import java.util.List;

public interface OperationDao<T> {
    void save(T operation);
    List<T> findAllOperationByUsername(String username);

    void updateNameOfOperations(String name, String username);
    void deleteOperationsByUserName(String username);
}
