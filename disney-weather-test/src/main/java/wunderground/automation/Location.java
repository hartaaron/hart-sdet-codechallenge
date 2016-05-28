package wunderground.automation;

public class Location {
	public String city;
	public String state;
	public String zip;

	@Override
	public String toString() {
		return city + " " + state + " " + "(" + zip + ")";
	}
}
