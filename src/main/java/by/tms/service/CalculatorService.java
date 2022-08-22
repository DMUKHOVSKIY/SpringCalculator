package by.tms.service;

import by.tms.entity.Operation;
import by.tms.entity.User;

import java.util.List;
import java.util.Optional;

public interface CalculatorService {
    Optional<Operation> calculate(Operation operation, User user);

    List<Operation> findAllOperationByUsername(String username);
}

