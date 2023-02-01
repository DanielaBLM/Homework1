package MyAdapter;

public interface HMap {
	//Removes all mappings from this map (optional operation).
	void clear();
	  
    //Returns true if this map contains a mapping for the specified key.
	boolean containsKey(Object key);

	//Returns true if this map maps one or more keys to the specified value.
	boolean containsValue(Object value);

   	//Returns a set view of the mappings contained in this map.	
	HSet entrySet();

   	//Compares the specified object with this map for equality.
	boolean equals(Object o);
	
   	//Returns the value to which this map maps the specified key.
	Object get(Object key);
	
    //Returns the hash code value for this map.
	int hashCode();
	
	//Returns true if this map contains no key-value mappings.
	boolean isEmpty();
	
    //Returns a set view of the keys contained in this map.
	HSet keySet();
	
    //Associates the specified value with the specified key in this map (optional operation).
	Object put(Object key, Object value);
	
    //Copies all of the mappings from the specified map to this map (optional operation).
	void putAll(HMap t);
	
    //Removes the mapping for this key from this map if it is present (optional operation).
	Object remove(Object key);
	
    //Returns the number of key-value mappings in this map.
	int size();
	
    //Returns a collection view of the values contained in this map.
	HCollection values();
      
}
