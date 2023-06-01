package DroneProgram;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import DroneProgram.model.*;
public class Main {

	public static void main(String[] args) throws FileNotFoundException {		
		//creating File instance to reference text file in Java
        File textInput = new File("src/DroneProgram/Input.txt");
        List<Drone> drones = new ArrayList<>();
        List<Location> locations = new ArrayList<>();
        //Creating Scanner instance to read File in Java
        Scanner scnr = new Scanner(textInput);		
		int line = 0;
		while(scnr.hasNextLine()){	
			//Reading each line of the file using Scanner class
			if(line == 0) {
				drones = getDrones(Arrays.asList(scnr.nextLine().split("\\s*,\\s*")));
			}
			locations.add(getLocation(Arrays.asList(scnr.nextLine().split("\\s*,\\s*"))));			
	       line++;
	    } 		
		
		//We have to arrange the drone List in reversed way to have the one with the most weight at the beginning
		Collections.sort(drones,Comparator.comparingInt(Drone::getMaxWeight).reversed());
     
		//Send List drones and List locations as a parameters of our business logic
		List<Drone> dronesWithTrips = getDronesDelivers(drones,locations);
        
		//Send List drones to show their locations trip
		showDronesLocationsTrip(dronesWithTrips);
		
	}	
	
	//get the drone's name and weight as a List
	public static List<Drone> getDrones(List<String> listFirstLine) {
		List<Drone> listDrones = new ArrayList<>();		
		for(int index=0 ; index< listFirstLine.size() ;index=index+2) {
			listDrones.add(new Drone(listFirstLine.get(index), Integer.parseInt(listFirstLine.get(index+1).substring(1,listFirstLine.get(index+1).length()-1))));
		}
		return listDrones;
	}
	
	//get the location's name and weight as a List
	public static Location getLocation(List<String> listFirstLine) {
		return new Location(listFirstLine.get(0), Integer.parseInt(listFirstLine.get(1).substring(1, listFirstLine.get(1).length()-1)));		
	}
	
	
	public static List<Drone> getDronesDelivers( List<Drone> drones,List<Location> locations ) {
		List<Location> droneLocationsTravel = new ArrayList<Location>();
		Drone currentDroneSender = null;
		for(Location location : locations) {
			// We have to sum of the current trip locations packages weights within List droneLocationsTravel 
			int sumWeightLocations = droneLocationsTravel.stream().mapToInt(o -> o.getPackageWeight()).sum();
			
			//Use a boolean variable to define if drone can 
			boolean currentLocationAssigned  = false;
			for(Drone drone : drones) {
				// Verify the sum of of the current trip carried weight plus the current location weight
				// And if the drone can carry
				if(sumWeightLocations + location.getPackageWeight() <= drone.getMaxWeight()) {
					// get the current location as assigned for drone trip
                    currentLocationAssigned = true;
					droneLocationsTravel.add(location);                   
                    currentDroneSender = drone;                                        
                    break;
				}
			}
			
			// If currentLocationAssigned is false so no drone that can carry the location package,
            // set the current trip location to the last assigned drone            		
			if(!currentLocationAssigned) {
				currentDroneSender.addLocationsToTrip(droneLocationsTravel);
				List<Location> currentLocation = new ArrayList<Location>();
				currentLocation.add(location);
				droneLocationsTravel = currentLocation;
			}
		}
		
		// the last drone get the last location trip
		if (!droneLocationsTravel.isEmpty()) {
			currentDroneSender.addLocationsToTrip(droneLocationsTravel);
		}	
		
		return drones;
	}
	
	//method to print locations of each drone trip
	public static void showDronesLocationsTrip(List<Drone> dronesWithTrips) {		
		for(Drone drone : dronesWithTrips) {
			System.out.println(drone.getName());
			int index = 1;
			for(List<Location> listLocation : drone.getTrips()) {
				System.out.println("Trip #"+index);				
				System.out.println(listLocation.stream().map(Location::getName)
		                .collect(Collectors.joining(", ")));
				index++;
			}
			System.out.println("");
		}
	}

}
