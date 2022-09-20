import java.util.Scanner;

public class Values {
	
	/*
	 *This association class contains all the extra methods to help with the methods of CTARoute class
	 * Mainly contains methods for incrementing/decrementing the stop numbers of the stations
	 * One method for printing the path from one point to other
	 */

	static final Scanner sc = new Scanner(System.in);

	public void reduceValues(String color, int count) { // method to decrease stop number values
		switch (color) {
		case "Red": case "red":
			int rednumber = CTARoute.stops.get(count).getRed(); //First we find the stop number of the station given
			for (int i = 0; i < CTARoute.stops.size(); i++) { //Next we iterate through the list 
				if (CTARoute.stops.get(i).getRed() > rednumber) {
					CTARoute.stops.get(i).setRed(CTARoute.stops.get(i).getRed() - 1); //We reduce the value of any stopnumber that comes after ours
				}
			}
			break;
			//All the cases below follow the same procedure
		case "Green": case "green":
			int greennumber = CTARoute.stops.get(count).getGreen();
			for (int i = 0; i < CTARoute.stops.size(); i++) {
				if (CTARoute.stops.get(i).getGreen() > greennumber) {
					CTARoute.stops.get(i).setGreen(CTARoute.stops.get(i).getGreen() - 1);
				}
			}
			break;
		case "Blue": case "blue":
			int bluenumber = CTARoute.stops.get(count).getBlue();
			for (int i = 0; i < CTARoute.stops.size(); i++) {
				if (CTARoute.stops.get(i).getBlue() > bluenumber) {
					CTARoute.stops.get(i).setBlue(CTARoute.stops.get(i).getBlue() - 1);
				}
			}
			break;
		case "Brown": case "brown":
			int brownnumber = CTARoute.stops.get(count).getBrown();
			for (int i = 0; i < CTARoute.stops.size(); i++) {
				if (CTARoute.stops.get(i).getBrown() > brownnumber) {
					CTARoute.stops.get(i).setBrown(CTARoute.stops.get(i).getBrown() - 1);
				}
			}
			break;
		case "Purple": case "purple":
			int purplenumber = CTARoute.stops.get(count).getPurple();
			for (int i = 0; i < CTARoute.stops.size(); i++) {
				if (CTARoute.stops.get(i).getPurple() > purplenumber) {
					CTARoute.stops.get(i).setPurple(CTARoute.stops.get(i).getPurple() - 1);
				}
			}
			break;
		case "Pink": case "pink":
			int pinknumber = CTARoute.stops.get(count).getPink();
			for (int i = 0; i < CTARoute.stops.size(); i++) {
				if (CTARoute.stops.get(i).getPink() > pinknumber) {
					CTARoute.stops.get(i).setPink(CTARoute.stops.get(i).getPink() - 1);
				}
			}
			break;
		case "orange": case "Orange":
			int Orangenumber = CTARoute.stops.get(count).getOrange();
			for (int i = 0; i < CTARoute.stops.size(); i++) {
				if (CTARoute.stops.get(i).getOrange() > Orangenumber) {
					CTARoute.stops.get(i).setOrange(CTARoute.stops.get(i).getOrange() - 1);
				}
			}
			break;
		case "Yellow": case "yellow":
			int Yellownumber = CTARoute.stops.get(count).getYellow();
			for (int i = 0; i < CTARoute.stops.size(); i++) {
				if (CTARoute.stops.get(i).getYellow() > Yellownumber) {
					CTARoute.stops.get(i).setYellow(CTARoute.stops.get(i).getYellow() - 1);
				}
			}
			break;
		}
	}

