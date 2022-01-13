package com.job.expectation.services;

import com.job.expectation.models.*;
import com.job.expectation.models.requests.SalaryExpectationRequestModel;
import com.job.expectation.repositories.SalaryExpectationRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import javax.validation.Valid;


@Repository
public class SalaryExpectationService implements SalaryExpectationRepository {
    public ResponseEntity<ResponseTierDataModel> salaryExpectationDetails(@Valid SalaryExpectationRequestModel salaryExpectationRequestModel) {

        Double salary = salaryExpectationRequestModel.getNetSalaryAmount();
        Double allowance = salaryExpectationRequestModel.getTotalAllowanceAmount();

        BaseResponseModel baseResponseModel = new BaseResponseModel();
        ResponseDataModel responseDataModel = new ResponseDataModel();

        ResponseTierDataModel responseTierDataModel = new ResponseTierDataModel();


        // Testing Tier 1
        Tier tier1 = new Tier();
        tier1.setEmployeePensionRate(0.00);
        tier1.setEmployerPensionRate(0.13);
        tier1.setAllowance(allowance);
        Double basicSalary_1 = tier1.getBasicSalaryAmount(salary, allowance);
        tier1.getGrossSalaryAmount(salary, allowance);
        tier1.getEmployeePensionContribution(basicSalary_1);
        tier1.getEmployerPensionContribution(basicSalary_1);
        tier1.getTotalPAYETax(basicSalary_1,allowance);


        // Testing Tier 2
        Tier tier2 = new Tier();
        tier2.setEmployeePensionRate(0.055);
        tier2.setEmployerPensionRate(0.00);
        tier2.setAllowance(allowance);
        Double basicSalary_2 = tier1.getBasicSalaryAmount(salary, allowance);
        tier2.getGrossSalaryAmount(salary, allowance);
        tier2.getEmployeePensionContribution(basicSalary_2);
        tier2.getEmployerPensionContribution(basicSalary_2);
        tier2.getTotalPAYETax(basicSalary_2,allowance);



        // Testing Tier 3
        Tier tier3 = new Tier();
        tier3.setEmployeePensionRate(0.05);
        tier3.setEmployerPensionRate(0.05);
        tier3.setAllowance(allowance);
        Double basicSalary_3 = tier3.getBasicSalaryAmount(salary, allowance);
        tier3.getGrossSalaryAmount(salary, allowance);
        tier3.getEmployeePensionContribution(basicSalary_3);
        tier3.getEmployerPensionContribution(basicSalary_3);
        tier3.getTotalPAYETax(basicSalary_3,allowance);

        responseTierDataModel.setTier1(tier1);
        responseTierDataModel.setTier2(tier2);
        responseTierDataModel.setTier3(tier3);

        return new ResponseEntity<>(responseTierDataModel, HttpStatus.OK   );
    }
}



/*

  // Tier 1
        TierOne tierOne = new TierOne();
        tierOne.setBasicSalary(salary);
        tierOne.setAllowance(allowance);
        tierOne.setGrossSalary(tierOne.getGrossSalaryAmount(salary + allowance));

        // Tier
        TierTwo tierTwo = new TierTwo();
        tierTwo.setBasicSalary(salary);
        tierTwo.setAllowance(allowance);
        tierTwo.setGrossSalary(tierTwo.getGrossSalaryAmount(salary + allowance));

        TierThree tierThree = new TierThree(); // Tier 3
        tierThree.setBasicSalary(salary);
        tierThree.setAllowance(allowance);
        tierThree.setGrossSalary(tierThree.getGrossSalaryAmount(salary + allowance));



//        tierTwoModel.setGrossSalary(tierTwoModel.getGrossSalaryAmount(salary + allowance));
//        tierThreeModel.setGrossSalary(tierThreeModel.getGrossSalaryAmount(salary + allowance));

        responseDataModel.setTier(tier);
        responseDataModel.setTierOne(tierOne);
        responseDataModel.setTierTwo(tierTwo);
        responseDataModel.setTierThree(tierThree);

        baseResponseModel.setData(responseDataModel);
 */

