
public class Location {
	
	public String zip_code;
	public String latitude;
	public String longitude;
	public String city;
	public String state;
	public String county;
		
	// Getters and Setters
	public String getZip_code() {
		return zip_code;
	}
	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	
	public String toString(){
		return "Zipcode :" + this.zip_code +
				             "Latitude :" + this.latitude +
				             "Longitude :" + this.longitude +
				             "city :" + this.city +
				             "State :" + this.state +
				             "county :" + this.county;
	}
	

}
