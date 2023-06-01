# Drone Coding Test

# Algorithm walk through Solution 
1.- We have to transform all data input into List of drones and Locations.
2.- Creating File instance to reference text file in Java.
3.- User Scanner for input reading File lines of text.
4.- We have to arrange the drone List in reversed way to have the one with the most weight at the beginning.
5.- We have to send List drones and List locations as a parameters of our business logic.
  5.1.- business login is based on sum of the current trip locations packages weights within List droneLocationsTravel.
  5.2.- Then we have to verify the sum of of the current trip carried weight plus the current location weight and if the drone can carry.
  5.3.- If currentLocationAssigned is false so no drone that can carry the location package, set the current trip location to the last assigned drone.
  5.4.- The last of sequential algorith verifies the last drone get the last location trip.
6.- We ha ve to send List drones to show their locations trip.

# Issues
1.- I encountered an problem with the input example provided for the test and I don't understand why the Drone A carry the Locations 
[LocationI], [LocationJ], [LocationM], [LocationN] becasuse my algorithm show that the drone B carrys all locations.

