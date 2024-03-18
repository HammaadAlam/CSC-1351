/**
 * <Car Class: Implements a comparable interface to provide a method to compare the cars based on make and year. 
 * Represents a car object and includes the attributes of the car, including the make, year, and price. 
 * Includes many different getter methods to retrieve the values of the attributes.
 * Provides a string representation of the car object.>
 * 
 * CSC 1351 Programming Project No <1>
 * Section <2>
 * 
 * @author <Hammaad Alam>
 * @since <March 17th, 2024>
 * 
 */

public class Car implements Comparable<Car> {
	private String make; // make of the car
	private int year; // year of the car
	private int price; // price of the car

	/**
	 * <Constructor: sets initial values for variables and creates an instance of the class>
	 * 
	 * CSC 1351 Programming Project No <1>
	 * Section <2>
	 * 
	 * @author <Hammaad Alam>
	 * @since <March 17th, 2024>
	 * 
	 */
	
	public Car(String make, int year, int price) {
		this.make = make;
		this.year = year;
		this.price = price;
	}
	
	/**
	 * <getMake Method: returns the value of make>
	 * 
	 * getMake - gets the make of the car
	 * return - make of the car
	 * 
	 * CSC 1351 Programming Project No <1>
	 * Section <2>
	 * 
	 * @author <Hammaad Alam>
	 * @since <March 17th, 2024>
	 * 
	 */
	
	public String getMake() {
		return make;
	}
	
	/**
	 * <getyear Method: returns the value of year>
	 * 
	 * getYear - gets the year of the car
	 * return - year of the car
	 * 
	 * CSC 1351 Programming Project No <1>
	 * Section <2>
	 * 
	 * @author <Hammaad Alam>
	 * @since <March 17th, 2024>
	 * 
	 */
	
	public int getYear() {
		return year;
	}
	
	/**
	 * <getprice Method: returns the value of price>
	 * 
	 * getPrice - gets price of the car
	 * return - price of the car
	 * 
	 * CSC 1351 Programming Project No <1>
	 * Section <2>
	 * 
	 * @author <Hammaad Alam>
	 * @since <March 17th, 2024>
	 * 
	 */
	
	public int getPrice() {
		return price;
	}
	
	/**
	 * <compareTo Method: Compares the cars based on their makes. If their makes are the same then it compares them based on year>
	 * 
	 * compareTo - Compares the car based on make and year
	 * @other - other car values
	 * return - compareMake
	 * 
	 * CSC 1351 Programming Project No <1>
	 * Section <2>
	 * 
	 * @author <Hammaad Alam>
	 * @since <March 17th, 2024>
	 * 
	 */
	
	@Override
	public int compareTo(Car other) {
		
		// Compares cars based on make first, followed by the year
		int compareMake = this.make.compareTo(other.make);
		
		if(compareMake == 0) {
			return Integer.compare(this.year,other.year);
		}
		
		else {
			return compareMake;
		}    	
		
	}
	    	
	/**
	 * <toString Method: returns the make, year, and price with the specified format>
	 * 
	 * toString - Formats the string representation of the data
	 * return - string representation of the data make, year, and price
	 * 
	 * CSC 1351 Programming Project No <1>
	 * Section <2>
	 * 
	 * @author <Hammaad Alam>
	 * @since <March 17th, 2024>
	 * 
	 */
	
	@Override
    public String toString() {
	    return "Make: " + make + ", Year: " + year + ", Price: " + price;
    }
	
}