	public void increaseValues(CTAStation station, String color) { // method to increase Values of stop numbers
		switch (color) {
		case "Red": case "red":
			System.out.println("Enter its redline stop number");
			while (true) {
				try {
					station.setRed(Integer.parseInt(sc.nextLine())); //reading the stop number from the user and setting it using the accessor
					break;
				} catch (NumberFormatException e) {
					System.out.println("Invalid input. Try again.");
				}
			}
			int rednumber = station.getRed();
			for (CTAStation obj : CTARoute.stops) { //Looping through the list
				if (rednumber != -1 && obj.getRed() != -1 && (obj.getRed() > rednumber || obj.getRed() == rednumber)) {
					obj.setRed(obj.getRed() + 1); //Increasing the value of any stop number that comes afterward ours
				}
			}
			break;
		//Every color below follows the same procedure
		case "green": case "Green":
			System.out.println("Enter its greenline stop number");
			while (true) {
				try {
					station.setGreen(Integer.parseInt(sc.nextLine()));
					break;
				} catch (NumberFormatException e) {
					System.out.println("Invalid input. Try again.");
				}
			}
			int Greennumber = station.getGreen();
			for (CTAStation obj : CTARoute.stops) {
				if (Greennumber != -1 && obj.getGreen() != -1
						&& (obj.getGreen() > Greennumber || obj.getGreen() == Greennumber)) {
					obj.setGreen(obj.getGreen() + 1);
				}
			}
			break;
		case "Blue": case "blue":
			System.out.println("Enter its blueline stop number");
			while (true) {
				try {
					station.setBlue(Integer.parseInt(sc.nextLine()));
					break;
				} catch (NumberFormatException e) {
					System.out.println("Invalid input. Try again.");
				}
			}
			int Bluenumber = station.getBlue();
			for (CTAStation obj : CTARoute.stops) {
				if (Bluenumber != -1 && obj.getBlue() != -1
						&& (obj.getBlue() > Bluenumber || obj.getBlue() == Bluenumber)) {
					obj.setBlue(obj.getBlue() + 1);
				}
			}
			break;
		case "Brown": case "brown":
			System.out.println("Enter its brownline stop number");
			while (true) {
				try {
					station.setBrown(Integer.parseInt(sc.nextLine()));
					break;
				} catch (NumberFormatException e) {
					System.out.println("Invalid input. Try again.");
				}
			}
			int Brownnumber = station.getBrown();
			for (CTAStation obj : CTARoute.stops) {
				if (Brownnumber != -1 && obj.getBrown() != -1
						&& (obj.getBrown() > Brownnumber || obj.getBrown() == Brownnumber)) {
					obj.setBrown(obj.getBrown() + 1);
				}
			}
			break;
		case "Purple": case "purple":
			System.out.println("Enter its purpleline stop number");
			while (true) {
				try {
					station.setPurple(Integer.parseInt(sc.nextLine()));
					break;
				} catch (NumberFormatException e) {
					System.out.println("Invalid input. Try again.");
				}
			}
			int Purplenumber = station.getPurple();
			for (CTAStation obj : CTARoute.stops) {
				if (Purplenumber != -1 && obj.getPurple() != -1
						&& (obj.getPurple() > Purplenumber || obj.getPurple() == Purplenumber)) {
					obj.setPurple(obj.getPurple() + 1);
				}
			}
			break;
		case "Pink": case "pink":
			System.out.println("Enter its pinkline stop number");
			while (true) {
				try {
					station.setPink(Integer.parseInt(sc.nextLine()));
					break;
				} catch (NumberFormatException e) {
					System.out.println("Invalid input. Try again.");
				}
			}
			int Pinknumber = station.getPink();
			for (CTAStation obj : CTARoute.stops) {
				if (Pinknumber != -1 && obj.getPink() != -1
						&& (obj.getPink() > Pinknumber || obj.getPink() == Pinknumber)) {
					obj.setPink(obj.getPink() + 1);
				}
			}
			break;
		case "Orange": case "orange":
			System.out.println("Enter its orangeline stop number");
			while (true) {
				try {
					station.setOrange(Integer.parseInt(sc.nextLine()));
					break;
				} catch (NumberFormatException e) {
					System.out.println("Invalid input. Try again.");
				}
			}
			int Orangenumber = station.getOrange();
			for (CTAStation obj : CTARoute.stops) {
				if (Orangenumber != -1 && obj.getOrange() != -1
						&& (obj.getOrange() > Orangenumber || obj.getOrange() == Orangenumber)) {
					obj.setOrange(obj.getOrange() + 1);
				}
			}
			break;
		case "yellow": case "Yellow":
			System.out.println("Enter its yellowline stop number");
			while (true) {
				try {
					station.setYellow(Integer.parseInt(sc.nextLine()));
					break;
				} catch (NumberFormatException e) {
					System.out.println("Invalid input. Try again.");
				}
			}
			int Yellownumber = station.getYellow();
			for (CTAStation obj : CTARoute.stops) {
				if (Yellownumber != -1 && obj.getYellow() != -1
						&& (obj.getYellow() > Yellownumber || obj.getYellow() == Yellownumber)) {
					obj.setYellow(obj.getYellow() + 1);
				}
			}
			break;
		default: //default case: do nothing.
			break;
		}
	}

