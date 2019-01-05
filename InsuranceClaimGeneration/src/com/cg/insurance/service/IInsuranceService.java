package com.cg.insurance.service;

import java.io.IOException;
import java.sql.SQLException;

import com.cg.insurance.bean.InsuranceClaimBean;
import com.cg.insurance.bean.UserBean;
import com.cg.insurance.exception.InsuranceClaimException;

public interface IInsuranceService {

	boolean validateDetails(InsuranceClaimBean claimBean) throws InsuranceClaimException;

	String checkAccess(UserBean userbean) throws IOException, SQLException, InsuranceClaimException;

	


}
