
import java.io.BufferedReader;
import java.util.*;
import java.util.Map.Entry;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AppropriateYard {
	
	HashMap<String,Location> locations = new HashMap<>();
	
	public TreeMap findNearestlocations(double lat, double lon){
		
		TreeMap<Double, Location> result = new TreeMap<>();
		int size = locations.size();
		Set<Map.Entry<String, Location>> entrySet = locations.entrySet();
		
		// Finding nearest neighbors
		for(Entry<String, Location> e: entrySet){
			String lat1 = e.getValue().getLatitude();
			String lon1 = e.getValue().getLongitude();
			int latitude = Integer.parseInt(lat1);
			int longitude = Integer.parseInt(lon1);
			double latdiff = lat - latitude;
			double longdiff = lon - longitude;
			double sqrdistance = (latdiff * latdiff) + (longdiff * longdiff);
			double distance =  Math.sqrt(sqrdistance);
			result.put(distance, e.getValue());
			}
		
		return result;
		
	}

    public static void main(String[] args) {
             //Parsing and persisting the data from CSV file
        String file = "C:/Users/saiki.DESKTOP-QQ72GT6/Documents/Geo_locations.txt";
        BufferedReader br = null;
        String line = "";
        String delim = ",";
        HashMap<String,Location> locations = new HashMap<>();

        try {

            br = new BufferedReader(new FileReader(file));
            while ((line = br.readLine()) != null) {

                String[] location = line.split(delim);
                
           Location l = new Location();
           l.setZip_code(location[0]);
           l.setLatitude(location[1]);
           l.setLongitude(location[2]);
           l.setCity(location[3]);
           l.setState(location[4]);
           //l.setCounty(location[5]);
           locations.put(location[0], l);
           }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        AppropriateYard obj = new AppropriateYard();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the latitude cordinate");
        double lat = scan.nextDouble();
        System.out.println("Enter the longitude cordinate");
        double lon = scan.nextDouble();
        
        TreeMap<Double,Location> l = obj.findNearestlocations(lat,lon);
        
        Set<Map.Entry<Double, Location>> entrySet = l.entrySet();
        
        for(Entry<Double, Location> e: entrySet){
        	System.out.println(e.getValue().toString());
        }
    }

}