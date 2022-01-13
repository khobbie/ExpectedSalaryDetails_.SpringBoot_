package com.job.expectation.models;

public class Tier {
    private Double GrossSalary = 0.00;
    private Double BasicSalary = 0.00;
    private Double Allowance = 0.00;

    private Double EmployeePensionAmount = 0.00;
    private Double EmployeePensionRate = 0.00;

    private Double EmployerPensionAmount = 0.00;
    private Double EmployerPensionRate = 0.13;

    private Double TaxRate = 0.00;
    private Double TotalPAYETax = 0.00;

    public Tier() {
    }

    public Tier(Double grossSalary, Double basicSalary, Double allowance, Double employeePensionAmount, Double employeePensionRate, Double employerPensionAmount, Double employerPensionRate, Double taxRate, Double totalPAYETax) {
        GrossSalary = grossSalary;
        BasicSalary = basicSalary;
        Allowance = allowance;
        EmployeePensionAmount = employeePensionAmount;
        EmployeePensionRate = employeePensionRate;
        EmployerPensionAmount = employerPensionAmount;
        EmployerPensionRate = employerPensionRate;
        TaxRate = taxRate;
        TotalPAYETax = totalPAYETax;
    }

    public Double getGrossSalary() {
        return GrossSalary;
    }

    public void setGrossSalary(Double grossSalary) {
        GrossSalary = grossSalary;
    }

    public Double getBasicSalary() {
        return BasicSalary;
    }

    public void setBasicSalary(Double basicSalary) {
        BasicSalary = basicSalary;
    }

    public Double getAllowance() {
        return Allowance;
    }

    public void setAllowance(Double allowance) {
        Allowance = allowance;
    }

    public Double getEmployeePensionAmount() {
        return EmployeePensionAmount;
    }

    public void setEmployeePensionAmount(Double employeePensionAmount) {
        EmployeePensionAmount = employeePensionAmount;
    }

    public Double getEmployeePensionRate() {
        return EmployeePensionRate;
    }

    public void setEmployeePensionRate(Double employeePensionRate) {
        EmployeePensionRate = employeePensionRate;
    }

    public Double getEmployerPensionAmount() {
        return EmployerPensionAmount;
    }

    public void setEmployerPensionAmount(Double employerPensionAmount) {
        EmployerPensionAmount = employerPensionAmount;
    }

    public Double getEmployerPensionRate() {
        return EmployerPensionRate;
    }

    public void setEmployerPensionRate(Double employerPensionRate) {
        EmployerPensionRate = employerPensionRate;
    }

    public Double getTaxRate() {
        return TaxRate;
    }

    public void setTaxRate(Double taxRate) {
        TaxRate = taxRate;
    }

    public Double getTotalPAYETax() {
        return TotalPAYETax;
    }

    public void setTotalPAYETax(Double totalPAYETax) {
        TotalPAYETax = totalPAYETax;
    }

    /*
    CUSTOM FUNCTIONS
     */


    public Double getTaxRateFromNetSalary(Double NetSalary)
    {
        Double taxRate = 0.00;

        if (NetSalary <= 280) {
            taxRate = 0.00;
        } else if (NetSalary > 280 && NetSalary <= 388) {
            taxRate = 0.5;
        } else if (NetSalary > 388 && NetSalary <= 528) {
            taxRate = 0.10;
        } else if (NetSalary > 528 && NetSalary <= 3528) {
            taxRate = 0.175;
        } else {
            taxRate = 0.25;
        }
        this.setTaxRate(taxRate);
        return taxRate;
    }



    public Double getBasicSalaryAmount (Double NetSalary, Double TotalAllowance)
    {
        Double taxRate = getTaxRateFromNetSalary(NetSalary);

        Double basicSalary =
                ( (NetSalary - ( (taxRate * TotalAllowance) + TotalAllowance ) ) / ( 1 + EmployeePensionRate - taxRate));

        this.setBasicSalary(basicSalary);
        return basicSalary;
    }

    public Double getGrossSalaryAmount(Double BasicSalaryAmount, Double TotalAllowance)
    {
        Double grossSalaryAmount = BasicSalaryAmount + TotalAllowance;

        this.setGrossSalary(grossSalaryAmount);

        return grossSalaryAmount;
    }

    public Double getEmployeePensionContribution(Double BasicSalaryAmount)
    {
        Double EmployeePensionContributionAmount = (EmployeePensionRate * BasicSalaryAmount);

        this.setEmployeePensionAmount(EmployeePensionContributionAmount);

        return EmployeePensionContributionAmount;
    }

    public Double getEmployerPensionContribution(Double BasicSalaryAmount)
    {
        Double EmployerPensionContributionAmount = (EmployerPensionRate * BasicSalaryAmount);

        this.setEmployerPensionAmount(EmployerPensionContributionAmount);

        return EmployerPensionContributionAmount;
    }

    public Double getTotalPAYETax(Double BasicSalaryAmount, Double TotalAllowance)
    {
        Double grossSalaryAmount = getGrossSalaryAmount(BasicSalaryAmount, TotalAllowance);

        Double EmployerPensionContributionAmount = getEmployeePensionContribution(BasicSalaryAmount);

        Double TaxableIncomeAmount = grossSalaryAmount - EmployerPensionContributionAmount;

        Double TaxableRate = getTaxRateFromNetSalary(BasicSalaryAmount + TotalAllowance);

        Double TotalPAYETax = (TaxableRate * TaxableIncomeAmount);

        this.setTotalPAYETax(TotalPAYETax);

        return TotalPAYETax;
    }

       /*
        END CUSTOM FUNCTIONS
      */


    @Override
    public String toString() {
        return "Tier1{" +
                "GrossSalary=" + GrossSalary +
                ", BasicSalary=" + BasicSalary +
                ", Allowance=" + Allowance +
                ", EmployeePensionAmount=" + EmployeePensionAmount +
                ", EmployeePensionRate=" + EmployeePensionRate +
                ", EmployerPensionAmount=" + EmployerPensionAmount +
                ", EmployerPensionRate=" + EmployerPensionRate +
                ", TaxRate=" + TaxRate +
                ", TotalPAYETax=" + TotalPAYETax +
                '}';
    }
}
