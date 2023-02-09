package myAdapter;


public interface HCollection {
	
	/**
	 * Ensures that this collection contains the specified element. 
	 * Returns true if this collection changed as a result of the call. (Returns false 
	 * if this collection already contains the specified element.)
	 * @param o
	 * @return true if this collection changed as a result of the call 
	 * @throws UnsupportedOperationException - add is not supported by this collection. 
   	 * @throws ClassCastException - class of the specified element prevents it from being added to this collection. 
    	 * @throws NullPointerException - if the specified element is null and this collection does not support null elements. 
    	 * @throws IllegalArgumentException - some aspect of this element prevents it from being added to this collection.*/
	boolean	add(Object o) throws UnsupportedOperationException, ClassCastException, NullPointerException, IllegalArgumentException;
    
	
	/**
	 * Adds all of the elements in the specified collection to this collection. 
	 * @param c
	 * @return true if this collection changed as a result of the call 
	 * @throws UnsupportedOperationException - if this collection does not support the addAll method. 
     	 * @throws ClassCastException - if the class of an element of the specified collection prevents it 
    	 * from being added to this collection. 
    	 * @throws NullPointerException - if the specified collection contains one or more null elements and 
     	 * this collection does not support null elements, or if the specified collection is null. 
     	 * @throws IllegalArgumentException - some aspect of an element of the specified collection prevents 
      	 * it from being added to this collection.*/
	boolean addAll(HCollection c) throws UnsupportedOperationException, ClassCastException, NullPointerException, IllegalArgumentException;;
   
	
	/**
	 * Removes all of the elements from this collection. This collection will be empty after this method 
	 * returns unless it throws an exception. 
	 * @throws UnsupportedOperationException - if the clear method is not supported by this collection.
	 */
	void clear();
   
	
	/**
	 * Returns true if this collection contains the specified element. More formally, returns true if and only 
	 * if this collection contains at least one element e such that (o==null ? e==null : o.equals(e)).
	 * @param o - element whose presence in this collection is to be tested. 
	 * @return true if this collection contains the specified element 
	 * @trhows ClassCastException - if the type of the specified element is incompatible with this collection (optional). 
     * @throws NullPointerException - if the specified element is null and this collection does not support null 
     *   	   elements (optional). */
	boolean contains(Object o) throws ClassCastException, NullPointerException;
    
	
	/**
	 * Returns true if this collection contains all of the elements in the specified collection. 
	 * @param c
	 * @return true if this collection contains all of the elements in the specified collection 
	 * @throws ClassCastException - if the types of one or more elements in the specified collection are 
	 * 		   incompatible with this collection (optional). 
     	* @throws NullPointerException - if the specified collection contains one or more null elements and 
     	*		   this collection does not support null elements (optional). 
      	* @throws NullPointerException - if the specified collection is null. */
	boolean containsAll(HCollection c) throws ClassCastException, NullPointerException;
	
	
	/**
	 * Compares the specified object with this collection for equality. 
	 * @param o
	 * @return true if the specified object is equal to this collection
	 */
	boolean equals(Object o);
   
	
	/**
	 * Returns the hash code value for this collection. While the Collection interface adds 
	 * no stipulations to the general contract for the Object.hashCode method, programmers 
	 * should take note that any class that overrides the Object.equals method must also override 
	 * the Object.hashCode method in order to satisfy the general contract for the Object.hashCodemethod. 
	 * In particular, c1.equals(c2) implies that c1.hashCode()==c2.hashCode(). 
	 * @return the hash code value for this collection
	 */
	int hashCode();
	
	
	/**
	 * Returns true if this collection contains no elements.
	 * @return true if this collection contains no elements */
	boolean isEmpty();
   
	
	/**
	 * Returns an iterator over the elements in this collection. There are no guarantees concerning the order in 
	 * which the elements are returned (unless this collection is an instance of some class that provides a guarantee). 
	 * @return an Iterator over the elements in this collection */
	HIterator iterator();
   
	
	/**
	 * Removes a single instance of the specified element from this collection, if it is present (optional operation). 
	 * More formally, removes an element e such that (o==null ? e==null : o.equals(e)), if this collection contains 
	 * one or more such elements. Returns true if this collection contained the specified element (or equivalently, 
	 * if this collection changed as a result of the call). 
	 * @param o
	 * @return true if this collection changed as a result of the call 
	 * @throws ClassCastException - if the type of the specified element is incompatible with this collection (optional). 
     * @throws NullPointerException - if the specified element is null and this collection does not support null 
     *         elements (optional). 
     * @throws UnsupportedOperationException - remove is not supported by this collection. */
	boolean remove(Object o) throws ClassCastException, NullPointerException;
   
	/**
	 * Removes all this collection's elements that are also contained in the specified collection (optional operation). 
	 * After this call returns, this collection will contain no elements in common with the specified collection. 
	 * @param c
	 * @return true if this collection changed as a result of the call 
	 * @throws UnsupportedOperationException - if the removeAll method is not supported by this collection. 
     * @throws ClassCastException - if the types of one or more elements in this collection are incompatible 
     *		   with the specified collection (optional). 
     * @throws NullPointerException - if this collection contains one or more null elements and the specified 
     *		   collection does not support null elements (optional). 
     * @throws NullPointerException - if the specified collection is null.*/
	boolean removeAll(HCollection c) throws ClassCastException, NullPointerException;
   
	/**
	 * Retains only the elements in this collection that are contained in the specified collection (optional operation). 
	 * In other words, removes from this collection all of its elements that are not contained in the specified collection. 
	 * @param c
	 * @return true if this collection changed as a result of the call 
	 * @throws UnsupportedOperationException - if the retainAll method is not supported by this Collection. 
     * @throws ClassCastException - if the types of one or more elements in this collection are incompatible with 
     * 		   the specified collection (optional). 
     * @throws NullPointerException - if this collection contains one or more null elements and the specified 
     * @throws collection does not support null elements (optional). 
       @throws	NullPointerException - if the specified collection is null. */
	boolean retainAll(HCollection c) throws ClassCastException, NullPointerException;

	
	/**
	 * Returns the number of elements in this collection. If this collection contains more than Integer.MAX_VALUE elements, 
	 * returns Integer.MAX_VALUE.
	 * @return: the number of elements in this collection */
	int size();
	
	
	/**
	 * Returns an array containing all of the elements in this collection. 
	 * The returned array will be "safe" in that no references to it are maintained by this collection. 
	 * The caller is thus free to modify the returned array.
	 * @return an array containing all of the elements in this collection */
    Object[] toArray();
   
   
    /**
     * Returns an array containing all of the elements in this collection; the runtime type of the 
     * returned array is that of the specified array. If the collection fits in the specified array, 
     * it is returned therein. Otherwise, a new array is allocated with the runtime type of the 
     * specified array and the size of this collection.
     * @param a
     * @return an array containing all of the elements in this collection
     * @throw ArrayStoreException - the runtime type of the specified array is not a supertype 
     * 		  of the runtime type of every element in this collection. 
     * @throws NullPointerException - if the specified array is null. */
    Object[] toArray(Object[] a) throws ArrayStoreException, NullPointerException;
    

	
}
