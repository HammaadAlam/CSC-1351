import java.util.Arrays;

/**
 * <aOrderedList Class: Provides functionality for creating a ordered list and changing the values within the list.
 * Provides many different methods for adding, removing, retrieving, and sorting the objects in the list.
 * Also has methods which iterate through the every index of the list in order to find certain objects.
 * Provides a string representation of the ordered list as well.>
 * 
 * CSC 1351 Programming Project No <1>
 * Section <2>
 * 
 * @author <Hammaad Alam>
 * @since <March 17th, 2024>
 * 
 */

public class aOrderedList {
	private final int SIZEINCREMENTS = 20; // Sets SIZEINCREMENTS to unchanged value of 20
	private Comparable[] oList; // Array to store objects
	private int listSize; // Size of array
	private int numObjects; // Number of objects in the list
	private int curr; //Current index
	
	/**
	 * <Constructor>
	 * 
	 * CSC 1351 Programming Project No <1>
	 * Section <2>
	 * 
	 * @author <Hammaad Alam>
	 * @since <March 17th, 2024>
	 * 
	 */
	
	public aOrderedList() {
		this.numObjects = 0;
		this.listSize = SIZEINCREMENTS;
		this.oList = new Car [SIZEINCREMENTS];
		this.curr = -1;
	}
	
	/**
	 * <add - Adds newObject object to the array in the correct position to maintain sorted order>
	 * 
	 * add - adds new object to array in the correct position to maintain sorted order
	 * @newObject - object being added to array
	 * return - nothing
	 * 
	 * CSC 1351 Programming Project No <1>
	 * Section <2>
	 * 
	 * @author <Hammaad Alam>
	 * @since <March 17th, 2024>
	 * 
	 */
	
	public void add(Comparable<?> newObject) {
		int index = 0;
		// Checks if the array is full
	    if (numObjects == listSize) {
			Comparable[] newArray = new Comparable[listSize + SIZEINCREMENTS]; // resizes the array
			
			for (int i = 0; i < listSize; i++) {
				newArray[i] = oList[i];
			}
			
			oList = newArray;
			listSize += SIZEINCREMENTS;
		}
		
	    // Finds correct index to insert the new object in order to maintain a sorted array
		while (index < numObjects && oList[index].compareTo(newObject) < 0) {
			index++;
		}
		
		// shifts all other elements in order to insert new object
		for(int i = numObjects; i > index; i--) {
			oList[i] = oList[i - 1];
		}
		
		// insert object at the correct position
		oList[index] = newObject;
		numObjects++;
	}
	
	/**
	 * <size Method: returns the value of numObjects>
	 * 
	 * size - gets the number of objects
	 * return - numObjects
	 * 
	 * CSC 1351 Programming Project No <1>
	 * Section <2>
	 * 
	 * @author <Hammaad Alam>
	 * @since <March 17th, 2024>
	 * 
	 */
	
	public int size() {
		return numObjects;
	}
	
	/**
	 * <get Method: returns element at the specified index>
	 * 
	 * get - Gets the value of the element at a specific index
	 * @index - index value of element
	 * return - oList[index]
	 * 
	 * CSC 1351 Programming Project No <1>
	 * Section <2>
	 * 
	 * @author <Hammaad Alam>
	 * @since <March 17th, 2024>
	 * 
	 */
	
	public Comparable<?> get(int index) {
		return oList[index];
	}
	
	/**
	 * <isEmpty Method: returns true if array is empty and false otherwise>
	 * 
	 * isEmpty - Checks to see whether array is empty
	 * return - True or false depending on if array is empty
	 * 
	 * CSC 1351 Programming Project No <1>
	 * Section <2>
	 * 
	 * @author <Hammaad Alam>
	 * @since <March 17th, 2024>
	 * 
	 */
	
	public boolean isEmpty() {
		return numObjects == 0;
	}
	
	/**
	 * <remove Method: removes elements at the specified index and moves the following elements down to fill the hole>
	 * 
	 * remove - removes element at the specific index from the array
	 * @index - index of the element to be removed
	 * return - nothing
	 * 
	 * CSC 1351 Programming Project No <1>
	 * Section <2>
	 * 
	 * @author <Hammaad Alam>
	 * @since <March 17th, 2024>
	 * 
	 */
	
	public void remove(int index) {  
	// Checks if index is out of bounds and throws exception if it is
	if(index < 0 || index >= numObjects) {
			throw new IndexOutOfBoundsException("Index: " + index);
		}
		
		// shifts all the elements in the list in order to remove the object at the specified index
		for(int i = index; i < numObjects - 1; i++) {
			oList[i] = oList[i + 1];
		}
		
		oList[numObjects - 1] = null; // Sets new last element to null
		numObjects--; // Decrements the number of objects in the list after one has been removed
	}
	
	/**
	 * <reset Method: resets the parameters so the next element is now the first element>
	 * 
	 * reset - resets parameters so that the first element is correct
	 * return - nothing 
	 * 
	 * CSC 1351 Programming Project No <1>
	 * Section <2>
	 * 
	 * @author <Hammaad Alam>
	 * @since <March 17th, 2024>
	 * 
	 */
	
	public void reset() {
		curr = 0;
	}
	
	/**
	 * <next Method: returns the value of the next method in the list and increments>
	 * 
	 * next - Increments the iterator parameters and returns the next element
	 * return - oList[numObjects++]
	 * 
	 * CSC 1351 Programming Project No <1>
	 * Section <2>
	 * 
	 * @author <Hammaad Alam>
	 * @since <March 17th, 2024>
	 * 
	 */
	
	public Comparable<?> next() {
		return oList[numObjects++];
	}
	
	/**
	 * <hasNext Method:returns true if there are more elements which need to be iterated through>
	 * 
	 * hasNext - Checks to see if iteration has more elements to iterate through
	 * return - True if iteration has more elements to iterate through
	 * 
	 * CSC 1351 Programming Project No <1>
	 * Section <2>
	 * 
	 * @author <Hammaad Alam>
	 * @since <March 17th, 2024>
	 * 
	 */
	
	public boolean hasNext() {
		return curr < numObjects && curr >= 0;
	}
	
	/**
	 * <getObjectIndex Method: gets the index of an object and check is they make and year are equal to any other object in the array>
	 * 
	 * getObjectIndex - Checks for index of car which matches make and year of a car at a different index
	 * @make - make of the car
	 * @year - year of the car
	 * return - returns i if matching object is found and -1 otherwise
	 * 
	 * CSC 1351 Programming Project No <1>
	 * Section <2>
	 * 
	 * @author <Hammaad Alam>
	 * @since <March 17th, 2024>
	 * 
	 */
	
	public int getObjectIndex(String make, int year) {
		for(int i = 0; i < size(); i++) {
			Car car = (Car) oList[i];
			// checks if the make and year are equal
			if(car.getMake().equals(make) && car.getYear() == year) {
				return i; // returns the index if they are equal
			}
		}
		return -1; // returns -1 if they are not
	}
	
	/**
	 * <toString Method: returns the objects in the specified format>
	 * 
	 * toString - Gets the values for the String representation of the car data
	 * return - values.toString() - the string representation
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
	    StringBuilder values = new StringBuilder();
	    for (int i = 0; i < numObjects; i++) {
	        values.append("[").append(oList[i]).append(";]");
	        if (i < numObjects - 1) {
	            values.append(", ");
	        }
	    }
	    return values.toString();
	}
}
