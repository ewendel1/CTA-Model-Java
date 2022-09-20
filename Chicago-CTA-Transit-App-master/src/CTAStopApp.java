import java.io.*;
import java.util.*;

public class CTAStopApp {
	
	/*
	 * This class is the main app class. Contains the user menu options
	 * Has a method to read data from the file and store it in a list
	 */

	protected static ArrayList<CTAStation> mainlist; //this is the main array list containing all the instances of stations
	static final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		String choice;
		mainlist = new ArrayList<CTAStation>(); //Initializing the list
		CTAStopApp stopapp = new CTAStopApp();
		stopapp.readFile(); //calling method to read the file
		CTAStation station= new CTARoute(); //POLYMORPHISM
		CTARoute route = new CTARoute(mainlist);
		boolean lol =true;
		while (lol) {
			//displaying the user menu
			System.out.println("\nEnter your choice\n1.Display station names\n2.Display stations with wheelchair access\n3.Search for a station, display info\n4.Display info of all stations\n5.Display nearest station to a location\n6.Show the route from a station to another\n7.Add a new station\n8.Delete a station\n9.Exit\n");
			choice = sc.nextLine(); //reading the choice of the user
			switch (choice) {
			case "1":
				station.displayStationNames(); //calling method to display all the station names (POLYMORPHISM)
				break;
				
			case "2":
				route.displaybyWheelchair(); //calling method to read stations with/without wheelchair access
				break;
				
			case "3":
				System.out.println("Enter the name of your station");
				String stat = sc.nextLine(); //Reading the name of the station
				route.searchStation(stat); //calling the method to search for the station and display its info
				break;
				
			case "4":
				route.displaystationsinfo(); //calling method to dipsplay info of all stations
				break;
				
			case "5":
				double lt = 0.0;
				double lg = 0.0;
				int temp = 0; 
				while (true) {
					try {
						System.out.println("Enter the latitude of the location");
						lt = Double.parseDouble(sc.nextLine()); //reading the latitude of the location
						break;
					} catch (NumberFormatException e) {
						System.out.println("Invalid latitude. Try again.\n");
					}
				}
				while (true) {
					try {
						System.out.println("Enter the longitude of the location");
						lg = Double.parseDouble(sc.nextLine()); //reading the longitude of the location
						break;
					} catch (NumberFormatException e) {
						System.out.println("Invalid longitude. Try again.\n");
					}
				}
				for (int i = 0; i < mainlist.size(); i++) { //Looping through the list to check if the entered latitude and longitude
															//is of a station from the list. This is to avoid calculating distance from itself.
					if (mainlist.get(i).getLatitude() == lt && mainlist.get(i).getLongitude() == lg) {
						temp = i;
					}
				}
				route.nearestStation(lt, lg, temp); //calling method to find the nearest station to the location
				break;
				
			case "6":
				String source = null;
				String destination = null;
				;
				while (true) {
					System.out.println("Enter your source");
					source = sc.nextLine(); //Reading the name of the source
					if (route.exists(source)) { //Checking if this source exists in the list or not
						break;
					} else {
						System.out.println("This station does not exist. Please try again.\n");
					}
				}
				int sourceindex = route.pathcaseextension(source); //finding the index number of the source
				while (true) {
					System.out.println("\nEnter your destination");
					destination = sc.nextLine(); //Reading the name of the destination
					if (route.exists(destination)) { //Checking if this destination exists in the list or not
						break;
					} else {
						System.out.println("This station does not exist. Please try again.");
					}
				}
				int destindex = route.pathcaseextension(destination); //finding the index number of the destination
				route.path(sourceindex, destindex); //calling method to find the path between the source and destination 
				break;
				
			case "7":
				while (true) {
					System.out.println("Enter the Name, latitude, longitude, location and wheelchair accessibility(true or false)");
					try {
						CTAStation instance2 = new CTAStation(sc.nextLine(), Double.parseDouble(sc.nextLine()),
								Double.parseDouble(sc.nextLine()), sc.nextLine(), sc.nextBoolean(),
								-1, -1, -1, -1, -1, -1, -1, -1); //reading the attributes of the new station from the user and creating an instance
						route.addStation(instance2); //calling the method to find the path between the source and destination
						break;
						//handling exceptions
					} catch (NumberFormatException e) {
						System.out.println("The input is not compatible. Try again.\n");
					} catch(InputMismatchException f){
						System.out.println("Enter only either true or false for wheelchair accessibilty. Try Again.\n");
					}
				}
				break;
				
			case "8":
				String statname="";
				while(true){
					System.out.println("Enter the name of the station");
					statname = sc.nextLine(); //reading the name of the station
					if (route.exists(statname)) { //checking is the station exists in the list
						break;
					} else {
						System.out.println("This station does not exist. Please try again.\n");
					}
				}
				route.removeStation(statname); //calling the method to remove the station if it exists
				break;
				
			case "9":
				System.out.println("The program is exiting"); 
				lol = false; //breaking the loop 
				break; 
				
			default:
				System.out.println("Invalid input. Try again with the correct menu numbers.");
				break;
			}
		}

	}

	public void readFile() { //method to read the given file
		Scanner sc;
		try {
			sc = new Scanner(new File("C:\\Users\\Elijah Wendel\\Documents\\IIT\\Fall 2020\\CS251\\Chicago-CTA-Transit-App-master\\Chicago-CTA-Transit-App-master\\src\\CTAStops.csv")); //Reading the file using Scanner
			while (sc.hasNext()) {
				String[] data = sc.nextLine().split(","); //splitting the line at commas
				//creating instances with the read data
				CTAStation instance = new CTAStation(data[0], Double.parseDouble(data[1]), Double.parseDouble(data[2]),
						data[3], Boolean.parseBoolean(data[4]), Integer.parseInt(data[5]), Integer.parseInt(data[6]),
						Integer.parseInt(data[7]), Integer.parseInt(data[8]), Integer.parseInt(data[9]),
						Integer.parseInt(data[10]), Integer.parseInt(data[11]), Integer.parseInt(data[12]));
				mainlist.add(instance); //adding the created instances to the list 
			}
			//handling exceptions
		} catch (FileNotFoundException e) {
			System.out.println("The file is not found");
		}
	}
}
