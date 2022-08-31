package by.tms.entity;

import jdk.jfr.Name;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "hibernateOperations")
@NamedQueries({
        @NamedQuery(name = "Operation.findAllOperationByUsername", query = "select o from Operation o where o.username = :username"),
        @NamedQuery(name = "Operation.updateNameOfOperations", query = "update Operation o set o.name = :name where o.username = :username"),
        @NamedQuery(name = "Operation.deleteOperationsByUserName", query = "delete Operation o where o.username = :username")
})
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
