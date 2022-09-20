import java.io.*;
import java.util.*;

public class CTARoute extends CTAStation {
	/*
	 * This class contains all the major methods,
	 * required to manipulate the values of the stations ability to add/delete.
	 * stations
	 */

	protected static ArrayList<CTAStation> stops = new ArrayList<>(); // secondary list that holds the instances of the stations
	static final Scanner sc = new Scanner(System.in); // just to make our lives easier
	Values value = new Values(); // ASSOCIATION RELATIONSHIP with Values class.

	public CTARoute() // Default constructor
	{
		stops = new ArrayList<>();
	}

	public CTARoute(ArrayList<CTAStation> list) { // Non default constructor
		for (int i = 0; i < list.size(); i++) {
			stops.add(i, list.get(i));
		}
	}

	public ArrayList<CTAStation> getStops() { // getter for stops
		return stops;
	}

	public void setStops(ArrayList<CTAStation> haha) { // setter for stops
		for (int i = 0; i < haha.size(); i++) {
			stops.set(i, haha.get(i));
		}
	}

	// method to display the station names. The original method for the dummy method in CTAStation class. FOR POLYMORPHISM.
	public void displayStationNames() {
		int elementnumer = 1;
		for (int i = 0; i < stops.size(); i++) {
			// Iterating through the list and printing the names of all the objects in the list with their line colors and element numbers.
			System.out.println(elementnumer + "." + stops.get(i).getName() + " (" + stops.get(i).color() + ")");
			elementnumer++;
		}
	}

	public void displaybyWheelchair() { // method to display station names with/without wheelchair access
		System.out.println("Wheelchair accessible? 	Enter Y/N");
		while (true) { // looping continuously and breaking only if Y or N is entered.
			String wc = sc.nextLine(); // Reading the users choice
			if (wc.equalsIgnoreCase("Y")) { // If the user enters Y,
				for (int j = 0; j < stops.size(); j++) {
					// Going through the list of station objects to check for the ones that have 'true' for wheelchair accessibility
					if (stops.get(j).isWheelchair() == true) {
						System.out.println(stops.get(j).getName() + " (" + stops.get(j).color() + ")"); // Printing the stations found with line colors
					}
				}
				break;
			} else if (wc.equalsIgnoreCase("N")) { // If the user enters N,
				for (int j = 0; j < stops.size(); j++) {
					if (stops.get(j).isWheelchair() == false) { // Same as above, but checking for 'false' as accessibility
						System.out.println(stops.get(j).getName() + " (" + stops.get(j).color() + ")");
					}
				}
				break;
			}
			System.out.println("Invalid Input. Try again with 'Y' for Yes and 'N' for No.");
		}
	}

	public void searchStation(String name) { // method to search station
		int count = 0;
		for (int i = 0; i < stops.size(); i++) {
			if (name.equalsIgnoreCase((stops.get(i)).getName())) { // If a station with the entered name has been found,
				System.out.println("(" + stops.get(i).color() + ")line:"); // display its color
				System.out.println(stops.get(i).toString() + "\n"); // display its info
				writeFile("Found_" + name + ".csv"); // write a new file with the found station
				count = i;
			}
		}
		if (count > 0) {
			// message if the station is found
			System.out.println("A file with the found station has been created.\n ");
		} else { // message if it isn't
			System.out.println("The station cannot be found");
		}
	}

	public void displaystationsinfo() { // method to display information of all
										// the stations
		for (CTAStation obj : stops) {
			System.out.println(obj.toString() + ", Color: " + obj.color() + "\n"); // printing the info of the station with its color
		}
	}

	public void nearestStation(double lat, double lng, int n) { // method to the nearest station to the location
		int number = 0;
		int j = 1;
		double smallest = stops.get(0).calcDistance(lat, lng); // assuming the distance between given location and the first station to be the smallest
		while (j < stops.size()) {
			if ((stops.get(j).calcDistance(lat, lng) < smallest) && j != n) {
				smallest = stops.get(j).calcDistance(lat, lng); // Iterating through the list, finding smaller distances
				number = j;
			}
			j++;
		}
		// printing the name of the station with the least distance
		System.out.println("\nThe nearest station to the entered location is " + stops.get(number).getName() + " ("
				+ stops.get(number).color() + ")");
	}

