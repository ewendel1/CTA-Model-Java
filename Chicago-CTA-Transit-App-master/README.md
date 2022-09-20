# Chicago-CTA-Transit-App
A JAVA based application for Chicago's rail transit system. Sans a GUI.

## Problem:

Create a program that models the CTA and allows users to interact with the data it contains. How the system is designed is entirely up to you, but it must meet the following requirements:

- Add a new station to the CTA system and be able to verify that the data has been added
- Search for a specific station; users should be able to verify that the search was successful or unsuccessful
- Delete a station from the CTA system; user should be able to verify that the data was deleted
- Generate a route from a starting station to a destination station (this should beable to handle the possibility of a user needing to transfer from one line to another)
- Find the nearest station to a location
- Exit the program

The user should be continually prompted to choose between the above options and can  exit the menu with the appropriate choice. The verification of each operation should be visible by console displays. You may of course add additional menu options.

#### CTA stops CSV format: 
  Name, Latitude, Longitude, Location, Wheelchair, Red, Green, Blue, Brown, Purple, Pink, Orange, Yellow
      
      Name        The name of the station.
      Latitude    The latitude of the station's location.
      Longitude   The longitude of the station's location.
      Location    The location of the station, i.e., elevated or enbankment and such.
      Wheelchair  Denotes the station's wheelchair accessibilty. TRUE/FALSE.
      Red
      Green
      Blue
      Brown       These denote if the line covers the station or not. The stop number, if true and -1 if false.
      Purple
      Pink
      Orange
      Yellow
      