	public void pathnames(String color, int sourceindex, int temp) { // method to print the stations names between station A, station B
		switch (color) {
		case "Red":
			//i is a counter that increases, j is a counter that decreases. I shall decide if I need to use i or j to reach the transfer station, number wise.
			for (int i = CTARoute.stops.get(sourceindex).getRed(), j = i; i - CTARoute.stops.get(temp).getRed() <= 0
					|| j - CTARoute.stops.get(temp).getRed() >= 0; i++, j--) { 
				for (CTAStation stat : CTARoute.stops) {
					//Looping through the list to reach the transfer station by incrementing/decrementing towards its index number and displaying the
					//station names.
					if (stat.getRed() == i && i - CTARoute.stops.get(temp).getRed() <= 0) {
						System.out.println(stat.getName());
						break;
					}
					if (stat.getRed() == j && j - CTARoute.stops.get(temp).getRed() >= 0) {
						System.out.println(stat.getName());
						break;
					}
				}
			}
			break;
			//all the cases below follow the same procedure
		case "Green":
			for (int i = CTARoute.stops.get(sourceindex).getGreen(), j = i; i - CTARoute.stops.get(temp).getGreen() <= 0
					|| j - CTARoute.stops.get(temp).getGreen() >= 0; i++, j--) {
				for (CTAStation stat : CTARoute.stops) {
					if (stat.getGreen() == i && i - CTARoute.stops.get(temp).getGreen() <= 0) {
						System.out.println(stat.getName());
						break;
					}
					if (stat.getGreen() == j && j - CTARoute.stops.get(temp).getGreen() >= 0) {
						System.out.println(stat.getName());
						break;
					}
				}
			}
			break;
		case "Blue":
			for (int i = CTARoute.stops.get(sourceindex).getBlue(), j = i; i - CTARoute.stops.get(temp).getBlue() <= 0
					|| j - CTARoute.stops.get(temp).getBlue() >= 0; i++, j--) {
				for (CTAStation stat : CTARoute.stops) {
					if (stat.getBlue() == i && i - CTARoute.stops.get(temp).getBlue() <= 0) {
						System.out.println(stat.getName());
						break;
					}
					if (stat.getBlue() == j && j - CTARoute.stops.get(temp).getBlue() >= 0) {
						System.out.println(stat.getName());
						break;
					}
				}
			}
			break;
		case "Brown":
			for (int i = CTARoute.stops.get(sourceindex).getBrown(), j = i; i - CTARoute.stops.get(temp).getBrown() <= 0
					|| j - CTARoute.stops.get(temp).getBrown() >= 0; i++, j--) {
				for (CTAStation stat : CTARoute.stops) {
					if (stat.getBrown() == i && i - CTARoute.stops.get(temp).getBrown() <= 0) {
						System.out.println(stat.getName());
						break;
					}
					if (stat.getBrown() == j && j - CTARoute.stops.get(temp).getBrown() >= 0) {
						System.out.println(stat.getName());
						break;
					}
				}
			}
			break;
		case "Purple":
			for (int i = CTARoute.stops.get(sourceindex).getPurple(), j = i; i
					- CTARoute.stops.get(temp).getPurple() <= 0
					|| j - CTARoute.stops.get(temp).getPurple() >= 0; i++, j--) {
				for (CTAStation stat : CTARoute.stops) {
					if (stat.getPurple() == i && i - CTARoute.stops.get(temp).getPurple() <= 0) {
						System.out.println(stat.getName());
						break;
					}
					if (stat.getPurple() == j && j - CTARoute.stops.get(temp).getPurple() >= 0) {
						System.out.println(stat.getName());
						break;
					}
				}
			}
			break;
		case "Pink":
			for (int i = CTARoute.stops.get(sourceindex).getPink(), j = i; i - CTARoute.stops.get(temp).getPink() <= 0
					|| j - CTARoute.stops.get(temp).getPink() >= 0; i++, j--) {
				for (CTAStation stat : CTARoute.stops) {
					if (stat.getPink() == i && i - CTARoute.stops.get(temp).getPink() <= 0) {
						System.out.println(stat.getName());
						break;
					}
					if (stat.getPink() == j && j - CTARoute.stops.get(temp).getPink() >= 0) {
						System.out.println(stat.getName());
						break;
					}
				}
			}
			break;
		case "Orange":
			for (int i = CTARoute.stops.get(sourceindex).getOrange(), j = i; i
					- CTARoute.stops.get(temp).getOrange() <= 0
					|| j - CTARoute.stops.get(temp).getOrange() >= 0; i++, j--) {
				for (CTAStation stat : CTARoute.stops) {
					if (stat.getOrange() == i && i - CTARoute.stops.get(temp).getOrange() <= 0) {
						System.out.println(stat.getName());
						break;
					}
					if (stat.getOrange() == j && j - CTARoute.stops.get(temp).getOrange() >= 0) {
						System.out.println(stat.getName());
						break;
					}
				}
			}
			break;
		case "Yellow":
			for (int i = CTARoute.stops.get(sourceindex).getYellow(), j = i; i
					- CTARoute.stops.get(temp).getYellow() <= 0
					|| j - CTARoute.stops.get(temp).getYellow() >= 0; i++, j--) {
				for (CTAStation stat : CTARoute.stops) {
					if (stat.getYellow() == i && i - CTARoute.stops.get(temp).getYellow() <= 0) {
						System.out.println(stat.getName());
						break;
					}
					if (stat.getYellow() == j && j - CTARoute.stops.get(temp).getYellow() >= 0) {
						System.out.println(stat.getName());
						break;
					}
				}
			}
			break;
		}
	}
}
