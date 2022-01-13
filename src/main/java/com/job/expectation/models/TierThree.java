package com.job.expectation.models;

public class TierThree {

    private Double GrossSalary = 0.00;
    private Double BasicSalary = 0.00;
    private Double Allowance = 0.00;
    private Double TotalPayeTax = 0.00;

    private Double EmployeePensionAmount = 0.00;
    private Double EmployerPensionAmount = 0.00;

    private Double EmployeePensionRate = 0.50;
    private Double EmployerPensionRate = 0.50;

    private Double TaxRate = 0.175;



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

    public TierThree() {
    }

    public TierThree(Double grossSalary, Double basicSalary, Double allowance, Double totalPayeTax,
                     Double employeePensionAmount, Double employerPensionAmount) {
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
        return "TierThree{" +
                "GrossSalary=" + GrossSalary +
                ", BasicSalary=" + BasicSalary +
                ", Allowance=" + Allowance +
                ", TotalPayeTax=" + TotalPayeTax +
                ", EmployeePensionAmount=" + EmployeePensionAmount +
                ", EmployerPensionAmount=" + EmployerPensionAmount +
                '}';
    }
}
