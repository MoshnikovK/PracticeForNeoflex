package ru.neoflex.practice.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "calcResult")
public class CalcResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "operation")
    private String operation;

    @Column(name = "firstValue")
    private int firstValue;

    @Column(name="lastValue")
    private int lastValue;

    @Column(name="result")
    private int result;

    public CalcResult () {

    }

    public CalcResult(String operation, int firstValue, int lastValue, int result) {
        this.operation = operation;
        this.firstValue = firstValue;
        this.lastValue = lastValue;
        this.result = result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public int getFirstValue() {
        return firstValue;
    }

    public void setFirstValue(int firstValue) {
        this.firstValue = firstValue;
    }

    public int getLastValue() {
        return lastValue;
    }

    public void setLastValue(int lastValue) {
        this.lastValue = lastValue;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
    @Override
    public String toString() {
        return "Calc Result [id=" + id + " operation=" + operation + ", firstValue=" +
                firstValue + ", lastValue" + lastValue + ", result=" + result +"]";
    }
}
