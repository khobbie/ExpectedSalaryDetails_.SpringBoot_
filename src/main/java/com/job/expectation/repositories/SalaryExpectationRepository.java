package com.job.expectation.repositories;

import com.job.expectation.models.SalaryDetails;
import com.job.expectation.models.requests.SalaryExpectationRequestModel;
import org.springframework.http.ResponseEntity;

public interface SalaryExpectationRepository {

    public ResponseEntity<SalaryDetails> salaryExpectationDetails(SalaryExpectationRequestModel salaryExpectationRequestModel);
}
