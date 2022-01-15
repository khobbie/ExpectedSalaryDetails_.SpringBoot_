package com.job.expectation.models;

public class SalaryDetails {

    private Double PAYE = 0.00; // Pay As You Earn
    private Double EPC = 0.00;  // Employee Pension Contribution
    private Double EP = 0.00;   // Employer Pension
    private Double NetSalary = 0.00; // Net Salary
    private Double GrossSalary = 0.00; // Gross Salary

    public SalaryDetails() {
    }

    public SalaryDetails(Double PAYE, Double EPC, Double EP, Double netSalary, Double grossSalary) {
        this.PAYE = PAYE;
        this.EPC = EPC;
        this.EP = EP;
        NetSalary = netSalary;
        GrossSalary = grossSalary;
    }

    public Double getPAYE() {
        return PAYE;
    }

    public void setPAYE(Double PAYE) {
        this.PAYE = PAYE;
    }

    public Double getEPC() {
        return EPC;
    }

    public void setEPC(Double EPC) {
        this.EPC = EPC;
    }

    public Double getEP() {
        return EP;
    }

    public void setEP(Double EP) {
        this.EP = EP;
    }

    public Double getNetSalary() {
        return NetSalary;
    }

    public void setNetSalary(Double netSalary) {
        NetSalary = netSalary;
    }

    public Double getGrossSalary() {
        return GrossSalary;
    }

    public void setGrossSalary(Double grossSalary) {
        GrossSalary = grossSalary;
    }

    @Override
    public String toString() {
        return "SalaryDetails{" +
                "PAYE=" + PAYE +
                ", EPC=" + EPC +
                ", EP=" + EP +
                ", NetSalary=" + NetSalary +
                ", GrossSalary=" + GrossSalary +
                '}';
    }

    /*
        Custom Functions
     */

    // ** Employee Pension ** //
    public Double getEmployeePension(Double BasicSalaryAmount, Double EmployeePensionRate)
    {
        return EmployeePensionRate * BasicSalaryAmount;
    }

    // ** Employer Pension ** //
    public Double getEmployerPension(Double BasicSalaryAmount, Double EmployerPensionRate)
    {
        return EmployerPensionRate * BasicSalaryAmount;
    }


    // ** Tax Rate ** //
    public Double getTaxRateFromTaxableIncome(Double TaxableIncome)
    {


        Double taxRate = 0.00;

        if (TaxableIncome <= 280) {
            taxRate = 0.00;
        } else if (TaxableIncome > 280 && TaxableIncome <= 388) {
            taxRate = 0.05;
        } else if (TaxableIncome > 388 && TaxableIncome <= 528) {
            taxRate = 0.10;
        } else if (TaxableIncome > 528 && TaxableIncome <= 3528) {
            taxRate = 0.175;
        } else {
            taxRate = 0.25;
        }

        return taxRate;
    }


    // ** New Basic Salary after Employee Pension is deducted ** //
    public Double getNewBasicSalary(Double BasicSalaryAmount, Double TotalEmployeePensionAmount)
    {
        return BasicSalaryAmount - TotalEmployeePensionAmount;
    }


    // ** Gross Salary  ** //
    public Double getGrossSalary(Double BasicSalary, Double TotalAllowanceAmount,
                                 Double TotalEmployerPensionAmount, Double TotalTaxReliefAmount )
    {
        return BasicSalary + TotalAllowanceAmount + TotalEmployerPensionAmount + TotalTaxReliefAmount;
    }

    // ** Tax Amount  ** //
    public Double getTaxAmount(Double TaxRate, Double TaxableIncome)
    {
        return TaxRate * TaxableIncome;
    }

    // ** Net Salary  ** //
    public Double getNetSalaryAmount( Double TaxAmount, Double TaxableIncome)
    {
        return TaxableIncome - TaxAmount;
    }




}
