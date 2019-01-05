package com.cg.insurance.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import com.cg.insurance.bean.InsuranceClaimBean;
import com.cg.insurance.bean.UserBean;
import com.cg.insurance.dao.IInsuranceDAO;
import com.cg.insurance.dao.InsuranceDaoImpl;
import com.cg.insurance.exception.InsuranceClaimException;

public class InsuranceServiceImpl implements IInsuranceService {
	static IInsuranceDAO iInsuranceDAO=null;

	@Override
	public boolean validateDetails(InsuranceClaimBean claimBean) throws InsuranceClaimException {
		List<String> list = new ArrayList<>();
		boolean result = false;

		if (!isNumberValid(claimBean.getClaim_Number())) {
			list.add("Claim Number should be greater that 0");
		}
		if (!isReasonValid(claimBean.getClaim_Reason())) {
			list.add("claim reason should be valid");
		}
		if (!isAccidentLocationValid(claimBean.getAccident_Location())) {
			list.add("Location should be valid without numerics");
		}
		if (!isAccidentCityValid(claimBean.getAccident_City())) {
			list.add("city should be valid without numerics");
		}
		if (!isAccidentStateValid(claimBean.getAccident_State())) {
			list.add("state should be valid without numerics");
		}
		if (!isAccidentZipValid(claimBean.getAccident_Zip())) {
			list.add("Enter valid AIP Code");
		}
		if (!isClaimTypeValid(claimBean.getClaim_Type())) {
			list.add("enter valid type");
		}
		if (!isPolicyNumberValid(claimBean.getPolicy_Number())) {
			list.add("policy number should be greater than 0");
		}
		if (!list.isEmpty()) {
			result = false;
			throw new InsuranceClaimException(list + "");
		} else {
			result = true;
		}

		return result;
	}

	private boolean isPolicyNumberValid(int policy_Number) {
		
		return policy_Number>0;
	}

	private boolean isClaimTypeValid(String claim_Type) {
		String nameRegEx = "[A-Za-z]{3,}";
		Pattern pattern = Pattern.compile(nameRegEx);
		Matcher matcher = pattern.matcher(claim_Type);
		return matcher.matches();
	}

	private boolean isAccidentZipValid(long accident_Zip) {

		return accident_Zip>0;
	}

	private boolean isAccidentStateValid(String accident_State) {
		String nameRegEx = "[A-Za-z]{4,}";
		Pattern pattern = Pattern.compile(nameRegEx);
		Matcher matcher = pattern.matcher(accident_State);
		return matcher.matches();	
		}

	private boolean isAccidentCityValid(String accident_City) {
		String nameRegEx = "[A-Z,a-z] {3,}";
		Pattern pattern = Pattern.compile(nameRegEx);
		Matcher matcher = pattern.matcher(accident_City);
		return matcher.matches();
	}

	private boolean isAccidentLocationValid(String accident_Location) {
		String nameRegEx = "[A-Za-z] {3,}";
		Pattern pattern = Pattern.compile(nameRegEx);
		Matcher matcher = pattern.matcher(accident_Location);
		return matcher.matches();
	}

	private boolean isReasonValid(String claim_Reason) {
		String nameRegEx = "[A-Za-z] {3,}";
		Pattern pattern = Pattern.compile(nameRegEx);
		Matcher matcher = pattern.matcher(claim_Reason);
		return matcher.matches();
	}

	private boolean isNumberValid(int claim_Number) {
		
		return claim_Number>0;
	}

	/*public void validateUser(UserBean userbean) {

		List<String> validationErrors = new ArrayList<String>();

		
		if(!(isValidName(userbean.getUsername()))) {
			validationErrors.add("\n User Name Should Be In Alphabets and maximum 20 characters long ! \n");
		}
		if(!(isValidPassword(userbean.getPassword()))) {
			validationErrors.add("\n User Name Should Be In Alphabets and maximum 20 characters long ! \n");
		}
		if(!validationErrors.isEmpty())
			throw new InsuranceClaimException(validationErrors +"");
	}*/

	@Override
	public String checkAccess(UserBean userbean) throws IOException, SQLException, InsuranceClaimException {
		String rolecode;
		iInsuranceDAO = new InsuranceDaoImpl();
		rolecode=iInsuranceDAO.checkAccess(userbean);
		return rolecode;
	}


}
