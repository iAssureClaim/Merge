package com.cg.insurance.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnection {
	static Connection connection =null;
	public static Connection getConnection() throws IOException 
	{

			Properties properties = new Properties();

				FileInputStream fis = new FileInputStream("resources/database.properties");

				properties.load(fis);

				String url = properties.getProperty("url");
				String driver = properties.getProperty("driver");
				String user = properties.getProperty("user");
				String pwd = properties.getProperty("pwd");

				try 
				{
					Class.forName(driver);
					connection = DriverManager.getConnection(url, user, pwd);
					
				} 
				catch (SQLException e) 
				{
					System.out.println(e);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 

	 
			return connection;

		}
		
	
}