	public void path(int sourceindex, int destindex) { // method to display path from one station to another
		String sourceline = stops.get(sourceindex).color().split("[^a-zA-Z]")[0]; // the color of the source
		String destline = stops.get(destindex).color().split("[^a-zA-Z]")[0]; // the color of the destination
		int temp = 0;
		int lake = 0;
		int howard = 0;
		int clarklake = 0;
		for (int i = 0; i < stops.size(); i++) {
			if (stops.get(i).color().contains(sourceline) && stops.get(i).color().contains(destline)) {
				temp = i; // this is the index number of the station that is of both the source color and destination color
				break;
			}
			if (stops.get(i).getName().equalsIgnoreCase("Clark/Lake")) {
				clarklake = i;
			}
			if (stops.get(i).getName().equalsIgnoreCase("Lake")) {
				lake = i;
			}
			if (stops.get(i).getName().equalsIgnoreCase("Howard")) {
				howard = i;
			}
		}
		if (sourceline.equals(destline)) {
			value.pathnames(sourceline, sourceindex, destindex); // Refer pathnames methos in Values class. It prints the path from point A to point B
		} else if (sourceline.equals("Red") && destline.equals("Pink")) {
			value.pathnames(sourceline, sourceindex, lake);
			System.out.println("\nWalk to Clark&Lake. Transfer to " + destline + "line.\n");
			value.pathnames(destline, clarklake, destindex);
		} else if (sourceline.equals("Pink") && destline.equals("Red")) {
			value.pathnames(sourceline, sourceindex, clarklake);
			System.out.println("\nWalk to Lake. Transfer to " + destline + "line.\n");
			value.pathnames(destline, lake, destindex);
			// I had to do the above separately because there is no direct
			// transfer point between redline and pinkline
		} else if (sourceline.equals("Yellow") && (destline.equals("Green") || destline.equals("Brown")
				|| destline.equals("Blue") || destline.equals("Pink") || destline.equals("Orange"))) {
			value.pathnames(sourceline, sourceindex, howard);
			System.out.println("\nTransfer to Redline at Howard\n");
			path(howard, destindex);
		} else if (destline.equals("Yellow") && (sourceline.equals("Green") || sourceline.equals("Brown")
				|| sourceline.equals("Blue") || sourceline.equals("Pink") || sourceline.equals("Orange"))) {
			value.pathnames(sourceline, sourceindex, clarklake);
			System.out.println("\nTransfer to GreenLine at Clark/Lake\n");
			path(clarklake, howard);
			System.out.println("\nTransfer to Yellowline at Howard\n");
			value.pathnames("Yellow", howard, destindex);
			// The above situations had to considered separately because
			// transferring to yellow line is tricky as well.
		} else {
			value.pathnames(sourceline, sourceindex, temp);
			System.out.println("\nTransfer to " + destline + "line at " + stops.get(temp).getName() + "\n");
			value.pathnames(destline, temp, destindex);
		}
		// the above is for the rest of the cases
	}

	public void addStation(CTAStation station) { // method to add station to the list
		String[] input;
		System.out.println(
				"\nEnter the route the new station appears on.\nIf it appears on multiple routes, enter them in a single line seperated by commas or spaces");
		// Reading the line(s) the station is on
		input = sc.nextLine().split("[^a-zA-Z]");
		for (int i = 0; i < input.length; i++) {
			value.increaseValues(station, input[i]); //increasing the stopnumbers of the following stations
		}
		stops.add(station); //adding station to the list
		System.out.println("\nA new file with the added station has been created");
		writeFile("Add_" + station.getName() + ".csv"); //creating a new file
	}

	public void removeStation(String name) { //method to remove station from the list
		int number = pathcaseextension(name); //getting the index number of the station from the 'pathextensionmethod' we wrote for the path method
		String colors[] = stops.get(number).color().split("[^a-zA-Z]");
		for (int i = 0; i < colors.length; i++) {
			value.reduceValues(colors[i], number); //decreasing the stop numbers of the following stations
		}
		stops.remove(number); //removing the station from the list
		System.out.println("It has been successfully removed. A new file has been created for you to verify.");
		writeFile("Remove_" + name + ".csv"); //creating a new file
	}

	public int pathcaseextension(String name) { //an added custom method for the path function to find the index number of the entered station
		int n = 1;
		int count = 0;
		int choice = 0;
		for (int i = 0; i < stops.size(); i++) {  
			if (name.equalsIgnoreCase(stops.get(i).getName())) {
				System.out.println(n + "." + stops.get(i).getName() + " " + stops.get(i).color() + "?"); //displaying the various stations with the entered name
				n++;
			}
		}
		n = 0;
		System.out.println("Enter your choice.");
		while (true) {
			try {
				choice = Integer.parseInt(sc.nextLine()); //reading the choice of the user
				break;
			} catch (NumberFormatException e) {
				System.out.println("Please enter a correct menu choice in numbers.");
			}
		}
		for (int j = 0; j < stops.size(); j++) { //Finding out the indexnumber of the station based on the choice entered
			if (name.equalsIgnoreCase(stops.get(j).getName())) {
				count = j; //'count' is the indexnumber of the station
				n++;
				if (n == choice) {
					break;
				}
			}
		}
		return count; //returning the index number
	}

	public boolean exists(String name) { //custom method to find if the entered station exists in the list or not
		int count = 0;
		for (CTAStation stat : stops) {
			if (name.equalsIgnoreCase(stat.getName())) { //Iterating through the list and checking if the station exists
				count++;
			}
		}
		if (count > 0) {
			return true; //returning true or false depending on existence
		} else {
			return false;
		}
	}

	public void writeFile(String name) { //method to write a file with the updated data
		try {
			FileWriter file = new FileWriter(name);
			BufferedWriter output = new BufferedWriter(file);
			//Printing the column headings
			output.write("Number,Name,Latitude,Longitude,Location,Wheelchair,Red,Green,Blue,Brown,Purple,Pink,Orange,Yellow");
			output.newLine();
			int number = 1;
			for (CTAStation obj : stops) { //looping through the list and extracting the values of each attribute
				output.write(number + "." + obj.getName() + "," + obj.getLatitude() + "," + obj.getLongitude() + ","
						+ obj.getLocation() + "," + obj.isWheelchair() + "," + obj.getRed() + "," + obj.getGreen() + ","
						+ obj.getBlue() + "," + obj.getBrown() + "," + obj.getPurple() + "," + obj.getPink() + ","
						+ obj.getOrange() + "," + obj.getYellow()); //printing the values extracted
				output.newLine();
				number++;
			}
			output.close();
			//handling any exceptions
		} catch (IOException io) { 
			System.out.println("I/O Exception");
		} catch (Exception e) {
			System.out.println("Something went wrong");
		}
	}
}
