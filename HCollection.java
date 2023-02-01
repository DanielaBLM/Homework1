package MyAdapter;

public interface HCollection {
	
	//Ensures that this collection contains the specified element (optional operation).
	boolean	add(Object o);
    
	//Adds all of the elements in the specified collection to this collection (optional operation).
	boolean addAll(HCollection c);
   
	//Removes all of the elements from this collection (optional operation).
	void clear();
   
	//Returns true if this collection contains the specified element.
	boolean contains(Object o);
    
	//Returns true if this collection contains all of the elements in the specified collection.
	boolean containsAll(HCollection c);
	
	//Compares the specified object with this collection for equality.
	boolean equals(Object o);
   
	//Returns the hash code value for this collection.
	int hashCode();
	
	//Returns true if this collection contains no elements.
	boolean isEmpty();
   
	//Returns an iterator over the elements in this collection.
	HIterator iterator();
   
	//Removes a single instance of the specified element from this collection, if it is present (optional operation).
	boolean remove(Object o);
   
	//Removes all this collection's elements that are also contained in the specified collection (optional operation).
	boolean removeAll(HCollection c);
   
	//Retains only the elements in this collection that are contained in the specified collection (optional operation).
	boolean retainAll(HCollection c);
  
	//Returns the number of elements in this collection.
	int size();
	
	//Returns an array containing all of the elements in this collection.
    Object[] 	toArray();
   
    //Returns an array containing all of the elements in this collection; the runtime type of the returned array is that of the specified arr
    Object[] toArray(Object[] a);
    

	
}
