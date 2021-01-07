//Bhavanvir Rai V00938954
import java.util.*;

public class HashMap<K extends Comparable<K>, V> implements Map<K,V> {

    private long			getLoops;
    private long			putLoops;
    private int       tableSize;

    private List< List<Entry<K,V>> > 	table;
    private int			count;

    public HashMap() {
        tableSize = 1000003; // prime number
        table = new ArrayList<List<Entry<K,V>>>(tableSize);
        // initializes table as a list of empty lists
        for (int i = 0; i < tableSize; i++)
            table.add(new LinkedList<Entry<K,V>>());
        count = 0;

        resetGetLoops();
        resetPutLoops();
    }

    public long getGetLoopCount() {
        return getLoops;
    }

    public long getPutLoopCount() {
        return putLoops;
    }

    public void resetGetLoops() {
        getLoops = 0;
    }
    public void resetPutLoops() {
        putLoops = 0;
    }

    public boolean containsKey(K key) {
        // gets the index in the table this key should be in
        int index = Math.abs(key.hashCode()) % tableSize;
        // TODO... complete this method
        // Tip: use Java's List and Iterator operations to go through a chain at a specific index
		List<Entry<K,V>> l = table.get(index);
		Iterator<Entry<K,V>> it = l.iterator();
		
		if(l.isEmpty())
			return false;

		Entry<K,V> curr = l.get(0);

		while(it.hasNext())
			if(key.equals(curr.getKey()))
				return true;
        return false;
    }

    public V get (K key) throws KeyNotFoundException {
        // gets the index in the table this key should be in
        int index = Math.abs(key.hashCode()) % tableSize;
        // TODO... complete this method
        // Tip: use Java's List and Iterator operations to go through a chain at a specific index
		List<Entry<K,V>> l = table.get(index);
		Iterator<Entry<K,V>> it = l.iterator();
		
		if(l.isEmpty())
			throw new KeyNotFoundException();
		
		Entry<K,V> curr = l.get(0);
		
		while(it.hasNext()){
			if(key.equals(curr.getKey()))
				return curr.getValue();
			curr = it.next();
		}

        throw new KeyNotFoundException();
    }

    public List<Entry<K,V> >	entryList() {
        List <Entry<K,V>> l = new LinkedList<Entry<K,V>>();
        // TODO... complete this method
        // Tip: use Java's List and Iterator operations to go through every index in the table
        //      use a second Iterator to go through each element in a chain at a specific index
        //      and add each element to l
		Iterator<List<Entry<K,V>>> it = table.iterator();
		List<Entry<K,V>> l2 = table.get(0);
		
		while(it.hasNext()){
			if(!l2.isEmpty()){
				Iterator<Entry<K,V>> it2 = l2.iterator();
				Entry<K,V> curr = l2.get(0);
				
				while(it2.hasNext()){
					l.add(curr);
					curr = it2.next();
				}
			}
			l2 = it.next();
		}
		
        return l;
    }

    public void put (K key, V value) {
        // gets the index in the table this key should be in
        int index = Math.abs(key.hashCode())%tableSize;
        // TODO... complete this method
        // Tip: use Java's List and Iterator operations to go through a chain at a specific index
        //  if key is found, update value.  if key is not found add a new Entry with key,value
		List<Entry<K,V>> l = table.get(index);
		Iterator<Entry<K,V>> it = l.iterator();
		Entry<K,V> n = new Entry(key, value);
		
		if(l.isEmpty()){
			l.add(n);
			count++;
			return;
		}
		
		Entry<K,V> next = l.get(0);
	
		while(it.hasNext()){
			if(n.getKey().equals(next.getKey()))
				next.setValue(n.getValue());
			next = it.next();
		}
		
		if(!n.getKey().equals(next.getKey())){
			l.add(n);
			count++;
		}
    }

    public int size() {
        return count;
    }

    public void clear() {
        table.clear();
        count = 0;
    }

}