//Bhavanvir Rai V00938954
public class RecursiveIntegerLinkedList implements IntegerList {
    
    private IntegerNode    head;
    private IntegerNode    tail;
    private int		count;
	
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
    public void addFront (int i){
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
    public void addBack (int i){
		IntegerNode newNode = new IntegerNode(i);
		
        if (head == null) {
			head = newNode;
        } else {
            newNode.prev = tail;
			tail.next = newNode;
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
		return getAtPosition(position, head, 0);
	}
	
	private int getAtPosition(int position, IntegerNode head, int index){
		if (position == 0){
            return head.getElement();
        }else{
            if(index == position){
                return head.getElement();
            }
            return getAtPosition(position, head.next, index + 1);
        }
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
		return getPositionOfVal(i, head, 0);
	}
	
	private int getPositionOfVal(int i, IntegerNode head, int index){
		 if (head == null){
            return -1;
        } else{
            if (head.getElement() == i) {
                return index;
            }
            return getPositionOfVal(i, head.next, index + 1);
        }	
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
		return sumDivisible(divisor, head, 0);
	}
	
	private int sumDivisible(int divisor, IntegerNode head, int sum){
        if(head == null){
            return sum;
        }else{
            if(head.getElement() % divisor == 0){
                sum += head.getElement();
            }
            return sumDivisible(divisor, head.next, sum);
        }
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
		return sumEvenPositionElements(0, head, 0);
	}
	
	private int sumEvenPositionElements(int position, IntegerNode head, int sum){
		if(head == null){
			return sum;
		}else{
			if(position % 2 == 0){
				sum += head.getElement();
			}
			return sumEvenPositionElements(position + 1, head.next, sum);
		}
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
	 
    public void removeValue(int i){
		removeValue(i, head);
	}
	
	private void removeValue(int i, IntegerNode curr) {
        if (curr == null) {
            return;
        }else{
            if (curr.getElement() == i){
                if (count == 1){
                    head = null;
                    tail = null;
                }else if (curr == head){
                    head = head.next;
                    head.prev = null;
                }else if (curr == tail){
                    tail = tail.prev;
                    tail.next = null;
                }else {
                    curr.prev.setNext(curr.next);
                    curr.next.setPrev(curr.prev);
                }
                count--;
            }
            removeValue(i, curr.next);
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
		return toString(head, "");
	}
	
	private String toString(IntegerNode head, String s){
		if(head == null){
			return s;
		}else{
			s += head.getElement();
			if(head.next != null){
				s += " ";
			}
			return toString(head.next, s);
		}
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
    public String reverse(){
		return reverse(tail, "");
	}

	private String reverse(IntegerNode tail, String s){
		if(tail == null){
			return s;
		}else{
			s += tail.getElement();
			if(tail.prev != null){
				s += " ";
			}
			return reverse(tail.prev, s);
		}
	}
	
}