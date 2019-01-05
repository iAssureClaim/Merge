package com.cg.insurance.client;

import java.io.IOException;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;


import com.cg.insurance.bean.InsuranceClaimBean;
import com.cg.insurance.bean.UserBean;
import com.cg.insurance.exception.InsuranceClaimException;
import com.cg.insurance.service.IInsuranceService;
import com.cg.insurance.service.InsuranceServiceImpl;

public class InsuranceMain {
	static Scanner sc=new Scanner(System.in);
	static UserBean userbean=null;
	static InsuranceClaimBean claimBean=null;
	static IInsuranceService iInsuranceService=null;
	static InsuranceServiceImpl insuranceServiceImpl=null;
	
public static void main(String[] args) throws IOException, SQLException, InsuranceClaimException {
	
	userbean = new UserBean();
	String rolecode=null;
	System.out.println("Enter Your Credentials to use your facility: ");
	System.out.println("Enter your Username: ");
	userbean.setUsername(sc.next());
	System.out.println("Enter your Password: ");
	userbean.setPassword(sc.next());
	
	
	iInsuranceService = new InsuranceServiceImpl();
	rolecode=iInsuranceService.checkAccess(userbean);
	int option;
	switch (rolecode.toLowerCase()) {
	case "insured":
		
		while(true)
		{
				System.out.println("\n----------------Welcome User--------------------\n");
				System.out.println("1.Create Claim as per Your Policies.");
				System.out.println("2.View Claim.\n");
				System.out.println("3.Exit.");
				
				try {
					option = sc.nextInt();
					switch (option) {
					case 1:
						
						break;
					case 2:
						
						break;
					case 3:
						System.exit(0);
						break;
					default:
						break;
					}
				}                         
				catch (InputMismatchException e) {
						sc.nextLine();
						System.out.println("Please enter only Numeric Value.");
				}   
		}	
		
	case "agent":
			System.out.println("\n-------------------Welcome Agent----------------\n");
			System.out.println("1.Create Claim for Your Customers.");
			System.out.println("2.View Claim of your Customers.\n");
		break;
	case "admin":
			System.out.println("\n-------------------Welcome Admin----------------\n");
			System.out.println("1.Create Profile.");
			System.out.println("2.Create Claim for any customer.");
			System.out.println("3.View Claim of any customer.");
			System.out.println("4.Generate Report.\n");
		break;
	default:
		break;
	}
	

	
}
}
