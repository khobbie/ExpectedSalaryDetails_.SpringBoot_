package com.job.expectation.repositories;


import com.job.expectation.models.BaseResponseModel;
import com.job.expectation.models.ResponseTierDataModel;
import com.job.expectation.models.requests.SalaryExpectationRequestModel;
import org.springframework.http.ResponseEntity;

public interface SalaryExpectationRepository {

    public ResponseEntity<ResponseTierDataModel> salaryExpectationDetails(SalaryExpectationRequestModel salaryExpectationRequestModel);
}
