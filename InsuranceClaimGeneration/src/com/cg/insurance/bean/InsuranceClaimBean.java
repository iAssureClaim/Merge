package com.cg.insurance.bean;

public class InsuranceClaimBean {
private int claim_Number;
private String claim_Reason;
private String accident_Location;
private String accident_City;
private String accident_State;
private long accident_Zip;
private String claim_Type;
private int policy_Number;


public int getClaim_Number() {
	return claim_Number;
}
public void setClaim_Number(int claim_Number) {
	this.claim_Number = claim_Number;
}
public String getClaim_Reason() {
	return claim_Reason;
}
public void setClaim_Reason(String claim_Reason) {
	this.claim_Reason = claim_Reason;
}
public String getAccident_Location() {
	return accident_Location;
}
public void setAccident_Location(String accident_Location) {
	this.accident_Location = accident_Location;
}
public String getAccident_City() {
	return accident_City;
}
public void setAccident_City(String accident_City) {
	this.accident_City = accident_City;
}
public String getAccident_State() {
	return accident_State;
}
public void setAccident_State(String accident_State) {
	this.accident_State = accident_State;
}
public long getAccident_Zip() {
	return accident_Zip;
}
public void setAccident_Zip(long accident_Zip) {
	this.accident_Zip = accident_Zip;
}
public String getClaim_Type() {
	return claim_Type;
}
public void setClaim_Type(String claim_Type) {
	this.claim_Type = claim_Type;
}
public int getPolicy_Number() {
	return policy_Number;
}
public void setPolicy_Number(int policy_Number) {
	this.policy_Number = policy_Number;
}
}
