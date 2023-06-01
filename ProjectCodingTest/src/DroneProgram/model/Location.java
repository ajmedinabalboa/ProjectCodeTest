package DroneProgram.model;

public class Location {
	
	private String name;		

	private Integer packageWeight;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getPackageWeight() {
		return packageWeight;
	}
	
	public void setPackageWeight(Integer packageWeight) {
		this.packageWeight = packageWeight;
	}
	
	public Location(String name, Integer packageWeight) {
		this.name = name;
		this.packageWeight = packageWeight;
	}
	
	@Override
	public String toString() {
		return "Location [name=" + name + ", packageWeight=" + packageWeight + "]";
	}
}
