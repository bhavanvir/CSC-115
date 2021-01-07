public class IntegerLinkedList implements IntegerList {


    private IntegerNode	head;
    private IntegerNode tail;
    private int		    count;

	public IntegerLinkedList(){
		head = null;
		tail = null;
		count = 0;
	}
	
	/*
     *
     * Purpose: add i to the front of this list
     *  more space is allocated if necessary
     *  to add ito the list
     *
     * Parameters: int - i
     *
     * Returns: nothing
     *
     */
    public void addFront (int i) {
        IntegerNode newNode = new IntegerNode(i);
		
        if (head == null) {
            tail = newNode;
        }else{
			head.prev = newNode;
		}

        newNode.next = head;
        head = newNode;
        count++;

    }
    
    /*
     *
     * Purpose: add i to the back of this list
     *  more space is allocated if necessary
     *  to add it to the list
     *
     * Parameters: int - i
     *
     * Returns: nothing
     *
     */
    public void addBack (int i) {
        IntegerNode newNode = new IntegerNode(i);
		
        if (head == null) {
			head = newNode;
			tail = newNode;
        } else {
            newNode.prev = tail;
			tail.next = newNode;
			tail = newNode;
        }

        tail = newNode;
        count++;
    }
    
    /*
     *
     * Purpose: returns the number of elements in this list
     *
     * Parameters: none
     *
     * Returns: int - the number of elements
     *
     */
    public int size (){
		return count;
	}
    
    /*
     *
     * Purpose: returns the element at position
     *
     * Parameters: int - position
     *
     * Pre-Conditions:
     *     for a IntegerList x:
     *    position >= 0 AND
     *    position < x.size()
     *
     * Returns: int - the int at position
     *
     */
    public int getAtPosition (int position){
		IntegerNode curr = head;

		for(int i = 0; i < position; i++){
			curr = curr.next;
		}
		return curr.getElement();
	}
    
    /*
     *
     * Purpose: return the position where i is in the list,
     *  if i is not found returns -1
     *
     * Parameters: int - i
     *
     * Returns: int - position of i, -1 if i does not exist
     *
     */
    public int getPositionOfVal (int i){
		IntegerNode curr = head;
		int position = 0;
		
		while(curr != null){
			if(curr.getElement() == i){
				return position;
			}else{
				curr = curr.next;
				position++;
			}
		}
		return -1;
	}
    
    /*
     *
     * Purpose: computes the sum of only elements in this list
     *      which hold values that are divisible by given divisor
     *
     * Parameters: none
     *
     * Returns: int - the sum
     *
     */
    public int sumDivisible (int divisor){
		IntegerNode curr = head;
		int sum = 0;
		
		for(int i = 0; i < count; i++){
			if(curr.getElement() % divisor == 0){
				sum += curr.getElement();
				curr = curr.next;
			}else{
				curr = curr.next;
			}
		}
		return sum;
	}
    
    /*
     *
     * Purpose: computes the sum of only elements in this list
     *    at even positions within the list where, the the first
     *    element of the list is considered to be at position 0.
     *
     * Parameters: none
     *
     * Returns: int - the sum
     *
     */
    public int sumEvenPositionElements(){
		IntegerNode curr = head;
		int sum = 0;
		
		for(int i = 0; i < count; i++){
			if(i % 2 == 0){
				sum += curr.getElement();
				curr = curr.next;
			}else{
				curr = curr.next;
			}
		}
		return sum;
	}
    
    /*
     *
     * Purpose: remove all elements with i from the list
     *   The number of occurances of i can be >= 0
     *
     * Parameters: int - i
     *
     * Returns: nothing
     *
     */
    public void removeValue(int i) {
		IntegerNode curr = head;
		
		while(curr != null){
			if(curr.getElement() == i){
				if(count == 1){
					tail = null;
					head = null;
				}else if(curr == head){
					head = head.next;
					head.prev = null;
				}else if(curr == tail){
					tail = tail.prev;
					tail.next = null;
				}else{
					curr.next.setPrev(curr.prev);
					curr.prev.setNext(curr.next);
				}
				count--;
			}
			curr = curr.next;
		}
    }
  
    /*
     *
     * Purpose: return a String representing the forward
     *  traversal of this list with a space between each element
     *
     * Parameters: none
     *
     * Returns: String - the forward list representation
     *
     */
    public String toString(){
		String s = "";
		IntegerNode curr = head;
		
		while(curr != null){
			s += curr.getElement();
			if(curr.next != null){
				s += " ";
			}
			curr = curr.next;
		}
		return s;
		
		
	}
 
    /*
     *
     * Purpose: return a String representing the reverse
     *  traversal of this list with a space between each element
     *
     * Parameters: none
     *
     * Returns: String - the reverse list representation
     *
     */
    public String reverse() {
        String s = "";
        IntegerNode tmp = tail;
		
        while (tmp!=null) {
            s += tmp.getElement();
            if(tmp.prev!=null)
                s += " ";
            tmp = tmp.prev;
        }
        return s;
		
    }

}
