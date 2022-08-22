package by.tms.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "hibernateOperations")
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private double num1;
    @NotNull
    private double num2;
    @NotBlank
    @NotEmpty
    private String operation;
    private double result;

    private String username;

    private String name;

    @Override
    public String toString() {
        return operation + "(" + num1 + "; " + num2 + ")" + " = " + result;
    }
}
