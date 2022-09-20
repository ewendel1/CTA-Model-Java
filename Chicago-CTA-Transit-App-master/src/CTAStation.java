import java.util.ArrayList;

public class CTAStation extends GeoLocation {
	/*
	 *This class contains the attributes/properties of the station.  
	 *It has a method to find out the color of the station.
	 *also a dummy method to demonstrate polymorphism 
	 */
	
	
	private String name;		//Declaring the instance variables (the attributes of a station)
	private String location;
	private boolean wheelchair;
	protected int red;
	protected int green;
	protected int blue;
	protected int brown;
	protected int purple;
	protected int pink;
	protected int orange;
	protected int yellow;

	public CTAStation() { //Default constructor
		name = "Default";
		location = "Subway";
		wheelchair = true;
		red = 0;
		green = -1;
		blue = -1;
		brown = -1;
		purple = -1;
		pink = -1;
		orange = -1;
		yellow = -1;
	}

	public CTAStation(String name, double lat, double lng, String location, boolean wc, int red, int green, int blue,
			int brown, int purple, int pink, int orange, int yellow) { //Non default constructor
		super(lat, lng);
		setName(name);
		setLocation(location);
		setWheelchair(wc);
		setRed(red);
		setGreen(green);
		setBlue(blue);
		setBrown(brown);
		setPurple(purple);
		setPink(pink);
		setOrange(orange);
		setYellow(yellow);
	}

	public String getName() { //Accessor for the Name
		return name;
	}

	public void setName(String name) { //Mutator for the name
		this.name = name;
	}

	public String getLocation() { //Accessor for the location
		return location;
	}

	public void setLocation(String location) { //Mutator for the location
		this.location = location;
	}

	public boolean isWheelchair() { //Accessor for the wheelchair accessibility
		return wheelchair;
	}

	public void setWheelchair(boolean wheelchair) { //Mutator for the wheelchair accessibility
		this.wheelchair = wheelchair;
	}

	public int getRed() { //Accessor for the redline number
		return red;
	}

	public void setRed(int red) { //Mutator for the redline number
		this.red = red;
	}

	public int getGreen() { //Accessor for the greenline number
		return green;
	}

	public void setGreen(int green) { //Mutator for the greenline number
		this.green = green;
	}

	public int getBlue() { //Accessor for the blueline number
		return blue;
	}

	public void setBlue(int blue) { //Mutator for the blueline number
		this.blue = blue;
	}

	public int getBrown() { //Accessor for the brownline number
		return brown;
	}

	public void setBrown(int brown) { //Mutator for the brownline number
		this.brown = brown;
	}

	public int getPurple() { //Accessor for the purpleline number
		return purple;
	}

	public void setPurple(int purple) { //Mutator for the purpleline number
		this.purple = purple;
	}

	public int getPink() { //Accessor for the pinkline number
		return pink;
	}

	public void setPink(int pink) { //Mutator for the pinkline number
		this.pink = pink;
	}

	public int getOrange() { //Accessor for the orangeline number
		return orange;
	}

	public void setOrange(int orange) { //Mutator for the orangeline number
		this.orange = orange;
	}

	public int getYellow() { //Accessor for the yellowline number
		return yellow;
	}

	public void setYellow(int yellow) { //Mutator for the yellowline number
		this.yellow = yellow;
	}

	public String toString() { //the to String method to display the information about the station
		return "Name: " + name + ", Latitude: " + super.latitude + ", Longitude: " + super.longitude + ", Location: "
				+ location + ", Wheelchair accessibility: " + wheelchair;
	}

	public boolean equals(CTAStation cta) { //equals method
		if (name.equals(cta.getName()) && latitude == cta.getLatitude() && longitude == cta.getLongitude()
				&& location.equals(cta.getLocation()) && wheelchair == cta.isWheelchair() && red == cta.getRed()
				&& green == cta.getGreen() && brown == cta.getBrown() && blue == cta.getBlue()
				&& purple == cta.getPurple() && pink == cta.getPink() && orange == cta.getOrange()
				&& yellow == cta.getYellow()) {
			return true;
		}
		return false;
	}

	public String color() { //method to find the color of the station
		ArrayList<String> stopnumbers= new ArrayList<String>(); //declaring a new array list 
		for(int i=0;i<8;i++){
			stopnumbers.add(""); //adding empty values to the list
		}
		// Verifying if the stop number is anything other than -1 and adding to the corresponding index in the list
		if (red != -1) {
			stopnumbers.set(0,"Red.");         
		}
		if (green != -1) {
			stopnumbers.set(1,"Green.");
		}
		if (blue != -1) {
			stopnumbers.set(2,"Blue.");
		}
		if (brown != -1) {
			stopnumbers.set(3,"Brown.");;
		}
		if (purple != -1) {
			stopnumbers.set(4,"Purple.");;
		}
		if (pink != -1) {
			stopnumbers.set(5,"Pink.");
		}
		if (orange != -1) {
			stopnumbers.set(6,"Orange.");
		}
		if (yellow != -1) {
			stopnumbers.set(7,"Yellow.");
		}
		//displaying all the elements of the list side by side
		return stopnumbers.get(0)+stopnumbers.get(1)+stopnumbers.get(2)+stopnumbers.get(3)+stopnumbers.get(4)+stopnumbers.get(5)+stopnumbers.get(6)+stopnumbers.get(7);
	}

	public void displayStationNames() { //dummy method to demonstrate polymorphism 
		System.out.println("What's up yo."); //dummy statement which we're not gonna use anyway
	}
}
