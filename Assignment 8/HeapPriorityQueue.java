/*
 * HeapPriorityQueue.java
 *
 * An implementation of a minimum PriorityQueue using a heap.
 * based on the implementation in "Data Structures and Algorithms
 * in Java", by Goodrich and Tamassia
 *
 * This implementation will throw a Runtime, HeapEmptyException
 *	if the heap is empty and removeLow is called.
 *
 * This implementation will throw a Runtime, HeapFullException
 *	if the heap is full and insert is called.
 *
 */

public class HeapPriorityQueue implements PriorityQueue {
    
    protected final static int DEFAULT_SIZE = 10000;

    protected Comparable[] storage;
    protected int currentSize;

    /* constructor
    *
    * PURPOSE:
    *  initializes storage to new Comparable[] of DEFAULT_SIZE
    *      and initializes currentSize to 0
    *
    * PARAMETERS:
    *  none
    */
    public HeapPriorityQueue () {
        storage = new Comparable[DEFAULT_SIZE];
        currentSize = 0;
    }

    /* constructor
    *
    * PURPOSE:
    *  initializes storage to new Comparable[] of given size
    *      and initializes currentSize to 0
    *
    * PARAMETERS:
    *  int size
    */
    public HeapPriorityQueue(int size) {
        storage = new Comparable[size];
        currentSize = 0;
    }
	
	//Helper functions
	private int rightChild(int position){
		return (2 * position) + 2;
	}
	
	private int leftChild(int position){
		return (2 * position) + 1;
	}
	
	private int parent(int position){
		return (position - 1) / 2;
	}
	
	private void invert(int child, int parent){
        Comparable childTemporary = storage[child];
        Comparable parentTemporary = storage[parent];
        storage[parent] = childTemporary;
        storage[child] = parentTemporary;
    }
	
	private int minHeapSort(int position){
        int leftChild = leftChild(position);
        int rightChild = rightChild(position);

        if (leftChild < currentSize && rightChild < currentSize){
            if (storage[leftChild].compareTo(storage[rightChild]) < 0){
                return leftChild;
            }
            return rightChild;
        }
        
        return -1;
    }
    
 	/*
	* PURPOSE:
	*	Adds element into the PriorityQueue at the position
	*	according to the element's priority 	.
	*
	* PRECONDITIONS:
	*	None.
	*
	* RETURNS:
	*	None.
	*
	* Examples:
	* 	If q contains elements that would be accessed in the 
	* 	following order:  {5,13,21} after q.insert(20) returns,
	* 	then q will contain elements that will be accessed
	* 	in the following order: {5,13,20,21}.
	*
	*/
	public void insert (Comparable element){
		if (currentSize == storage.length){
			throw new HeapFullException();
		}
		
		int position = currentSize;
		boolean placeholder = true;
		storage[currentSize] = element;
		
		while(placeholder){
			int parent = parent(position);
			if (storage[parent].compareTo(storage[position]) > 0){
				invert(position, parent);
				position = parent;
			}else{
				placeholder = false;
			}   
		}
		currentSize++;
	}

	/*
	* PURPOSE:
	*	Remove highest priority element from the PriorityQueue, 
	*	where the smallest value will be of highest priority.
	*
	* PRECONDITIONS:
	*	None.
	*
	* RETURNS:
	*	None.
	*
	* Examples:
	* 	If q contains elements that would be accessed in the 
	* 	following order:  {5,13,21},  q.removeLow() returns 5,
	* 	and then q will contain elements that will be accessed
	* 	in the following order: {13,21}.
	*
	*/
	public Comparable removeLow (){
        if (currentSize == 0){
		   throw new HeapEmptyException();
        }
	
		int position = 0;
	    boolean placeholder = true;
        Comparable current = storage[0];
        storage[0] = storage[currentSize-1];
     
        while(placeholder){
		    int minimum = minHeapSort(position);
			if (minimum != -1 && storage[position].compareTo(storage[minimum]) > 0 ){
				invert(position, minimum);
				position = minimum;
			}else{
				break;
			} 
        }
        currentSize--;

        return current;
    }
    
	/*
	* PURPOSE:
	*	Determines if the PriorityQueue is empty or not.
	*
	* PRECONDITIONS:
	*	none
	*
	* RETURNS:
	*	true if PriorityQueue is empty, false otherwise.
	*
	*/
	public boolean isEmpty() {
        return (currentSize == 0);
    }
	
	/*
	* PURPOSE:
	*	Determines number of elements in the PriorityQueue.
	*
	* PRECONDITIONS:
	*	None.
	*
	* RETURNS:
	*	the size of the PriorityQueue.
	*
	*/			
	public int	size() {
        return currentSize;
    }

    /*
    * PURPOSE:
    *    constructs a String representation of the elements in storage
    *      ordered by their position in storage NOT by priority 
    *
    * PARAMETERS:
    *    None.
    *
    * RETURNS:
    *    String - the String representation
    *
    */
    public String toString() {
        String s = "";
        String sep = "";
        for(int i=0;i<currentSize;i++) {
            s+= sep + storage[i];
            sep = " ";
        }
        return s;
    }

}
