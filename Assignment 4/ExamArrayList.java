public class ExamArrayList implements ExamListInterface {
    
    private static final int INITIAL_CAPACITY = 2;
    
    private Exam[]	    storage;  // holds Exams, each with a unique course
    private int		    numExams;
	
    /*
     *
     * Purpose:
     *    Initialize a new instance of PlayerList
     *
     */
    public ExamArrayList() {
        // You must allocate an array to be able
        // to hold INITIAL_CAPACITY Exam objects
        // You must set numExams to be 0
		this.storage = new Exam[INITIAL_CAPACITY];
		this.numExams = 0;
        
    }
    
    /* toString
     *
     * Purpose: return a String representing the forward traversal
     *  with a space after each element
     *
     * Parameters: none
     *
     * Returns: String - the forward list representation
     *
     */
    public String toString() {
        String s = "";
        
        for(int i=0; i<numExams; i++) {
            s += storage[i];
            if(i != (numExams-1))
                s += " ";
        }
        
        return s;
    }
	
	/* get
     *
     * Purpose: returns the element at position
     *
     * Parameters: int - position
     *
     * Pre-Conditions:
     *     for a ExamList x:
     *    position >= 0 AND
     *    position < x.size()
     *
     * Returns: Exam - the Exam at position
     *
     */
    public Exam get (int position){
		return storage[position];
	}

    
    /* size
     *
     * Purpose: returns the number of elements in the list
     *
     * Parameters: none
     *
     * Returns: int - the number of elements
     *
     */
    public int size(){
		return numExams;
	}
    
    /* add
     *
     * Purpose: add Exam e to the Examlist
     *  more space is allocated for the Examlist if necessary
     *  to add e to the list
     *
     * Parameters: Exam e
     *
     * Returns: nothing
     *
     */
	
    public void add (Exam e){
		if(numExams >= storage.length){
			//Adapted from Celina's post-lecture material
			Exam[] array = new Exam[numExams * 2];
			
			for(int i = 0; i < numExams; i++){
				array[i] = storage[i];
			}
			storage = array;
		}
		storage[numExams] = e;
		numExams++;
	}
    
    /* find
     *
     * Purpose: return the position where Exam with given course is in the Examlist,
     *  if Exam with course is not found, returns -1
     *
     * Parameters: String course
     *
     * Pre-Conditions: course is not null
     *
     * Returns: int - position of Exam with course, -1 if it does not exist
     *
     */
    public int find (String course){		
		for(int i = 0; i < numExams; i++){
			if(storage[i].getCourse().equals(course)){
				return i;
			}
		}
		return -1;
	}
	
    /* removeAtPos
     *
     * Purpose: removes the element at position
     *
     * Parameters: int - position
     *
     * Pre-Conditions:
     *    for a ExamList x:
     *        position >= 0 AND
     *        position < x.size()
     *
     * Returns: nothing
     *
     */
    public void removeAtPos (int position){
		Exam[] array = new Exam[numExams - 1];
		int index = 0;
		
		for(int i = 0; i < numExams; i++){
			if(i != position){
				array[index] = storage[i];
				index++;
			}
		}
		storage = array;
		numExams--;
	}
    
    /* removeAllOnDate
     *
     * Purpose: removes all Exams that are on given date
     *    from this ExamList
     *
     * Parameters: Date date
     *
     * Pre-Conditions: date is not null
     *
     * Returns: nothing
     *
     */
    public void removeAllOnDate (Date date){
		int numSame = 0;
		int index = 0;
		
		for(int i = 0; i < numExams; i++){
			if(storage[i].getDate().equals(date)){
				numSame++;
			}
		}
		Exam[] list = new Exam[numExams - numSame];
		
		for(int i = 0; i < numExams; i++){
			if(!storage[i].getDate().equals(date)){
				list[index] = storage[i];
				index++;
			}
		}
		storage = list;
		numExams -= numSame;
		
	}
    

}
