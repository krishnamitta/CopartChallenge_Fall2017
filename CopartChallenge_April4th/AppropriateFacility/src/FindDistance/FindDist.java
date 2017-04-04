package FindDistance;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Scanner;

import com.google.gson.Gson;

import DAO.DataBase;
import net.minidev.json.parser.ParseException;
/*
 * The class which finds the nearest copart facilities from the set of list. 
 * */
public class FindDist {
	
	/*
	 * We are finding the distance between two zip codes.
	 * We use ZIP Code API, to find the difference between two zipcodes.
	 * We return the zip code with minimum distance from the provided zipecode.
	 * @param postalCode, User zipcode
	 * @param zipcodeCoPart, zipcode of the CoPart Facility
	 * @return JSON, result of distance between two zip codes.  
	 * */
	private static String dist(int postalCode, int zipcodeCoPart) throws IOException{
		URL url = new URL("https://www.zipcodeapi.com/rest/nPWfuOeeIpmsfwOyGNBCyn4sFSHV8J5wz2L3Q0iypE1FbQdREPtdcyGRrnMz7S5G/distance.json/" + postalCode +"/" + zipcodeCoPart+ "/km");
		URLConnection connection = url.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String inputLine;
		String jsonResult = "";
		while ((inputLine = in.readLine()) != null) {
		    jsonResult += inputLine;
		}
		in.close();
		return jsonResult;
	}
	/*
	 *  Gets the postal zipcode from the user and list of available zipcodes of copart and 
	 *  returns the nearest copart zipcode.
	 *  @param zipcode, postal zipcode
	 *  @parm allZipCodes, list of zipcodes for the copart which has the facility
	 * */
	private static int findNearest(int zipcode, ArrayList<Integer> allZipCodes) throws IOException{
		Gson gson = new Gson();
		double min = Integer.MAX_VALUE; int nearestZipCode = allZipCodes.get(0);
		for(int availableZipcode: allZipCodes){
			String distString = dist(zipcode, availableZipcode);
			Distance distObject = gson.fromJson(distString, Distance.class);
			if(min > Double.parseDouble(distObject.getDistance())){
				min = Double.parseDouble(distObject.getDistance());
				nearestZipCode = availableZipcode;
			}
		}
		return nearestZipCode;
	}
	
	public static void main(String[] args) throws IOException, ParseException{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the customer ID");
		String customerId = in.next();
		ArrayList<Integer> allZipCodes = new ArrayList<Integer>();
		DataBase db = new DataBase();
		ArrayList<String> facilityList = db.searchById(customerId);
		for(String facility: facilityList){
			allZipCodes.addAll(db.searchByFacility(facility));
		}
		System.out.println("Enter the postal Code");
		Scanner in1 = new Scanner(System.in);
		String zipcode = in1.nextLine();
		Gson gson = new Gson();
		
		System.out.println(findNearest(Integer.parseInt(zipcode), allZipCodes));
		
	}

}