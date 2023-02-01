package MyAdapter;

import java.util.Vector;

public class Collection implements HCollection{

	Vector vettore;

	public Collection() {
		vettore = new Vector();
	}
	
	
	@Override
	public boolean add(Object o) throws NullPointerException  {
		if(o.equals(null)) {
			throw new NullPointerException();
		}
		vettore.addElement(o);
		return true;
	}

	@Override
	public boolean addAll(HCollection c) {
		return false;
	}

	@Override
	public void clear() {
		vettore.removeAllElements();
	}

	@Override
	public boolean contains(Object o) {
		if(o.equals(null)) throw new NullPointerException();
	    else {
	    	return vettore.contains(o);
	    }
	}

	@Override
	public boolean containsAll(HCollection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		return vettore.isEmpty();
	}

	@Override
	public HIterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		return vettore.removeElement(o);
	}

	@Override
	public boolean removeAll(HCollection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(HCollection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		return vettore.size();
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray(Object[] a) {
		// TODO Auto-generated method stub
		return null;
	}
}
