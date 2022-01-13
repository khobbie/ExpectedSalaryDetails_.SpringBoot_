package com.job.expectation.models.requests;

public class SalaryExpectationRequestModel {
    private Double NetSalaryAmount;
    private Double TotalAllowanceAmount;

    public SalaryExpectationRequestModel() {
    }

    public SalaryExpectationRequestModel(Double netSalaryAmount, Double totalAllowanceAmount) {
        NetSalaryAmount = netSalaryAmount;
        TotalAllowanceAmount = totalAllowanceAmount;
    }

    public Double getNetSalaryAmount() {
        return NetSalaryAmount;
    }

    public void setNetSalaryAmount(Double netSalaryAmount) {
        NetSalaryAmount = netSalaryAmount;
    }

    public Double getTotalAllowanceAmount() {
        return TotalAllowanceAmount;
    }

    public void setTotalAllowanceAmount(Double totalAllowanceAmount) {
        TotalAllowanceAmount = totalAllowanceAmount;
    }

    @Override
    public String toString() {
        return "SalaryExpectationRequestModel{" +
                "NetSalaryAmount=" + NetSalaryAmount +
                ", TotalAllowanceAmount=" + TotalAllowanceAmount +
                '}';
    }
}
