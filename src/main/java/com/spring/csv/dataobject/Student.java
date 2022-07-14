package com.spring.csv.dataobject;


import java.math.BigDecimal;

public class Student {

    private String name;
    private BigDecimal  rollNumber;
    private String department;
    private String result;
    private BigDecimal pointer;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(BigDecimal rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public BigDecimal getPointer() {
        return pointer;
    }

    public void setPointer(BigDecimal pointer) {
        this.pointer = pointer;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rollNumber=" + rollNumber +
                ", department='" + department + '\'' +
                ", result='" + result + '\'' +
                ", pointer=" + pointer +
                '}';
    }
}
