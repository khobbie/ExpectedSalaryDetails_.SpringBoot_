package com.job.expectation.services;

import com.job.expectation.models.*;
import com.job.expectation.models.requests.SalaryExpectationRequestModel;
import com.job.expectation.repositories.SalaryExpectationRepository;

import com.sun.jdi.DoubleValue;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import javax.validation.Valid;


@Repository
public class SalaryExpectationService implements SalaryExpectationRepository {
    public ResponseEntity<SalaryDetails> salaryExpectationDetails(@Valid SalaryExpectationRequestModel salaryExpectationRequestModel) {

        Double basicSalary = salaryExpectationRequestModel.getBasicSalary();
        System.out.println("basicSalary: " + basicSalary);

        Double totalAllowance = salaryExpectationRequestModel.getTotalAllowance();
        System.out.println("totalAllowance: " + totalAllowance);

        SalaryDetails salaryDetails = new SalaryDetails();

        Double totalEmployeePensionContribution = this.getTotalEmployeePensionContributionForTier123(basicSalary, 0.00,
                0.055, 0.05);
        System.out.println("totalEmployeePensionContribution: " + totalEmployeePensionContribution);

        Double totalEmployerPension = this.getTotalEmployeePensionContributionForTier123(basicSalary, 0.13,
                0.00, 0.05);
        System.out.println("totalEmployerPension: " + totalEmployerPension);


        Double totalGrossSalary = salaryDetails.getGrossSalary(basicSalary, totalAllowance, totalEmployerPension, 0.00);
        System.out.println("totalGrossSalary: " + totalGrossSalary);

        Double newBasicSalary = salaryDetails.getNewBasicSalary(basicSalary, totalEmployeePensionContribution);
        System.out.println("newBasicSalary: " + newBasicSalary);

        Double TaxableIncome = newBasicSalary + totalAllowance;
        System.out.println("TaxableIncome: " + TaxableIncome);

        Double taxRate = salaryDetails.getTaxRateFromTaxableIncome(TaxableIncome);
        System.out.println("taxRate: " + taxRate);

        Double taxAmount = salaryDetails.getTaxAmount(taxRate, TaxableIncome);
        System.out.println("taxAmount: " + taxAmount);

        Double netSalary = salaryDetails.getNetSalaryAmount(taxAmount, TaxableIncome);
        System.out.println("netSalary: " + netSalary);

        // Setting response values

        salaryDetails.setPAYE(taxAmount);
        salaryDetails.setEPC(totalEmployeePensionContribution);
        salaryDetails.setEP(totalEmployerPension);
        salaryDetails.setNetSalary(netSalary);
        salaryDetails.setGrossSalary(totalGrossSalary);


        return new ResponseEntity<>(salaryDetails, HttpStatus.OK );
    }

    protected Double getTotalEmployeePensionContributionForTier123(Double basicSalary, Double tierOnePensionRate,
                                                                Double tierTwoPensionRate, Double tierThreePensionRate)
    {
        SalaryDetails salaryDetails = new SalaryDetails();


        Double tierOnePensionAmount = salaryDetails.getEmployeePension(basicSalary, tierOnePensionRate);

        Double tierTwoPensionAmount = salaryDetails.getEmployeePension(basicSalary, tierTwoPensionRate);

        Double tierThreePensionAmount = salaryDetails.getEmployeePension(basicSalary, tierThreePensionRate);

        return tierOnePensionAmount + tierTwoPensionAmount + tierThreePensionAmount;

    }


    protected Double getTotalEmployerPensionContributionForTier123(Double basicSalary, Double tierOnePensionRate,
                                                                   Double tierTwoPensionRate, Double tierThreePensionRate)
    {
        SalaryDetails salaryDetails = new SalaryDetails();


        Double tierOnePensionAmount = salaryDetails.getEmployerPension(basicSalary, tierOnePensionRate);

        Double tierTwoPensionAmount = salaryDetails.getEmployerPension(basicSalary, tierTwoPensionRate);

        Double tierThreePensionAmount = salaryDetails.getEmployerPension(basicSalary, tierThreePensionRate);

        return tierOnePensionAmount + tierTwoPensionAmount + tierThreePensionAmount;

    }

}

