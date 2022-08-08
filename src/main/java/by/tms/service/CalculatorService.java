package by.tms.service;

import by.tms.entity.Operation;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public double calculate(Operation operation) {
        switch (operation.getOperation()) {
            case "sum": {
                return operation.getNum1() + operation.getNum2();
            }
            case "diff": {
                return operation.getNum1() - operation.getNum2();
            }
            case "mul": {
                return operation.getNum1() * operation.getNum2();
            }
            case "div": {
                return operation.getNum1() / operation.getNum2();
            }
        }
        return 0;
    }
}
