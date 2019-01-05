package com.cg.insurance.dao;

import java.io.IOException;
import java.sql.SQLException;

import com.cg.insurance.bean.InsuranceClaimBean;
import com.cg.insurance.bean.UserBean;
import com.cg.insurance.exception.InsuranceClaimException;

public interface IInsuranceDAO {
	int getPolicy_Number(InsuranceClaimBean insuranceClaimBean) throws SQLException;

	String checkAccess(UserBean userbean) throws IOException, SQLException, InsuranceClaimException;
}
