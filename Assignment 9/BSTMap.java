import java.util.*;

public class BSTMap<K extends Comparable<K>, V > implements  Map<K, V>  {

	private BinarySearchTree<K,V> myTree;
	
	public BSTMap () {
		myTree = new BinarySearchTree<K,V>();
	}

	public boolean containsKey(K key) {
		try{
			myTree.find(key);
			return true;
		}catch(KeyNotFoundException e){
			return false;
		}
	}

	public V get (K key) throws KeyNotFoundException {
		return myTree.find(key);
	}

	public List<Entry<K,V> >	entryList() {
		return myTree.entryList();
	}

	public void put (K key, V value) {
		myTree.insert(key, value);
	}

	public int size() {
		return myTree.size();
	}

	public void clear() {
		myTree.clear();
	}

}
