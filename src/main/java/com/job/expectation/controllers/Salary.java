package com.job.expectation.controllers;


import com.job.expectation.models.BaseResponseModel;
import com.job.expectation.models.ResponseTierDataModel;
import com.job.expectation.models.requests.SalaryExpectationRequestModel;
import com.job.expectation.services.SalaryExpectationService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Validated
@RestController
@RequestMapping("/job")
public class Salary {

    @Autowired
    SalaryExpectationService salaryExpectationService;

    @PostMapping("/salaryExpectation")
    @ApiOperation(value = "Testing request body validation", response = ResponseTierDataModel.class )
    public ResponseEntity<ResponseTierDataModel> getSalaryDetails(@Valid @RequestBody SalaryExpectationRequestModel salaryExpectation) {
        return salaryExpectationService.salaryExpectationDetails(salaryExpectation);
    }


//    @PostMapping("/salaryExpectation")
//    @ApiOperation(value = "Testing request body validation" )
//    public String getAccounts(String salaryExpectation) {
//        return "HELLO WORLD";
//    }

}
