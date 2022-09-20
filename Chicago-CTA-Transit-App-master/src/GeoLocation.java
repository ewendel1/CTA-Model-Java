public class GeoLocation {
	/*
	 * This is a class with the latitude and longitude of the stations. 
	 * It also has methods to calculate the distance between two stations
	 * either when the other object is given or when the latitude and longitude are given
	*/
	 
	protected double latitude; //Declaring the instance variables latitude and longitude
	protected double longitude;
	
	public GeoLocation() { //Default constructor
		latitude=0.00;
		longitude=0.00;
	}
	
	public GeoLocation(double lat, double lng){ //Non default constructor
		setLatitude(lat);
		this.longitude=lng;
	}
	
	public double getLatitude(){ //getter for Latitude
		return latitude;
	}
	
	public double getLongitude(){ //getter for Longitude
		return longitude;
	}
	
	public void setLatitude(double lat){ //setter for Latitude
		this.latitude=lat;
	}
	
	public void setLongitude(double lng){ //setter for Longitude
		this.longitude=lng;
	}
	
	public String toString(){ //toString method
		return "The latitude and longitude of the location are "+latitude+" and "+longitude;
	}
	
	public boolean equals(GeoLocation g){ //equals method
		if(latitude==g.getLatitude()&&longitude==g.getLongitude()){
			return true;
		}return false;
	}
	
	public double deg2rad(double deg) { //An extra method to convert degrees to radians
		return (deg * Math.PI / 180.0);
	}
	
	public double rad2deg(double rad) { //to convert radians to degrees
		return (rad * 180 / Math.PI);
	}
	
	public double calcDistance(GeoLocation g){ //Method to calculate distance if an object is given
		double theta = g.getLongitude()-this.longitude;
		double dist = Math.sin(deg2rad(latitude)) * Math.sin(deg2rad(g.getLatitude())) + Math.cos(deg2rad(latitude)) * Math.cos(deg2rad(g.getLatitude())) * Math.cos(deg2rad(theta));
		dist = Math.acos(dist);      //This is a predefined method lifted from the internet. 
		dist = rad2deg(dist);    
		dist = dist * 60 * 1.1515* 0.8684;
		return (dist);
	}

	public double calcDistance(double lat, double lng) { //Method to calculate distance if the latitude and longitude are given
		double theta = lng-longitude;
		double dist = Math.sin(deg2rad(latitude)) * Math.sin(deg2rad(lat)) + Math.cos(deg2rad(latitude)) * Math.cos(deg2rad(lat)) * Math.cos(deg2rad(theta));
		dist = Math.acos(dist);   //This is a predefined method lifted from the internet.
		dist = rad2deg(dist);
		dist = dist * 60 * 1.1515* 0.8684;
		return(dist);
	}
}
