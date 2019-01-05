package com.cg.insurance.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import com.cg.insurance.bean.InsuranceClaimBean;
import com.cg.insurance.bean.UserBean;
import com.cg.insurance.exception.InsuranceClaimException;
import com.cg.insurance.util.DbConnection;

public class InsuranceDaoImpl implements  IInsuranceDAO {
static UserBean userBean=null;
static Connection connection=null;
	@Override
	public int getPolicy_Number(InsuranceClaimBean insuranceClaimBean) throws SQLException {
		insuranceClaimBean=new InsuranceClaimBean();
		
		PreparedStatement statement=null;
		int policy_Number=0;
		
		try {
			 connection = DbConnection.getConnection();
			 statement=connection.prepareStatement(QueryMappers.insertQuery);
			 statement.setLong(1, insuranceClaimBean.getClaim_Number());
			 statement.setString(2, insuranceClaimBean.getClaim_Reason());
			 statement.setString(3, insuranceClaimBean.getAccident_Location());
			 statement.setString(4, insuranceClaimBean.getAccident_City());
			 statement.setString(5, insuranceClaimBean.getAccident_State());
			 statement.setLong(6, insuranceClaimBean.getAccident_Zip());
			 statement.setString(7, insuranceClaimBean.getClaim_Type());
			 statement.setLong(8, insuranceClaimBean.getPolicy_Number());
			 
			 statement.executeUpdate();
			 statement =connection.prepareStatement(QueryMappers.getpolicy_number);
			 ResultSet resultSet = statement.executeQuery();
			 resultSet.next();
			 policy_Number=resultSet.getInt(8);	
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return policy_Number;
	}

	@Override
	public String checkAccess(UserBean userbean) throws IOException, SQLException, InsuranceClaimException {
		
		PreparedStatement statement=null;
		
		String user=null;
		String pass = null;
		String role =null;
		try {
			 connection = DbConnection.getConnection();
			 
			 statement=connection.prepareStatement(QueryMappers.checkAccess);
			 statement.setString(1,userbean.getUsername());
			 //statement.executeUpdate();
			 
			
			 ResultSet resultSet = statement.executeQuery();
			 while(resultSet.next()) {
				 user = resultSet.getString(1);
				 pass = resultSet.getString(2);
				 role = resultSet.getString(3);
			 }
			
			 if(user!=null) {
					if(pass.equals(userbean.getPassword())) {
						return role;
					}
					else {
						throw new InsuranceClaimException("wrong password");
					}
			 }
			 else {
				 	throw new InsuranceClaimException("NO such User Exists!!");
				 
				}
			 
			
		} catch (NullPointerException e) {
			
			throw new InsuranceClaimException("There are no records of User");
		}
		finally
		{
				try 
				{
					statement=null;
					userbean=null;
					connection.close();
				}
				catch (SQLException sqlException) 
				{
					
					throw new InsuranceClaimException("Error in closing db connection");

				}
		}	
	}

}
