//Bhavanvir Rai V00938954 2020-1-12
import java.lang.Math;

/*
 * ArrayOperations
 * DO NOT use builtin java Arrays mehthods
 * A class with basic array methods to
 *  - print the values in an array
 *  - calculate the product of the values in an array
 *  - calculate the minimum of the values in an array
 *  - calculate the maximum of the values in an array
 *  - determine the equality to 2 arrays
 *  -
 *
 */
public class ArrayOperations {
    /*
     * printArray
     *
     * Purpose: prints all the values in the array to the console
     *  example format:  {1,2,3,4}
     *
     * Parameters: an array of integers
     *
     * Returns: void
     *
     */
    public static void printArray ( int[] array ) {
        System.out.print("{");
        for(int i=0; i<array.length; i++) {
            
            System.out.print(array[i]);
            if(i<array.length-1)
                System.out.print(",");
        }
        
        System.out.println("}");
    }
    
    /*
     * arrayProduct
     *
     * Purpose: computes the product of all values in the input array
     *  NOTE: product of 3 numbers n1, n2 and n3 = n1*n2*n3
     *  NOTE: product of no numbers = 1
     *
     * Parameters: an array of integers
     *
     * Returns: product of all values in the array
     *
     */
    public static int arrayProduct ( int[] array ) {
        int product = 1;
        // TODO...
		for(int i = 0; i < array.length; i++){
			product = product * array[i];
		}
        
        return product;
    }
    
    /*
     * arrayMax
     *
     * Purpose: finds the maximum value in the input array
     *
     * Parameters: an array of integers
     *
     * Preconditions:
     *	array contains at least one element
     *
     * Returns: maximum value in the array
     *
     */
    // TODO...
	public static int arrayMax(int[] array){
		int max = array[0];
		for(int i = 0; i < array.length; i++){
			if(array[i] > max){
				max = array[i];
			}
		}
		return max;
	}
    
    /*
     * arrayMin
     *
     * Purpose: finds the minimum value in the input array
     *
     * Parameters: an array of integers
     *
     * Preconditions:
     *	array contains at least one element
     *
     * Returns:  minimum value in the array
     *
     */
    // TODO...
	public static int arrayMin(int[] array){
		int min = array[0];
		for(int i = 0; i < array.length; i++){
			if(array[i] < min){
				min = array[i];
			}
		}
		return min;
	}
    
    
    /*
     * arraysEqual
     *
     * Purpose: determines whether the two arrays are equal
     *      where equal means array1 and array2 are the same length
     *      and the contain the same values in the same order
     *
     * Parameters: two arrays of integers
     *
     * Returns: true if the are equal, false otherwise
     *
     */
    // TODO...
	public static boolean arraysEqual(int array1[], int array2[]){
		if(array1.length != array2.length){
			return false;
		}
		
		for(int i = 0; i < array1.length; i++){
			if(array1[i] != array2[i]){
				return false;
			}
		}
		
		return true;
	
	}
    
    /*
     * arrayRange
     *
     * Purpose: determines the range of values in inputArray
     *  as the lowest value and the highest value in the inputArray
     *
     * Parameters: int[] - array of integers
     *
     * Preconditions:
     *    inputArray contains at least one element
     *
     * Returns: int[] - a 2 element array with the lowest and highest values
     *  found in inputArray at index 0 and 1 respectively of the result array
     *
     */
    // TODO...
	public static int[] arrayRange(int[] inputArray){
		int[] outputArray = new int[2];
		
		outputArray[0] = arrayMin(inputArray);
		outputArray[1] = arrayMax(inputArray);
		
		return outputArray;
		
	}
    
    /*
     * areAllAbove
     *
     * Purpose: determines whether all values in array are above threshold
     *
     * Parameters: int[] - array of integers
     *             int - threshold that numbers must be above
     *
     * Returns: boolean - true is all are above, false otherwise
     *
     */
    // TODO...
	public static boolean areAllAbove(int[] array, int threshold){
		for(int i = 0; i < array.length; i++){
			if(array[i] <= threshold){
				return false;
			}
		}
		
		return true;
	
	}
    
    /*
     * contains
     *
     * Purpose: determines whether the values in lookingFor are strictly
     *  contained in searchArray in the same order
     *
     * Parameters: int[] - array of integers being looked for
     *             int[] - array of integers being looked in
     *
     * Returns: boolean - true is all are above, false otherwise
     *
     */
    // TODO...
	
	public static boolean contains(int[] lookingFor, int[] searchArray) {
		int j = 0;
		for (int i = 0; i < searchArray.length; i++) {
			if (searchArray[i] == lookingFor[j]) {
				if (++j >= lookingFor.length){
					return true;
				}
			}else {
				i -= j;
				j = 0;
			}
		}
	
		return false;
	
	}
	
}
