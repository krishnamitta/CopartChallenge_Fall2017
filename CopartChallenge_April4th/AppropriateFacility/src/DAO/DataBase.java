package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class DataBase {

	private static final String mysqlurl = "jdbc:mysql://localhost:3306/copart";
	private static final String mysqluser = "root";
	private static final String mysqlpassword = "balaji";
	private static final String sqlcmd0="USE copart;";	// use the database statement
	private static ArrayList<Integer> zipcodes = new ArrayList<Integer>();
	
	public ArrayList<String> searchById(String userId) {
		//JSONObject resultJSON = new JSONObject();
		//ArrayList<ArrayList<String>> searchResult = null;
		ArrayList<String> facilities= null;
		Connection conn = null;
		String sqlcmd1 = "SELECT facility FROM copart.users WHERE customerId="+ userId +";";
		try {
			// connect to database
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(mysqlurl, mysqluser, mysqlpassword);
			Statement stmt1 = conn.createStatement();
			
			stmt1.executeQuery(sqlcmd0);	// use the database
			ResultSet result1 = stmt1.executeQuery(sqlcmd1);	// get the result
			//System.out.println("The sql statement is " + sqlcmd1);
			
			//searchResult = new ArrayList<ArrayList<String>>();
			facilities = new ArrayList<String>();
			while (result1.next()) {
				
				facilities.add(result1.getString("facility"));				
				
			}
			//System.out.println("The search product result is got successfully.");
					
			result1.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("Error occurred during communicating with database.");
			e.printStackTrace();
		}
		
		return facilities;
	}
	
	public static ArrayList<Integer> searchByFacility(String  facility) {
		
		//JSONObject resultJSON = new JSONObject();
		//ArrayList<ArrayList<String>> searchResult = null;
		ArrayList<String> facilities= null;
		Connection conn = null;
		
		String sqlcmd1 = "SELECT zipcode FROM copart.facility WHERE facility ='"+ facility +"';";
		
		//String sqlcmd1 = "SELECT F_ZipCode FROM copart.facilities ,copart.users WHERE ZipCode= zipCode AND Facility_Name= facility;";
		try {
			// connect to database
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(mysqlurl, mysqluser, mysqlpassword);
			Statement stmt1 = conn.createStatement();
			
			stmt1.executeQuery(sqlcmd0);	// use the database
			ResultSet result1 = stmt1.executeQuery(sqlcmd1);	// get the result
			//System.out.println("The sql statement is " + sqlcmd1);
			
			//searchResult = new ArrayList<ArrayList<String>>();
			
			while (result1.next()) {
				
				zipcodes.add(Integer.parseInt(result1.getString("zipcode")));				
				
			}
			//System.out.println("The search product result is got successfully.");
					
			result1.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("Error occurred during communicating with database.");
			e.printStackTrace();
		
		}
		
		return zipcodes;
	}

}