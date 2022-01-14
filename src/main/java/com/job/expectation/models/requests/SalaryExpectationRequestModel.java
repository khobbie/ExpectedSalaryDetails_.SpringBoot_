package com.job.expectation.models.requests;

public class SalaryExpectationRequestModel {
    private Double BasicSalary;
    private Double TotalAllowance;

    public SalaryExpectationRequestModel() {
    }

    public SalaryExpectationRequestModel(Double basicSalary, Double totalAllowance) {
        BasicSalary = basicSalary;
        TotalAllowance = totalAllowance;
    }

    public Double getBasicSalary() {
        return BasicSalary;
    }

    public void setBasicSalary(Double basicSalary) {
        BasicSalary = basicSalary;
    }

    public Double getTotalAllowance() {
        return TotalAllowance;
    }

    public void setTotalAllowance(Double totalAllowance) {
        TotalAllowance = totalAllowance;
    }

    @Override
    public String toString() {
        return "SalaryExpectationRequestModel{" +
                "BasicSalary=" + BasicSalary +
                ", TotalAllowance=" + TotalAllowance +
                '}';
    }
}
