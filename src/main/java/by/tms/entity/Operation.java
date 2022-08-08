package by.tms.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Operation {
    private double num1;
    private double num2;
    private String operation;
}
