package com.job.expectation.models;

public class TierOne {
    private Double GrossSalary = 0.00;
    private Double BasicSalary = 0.00;
    private Double Allowance = 0.00;
    private Double TotalPayeTax = 0.00;

    private Double EmployeePensionAmount = 0.00;
    private Double EmployerPensionAmount = 0.00;

    private Double EmployeePensionRate = 0.00;
    private Double EmployerPensionRate = 0.13;

    private Double TaxRate = 0.175;

    /*


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
        return taxRate;
    }



    public Double getBasicSalaryAmount (Double NetSalary, Double TotalAllowance)
    {
        Double taxRate = getTaxRateFromNetSalary(NetSalary);

        Double basicSalary =
                ( (NetSalary - ( (taxRate * TotalAllowance) + TotalAllowance ) ) / ( 1 + EmployeePensionRate - taxRate));

        return basicSalary;
    }

    public Double getGrossSalaryAmount(Double BasicSalaryAmount, Double TotalAllowance)
    {
        Double grossSalaryAmount = BasicSalaryAmount + TotalAllowance;
        return grossSalaryAmount;
    }

    public Double getEmployeePensionContribution(Double BasicSalaryAmount)
    {
        Double EmployeePensionContributionAmount = (EmployeePensionRate * BasicSalaryAmount);
        return EmployeePensionContributionAmount;
    }

    public Double getEmployerPensionContribution(Double BasicSalaryAmount)
    {
        Double EmployerPensionContributionAmount = (EmployerPensionRate * BasicSalaryAmount);
        return EmployerPensionContributionAmount;
    }

    public Double getTotalPAYETax(Double BasicSalaryAmount, Double TotalAllowance)
    {
        Double grossSalaryAmount = getGrossSalaryAmount(BasicSalaryAmount, TotalAllowance);
        Double EmployerPensionContributionAmount = getEmployeePensionContribution(BasicSalaryAmount);
        Double TaxableIncomeAmount = grossSalaryAmount - EmployerPensionContributionAmount;

        Double TaxableRate = getTaxRateFromNetSalary(BasicSalaryAmount + TotalAllowance);

        Double TotalPAYETax = (TaxableRate * TaxableIncomeAmount);
        return TotalPAYETax;
    }


    public Double getEmployeePensionAmount(Double BasicSalaryAndAllowance)
    {
        EmployeePensionAmount = EmployeePensionRate * BasicSalaryAndAllowance;

        this.setEmployeePensionRate(EmployeePensionRate);
        this.setEmployeePensionAmount(EmployeePensionAmount);

        return EmployeePensionAmount;
    }

    public Double getEmployerPensionAmount(Double BasicSalaryAndAllowance)
    {
        EmployerPensionAmount = EmployerPensionRate * BasicSalaryAndAllowance;

        this.setEmployerPensionRate(EmployerPensionRate);
        this.setEmployerPensionAmount(EmployerPensionAmount);

        return EmployerPensionAmount;
    }

    public Double getPayeTaxAmount(Double RemainingAmountAfterEmployeePensionDeduction)
    {
        Double taxableAmount = RemainingAmountAfterEmployeePensionDeduction;

        TotalPayeTax = TaxRate * RemainingAmountAfterEmployeePensionDeduction;

        this.setTaxRate(TaxRate);
        this.setTotalPayeTax(TotalPayeTax);

        return TotalPayeTax;

    }

    public Double getGrossSalaryAmount(Double BasicSalaryAndAllowance)
    {
        Double employeePensionAmount = getEmployeePensionAmount(BasicSalaryAndAllowance);
        Double employerPensionAmount = getEmployerPensionAmount(BasicSalaryAndAllowance);
        Double taxableIncomeAmount = getPayeTaxAmount(BasicSalaryAndAllowance - employeePensionAmount);

        GrossSalary = BasicSalaryAndAllowance + employeePensionAmount + employerPensionAmount + taxableIncomeAmount;
//        this.setGrossSalary(GrossSalary);
        this.setEmployeePensionAmount(employeePensionAmount);
        this.setEmployerPensionAmount(employerPensionAmount);
        this.setTotalPayeTax(taxableIncomeAmount);
        return GrossSalary;
    }

    public TierOne() {
    }

    public TierOne(Double grossSalary, Double basicSalary, Double allowance, Double totalPayeTax, Double employeePensionAmount, Double employerPensionAmount) {
        GrossSalary = grossSalary;
        BasicSalary = basicSalary;
        Allowance = allowance;
        TotalPayeTax = totalPayeTax;
        EmployeePensionAmount = employeePensionAmount;
        EmployerPensionAmount = employerPensionAmount;
    }
//
//    public TierOneModel(Double grossSalary, Double basicSalary, Double allowance, Double totalPayeTax, Double employeePensionAmount, Double employerPensionAmount, Double employeePensionRate, Double employerPensionRate, Double taxRate) {
//        GrossSalary = grossSalary;
//        BasicSalary = basicSalary;
//        Allowance = allowance;
//        TotalPayeTax = totalPayeTax;
//        EmployeePensionAmount = employeePensionAmount;
//        EmployerPensionAmount = employerPensionAmount;
//        EmployeePensionRate = employeePensionRate;
//        EmployerPensionRate = employerPensionRate;
//        TaxRate = taxRate;
//    }


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

    public Double getTotalPayeTax() {
        return TotalPayeTax;
    }

    public void setTotalPayeTax(Double totalPayeTax) {
        TotalPayeTax = totalPayeTax;
    }

    public Double getEmployeePensionAmount() {
        return EmployeePensionAmount;
    }

    public void setEmployeePensionAmount(Double employeePensionAmount) {
        EmployeePensionAmount = employeePensionAmount;
    }

    public Double getEmployerPensionAmount() {
        return EmployerPensionAmount;
    }

    public void setEmployerPensionAmount(Double employerPensionAmount) {
        EmployerPensionAmount = employerPensionAmount;
    }

    public Double getEmployeePensionRate() {
        return EmployeePensionRate;
    }

    public void setEmployeePensionRate(Double employeePensionRate) {
        EmployeePensionRate = employeePensionRate;
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

    @Override
    public String toString() {
        return "TierOne{" +
                "GrossSalary=" + GrossSalary +
                ", BasicSalary=" + BasicSalary +
                ", Allowance=" + Allowance +
                ", TotalPayeTax=" + TotalPayeTax +
                ", EmployeePensionAmount=" + EmployeePensionAmount +
                ", EmployerPensionAmount=" + EmployerPensionAmount +
                '}';
    }
}
