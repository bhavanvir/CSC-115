import java.lang.Math;
//Bhavanvir Rai V00938954
/*
 * ExamArrayOperations
 */
public class ExamArrayOperations {
    
    /*
     * getAllExamLocations
     *
     * Purpose: creates a new array of the locations of all of the exams in the given array
     *
     * Parameters: Exam[] - array
     *
     * Returns: String[] - new array of Exam locations
     *
     */
    // TODO:
	public static String[] getAllExamLocations(Exam[] array){
		String[] storage = new String[array.length];
		for(int i = 0; i < array.length; i++){
			storage[i] = array[i].getLocation();
		}
		return storage;
	}
    
    
    /*
     * getExamDuration
     *
     * Purpose: gets the duration of the Exam in the given array that is
     *  at the given location.
     * If there is more than one exam at the given location,
     *  it gets the location of the first encountered in the given array.
     *
     * Parameters: Exam[] - array, String - location
     *
     * Returns: int - the duration of the Exam or 0 if Exam location is not found
     *
     */
    // TODO:
	public static int getExamDuration(Exam[] array, String location){
		for(int i = 0; i < array.length; i++){
			if(array[i].getLocation() == location){
				return array[i].getDuration();
			}
		}
		return 0;
		
	}
	
    
    /*
     * addExam
     *
     * Purpose: creates a new array 1 longer than input array and copies all Exam references
     *  from input array to new array and puts e at the end of new array
     *
     * Parameters: Exam[] - array, Exam - e
     *
     * Preconditions:  e is not null
     *
     * Returns:  Exam[] - the new array
     *
     */
    // TODO:
	public static Exam[] addExam(Exam[] array, Exam e){
		Exam[] storage = new Exam[array.length + 1];
		for(int i = 0; i < array.length; i++){
			storage[i] = array[i];
		}
		storage[array.length] = e;
		return storage;
	}
    
    
    
    
    /*
     * countExamsOnDate
     *
     * Purpose: counts the number of Exams in array with specified Date
     *
     * Parameters: Exam[] - array, Date - date
     *
     * Returns: int - the count
     *
     */
    // TODO:
	public static int countExamsOnDate(Exam[] array, Date date){
		int count = 0;
		for(int i = 0; i < array.length; i++){
			if(array[i].getDate().equals(date)){
				count++;
			}
		}
		return count;
	}
    
    
    
    /*
     * removeExamsWithDate
     *
     * Purpose: if input array has Exams with the given date,
     *      returns a new array with only those Exams with the given date.
     *  The size of the new array must match the number of Exams
     *      without the given date in the given array.
     *  If the given array does not have Exam with given date,
     *      it returns input array unchanged.
     *
     * Parameters: Exam[] - array, Date date
     *
     * Returns: Exam[] - new array
     *
     */
    // TODO:
	public static Exam[] removeExamsWithDate(Exam[] array, Date date){
		int index = -1;
		Exam[] storage = new Exam[array.length - countExamsOnDate(array, date)];
		for(int i = 0; i < array.length; i++){
			if(!array[i].getDate().equals(date)){
				storage[++index] = array[i];	
			}
		}
		return storage;
	}
    
    
    
    /*
     * getEarliestTimeExam
     *
     * Purpose: get the Exam from array that has the earliest startTime
     *  If there is more than one Exam that is the earliest,
     *  use the first occurance of the earliest in array
     *
     * Parameters: Exam[] - array
     *
     * Precondition: array is not empty
     *
     * Returns: Exam - oldest Exam
     *
     */
    // TODO:
	public static Exam getEarliestTimeExam(Exam[] array){
		for(int i = 0; i < array.length; i++){
			if(array[i].getStartTime().isBefore(array[0].getStartTime())){
				array[0] = array[i];
			}
		}
		return array[0];
		
	}
    
    
    
}
