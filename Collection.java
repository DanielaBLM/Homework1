package MyAdapter;

import java.util.*;

public class Collection implements HCollection{

	Vector vettore;

	public Collection() {
		vettore = new Vector();
	}
	
	
	@Override
	public boolean add(Object o) throws NullPointerException  {
		if(o.equals(null)) throw new NullPointerException();
		else{
			vettore.addElement(o);
			return true;
		}
		
	}

	@Override
	public boolean addAll(HCollection c) throws NullPointerException{
		Object temp;
		HIterator it = c.iterator();
		if(c.equals(null)) throw new NullPointerException();
		while (it.hasNext()){
			temp = it.next();
			if(temp.equals(null)) throw new NullPointerException();
			else {
				add(temp);
			}
		}
		
		return true;
	}

	@Override
	public void clear() {
		vettore.removeAllElements();
	}

	@Override
	public boolean contains(Object o) throws NullPointerException{
		if(o.equals(null)) throw new NullPointerException();
	    else {
	    	return vettore.contains(o);
	    }
	}

	@Override
	public boolean containsAll(HCollection c) throws NullPointerException{
		Object temp;
		HIterator it = c.iterator();
		if(c.equals(null)) throw new NullPointerException();
		while (it.hasNext()){
			temp = it.next();
			if(temp.equals(null)) throw new NullPointerException();
			if(!contains(temp)) {
				return false;
			}
		}
		
		return true;
	}
	
	@Override
	public int hashCode() {
		return vettore.hashCode();
	}

	@Override
	public boolean isEmpty() {
		return vettore.isEmpty();
	}

	@Override
	public HIterator iterator() {
		HIterator it = new Iterator();
		return it;
	}

	@Override
	public boolean remove(Object o) throws NullPointerException{
		if(o.equals(null)) throw new NullPointerException();
	    else {
	    	if(!contains(o)) return false;
	    	return vettore.removeElement(o);
	    }
	}

	@Override
	public boolean removeAll(HCollection c) throws NullPointerException{
		Object temp;
		HIterator it = c.iterator();
		if(c.equals(null)) throw new NullPointerException();
		while (it.hasNext()){
			temp = it.next();
			if(temp.equals(null)) throw new NullPointerException();
			if(contains(temp)) {
				remove(temp);
			}
		}
		return true;
	}

	@Override
	public boolean retainAll(HCollection c) throws NullPointerException{
		/*Object temp;
		HIterator it = iterator();
		if(c.equals(null)) throw new NullPointerException();
		//if(c.contains(null)) throw new NullPointerException();
		while(it.hasNext()) {
			temp = it.next();
			if(!c.contains(temp)) remove(temp);
		}*/
		return true;
	}

	@Override
	public int size() {
		return vettore.size();
	}

	@Override
	public Object[] toArray() {
		int index = 0;
	    Object[] stack = new Object[size()];
	    HIterator iterator = iterator();
	    while(iterator.hasNext()) stack[index++] = iterator.next();
	    return stack;
	}

	@Override
	public Object[] toArray(Object[] a) {
		if(size() > a.length) return toArray();
	    else {
	      int index = 0;
	      HIterator iterator = iterator();
	      while(iterator.hasNext()) a[index++] = iterator.next();
	      return a;
	    }
	}
	
	
	
	  //HITERATOR

	private class Iterator implements HIterator {

	    private int startIndex;
	    private int currentIndex;
	    private int endIndex;
	
	    public Iterator() {
	      startIndex = currentIndex = -1;
	      endIndex = size() - 1;
	    }
	
	    public Iterator(int from, int to) {
	      if(from < 0) startIndex = currentIndex = -1;
	      else startIndex = currentIndex = from - 1;
	      if(to > (size() - 1)) endIndex = size() - 1;
	      else endIndex = to;
	    }
	
	    private int getStartIndex() {
	      return startIndex;
	    }
	
	    private int getCurrentIndex() {
	      return currentIndex;
	    }
	
	    private int goBackIndex() {
	      return --currentIndex;
	    }
	
	    public boolean hasNext() {
	      return (currentIndex < endIndex);
	    }
	
	    public Object next() throws NoSuchElementException {
	      try {
	        if(hasNext()) return getIterator(++currentIndex);
	        else throw new NoSuchElementException();
	      } catch(NoSuchElementException e) {
	        System.out.println("There is no other object: " + e);
	        return null;
	      } catch(Exception e) {
	        System.out.println(e);
	        return null;
	      }
	    }
	
	    public void remove() throws IllegalStateException {
	      try {
	        if(currentIndex < 0) throw new IllegalStateException();
	        else Collection.this.remove(currentIndex);
	      } catch (IllegalStateException e) {
	        System.out.println("next() method has not been called yet: " + e);
	      } catch (Exception e) {
	        System.out.println(e);
	      }
	      
	    }
	    
	  }
	  
	private Object getIterator(int index) {
	    return vettore.elementAt(index);
	  }
	
	
	
}
