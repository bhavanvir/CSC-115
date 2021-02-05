/*
 * represents a transit boarding gate (train, airplane, etc.)
 */

public class BoardingGate {
    
    private PriorityQueue passengers;
    
    /* constructor
     *
     * PURPOSE:
     *  initialize passengers to the default capacity of a HeapPriorityQueue
     *
     * PARAMETERS:
     *  none
     */
	public BoardingGate(){
		passengers = new HeapPriorityQueue();
	}

    /* constructor
     *
     * PURPOSE:
     *  initialize passengers to a new HeapPriorityQueue of given size
     *
     * PARAMETERS:
     *  int size - capacity of passengers
     */
	public BoardingGate(int s){
		passengers = new HeapPriorityQueue(s);
	}

    /* addPassenger
     * PURPOSE:
     *  add given Passenger p to passengers and
     *  prints a notification message if passengers is full
     *
     * PARAMETERS:
     *  Passenger p - Passenger to be added
     *
     * RETURNS:
     *  None.
     */
	public void addPassenger(Passenger p){
		try{
		passengers.insert(p);
		} catch (HeapFullException e){}
	}

    /* numPassengersWaiting
     * PURPOSE:
     *  returns the number of Passengers in passengers waiting to board
     *
     * PARAMETERS:
     *  None.
     *
     * RETURNS:
     *  int - number of passengers waiting to board
     */
	public int numPassengersWaiting(){
		return passengers.size();
	}

    /* nextPassenger
     *
     * PURPOSE:
     *  removes and returns the next Passenger from passengers
     *
     * PARAMETERS:
     *  None.
     *
     * RETURNS:
     *  Passenger - the next Passenger, null if there is no more Passengers.
     */
	public Passenger nextPassenger(){
		if(numPassengersWaiting() == 0){
			return null;
		}
		Comparable p = passengers.removeLow();
		return (Passenger) p;
	}

}

