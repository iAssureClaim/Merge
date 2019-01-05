package com.cg.insurance.dao;

public interface QueryMappers {
	public static final String insertQuery="insert into claim(?,?,?,?,?,?,?,?)";
	public static final String getpolicy_number="select  POLICY_NUMBER from claim;";
	public static final String checkAccess="select * from user_role where user_name=?";
}
