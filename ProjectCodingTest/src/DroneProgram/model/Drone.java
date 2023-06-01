package DroneProgram.model;

import java.util.ArrayList;
import java.util.List;

public class Drone {
	
	private String name;	
	
	private Integer maxWeight;
	
	private List<List<Location>> trips = new ArrayList<>();
		
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getMaxWeight() {
		return maxWeight;
	}
	public void setMaxWeight(Integer maxWeinght) {
		this.maxWeight = maxWeinght;
	}
	
	public Drone (String name, Integer maxWeight) {
		this.name = name;
		this.maxWeight = maxWeight;
	}
	
	public List<List<Location>> getTrips() {
		return trips;
	}
	
	public void setTrips(List<List<Location>> trips) {
		this.trips = trips;
	}
	
	public void addLocationsToTrip(List<Location> locations) {
		trips.add(locations);
	}
	
	@Override
	public String toString() {
		return "Drone [name=" + name + ", maxWeinght=" + maxWeight + "]";
	}

}
