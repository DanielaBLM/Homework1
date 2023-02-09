package myAdapter;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.NoSuchElementException;


public class MapAdapter implements HMap{

	private Hashtable mappa;
	
	public MapAdapter() {
		mappa = new Hashtable();
	}
	
	@Override
	public void clear() {
		mappa.clear();
	}

	@Override
	public boolean containsKey(Object key) throws NullPointerException, ClassCastException{
		IsNotNull(key);
		return mappa.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) throws NullPointerException, ClassCastException{
		IsNotNull(value);
		return mappa.contains(value);
	}

	@Override
	public HSet entrySet() {
		return new EntrySet();
	}

	@Override
	public Object get(Object key) throws ClassCastException, NullPointerException{
		IsNotNull(key);
		return mappa.get(key);
	}

	@Override
	public boolean isEmpty() {
		return mappa.isEmpty();
	}
	
	@Override
	public int hashCode() {
		int hCode = 0;
		HIterator iterator = entrySet().iterator();
		while(iterator.hasNext()) {
			Object o = iterator.next();
			if(o != null) hCode = o.hashCode() + hCode;
		}
		return hCode;
	}

	@Override
	public HSet keySet() {
		return new KeySet();
	}

	@Override
	public Object put(Object key, Object value) throws NullPointerException, ClassCastException, IllegalArgumentException{
		IsNotNull(key);
		IsNotNull(value);
		return mappa.put(key, value);
	}

	@Override
	public void putAll(HMap t) throws ClassCastException, NullPointerException, IllegalArgumentException{
		IsNotNull(t);
		HSet entries = t.entrySet();
		HIterator it = entries.iterator();
		while(it.hasNext()) {
			HMap.Entry tempEntry = (Entry)it.next();
			put(tempEntry.getKey(), tempEntry.getValue());
		}
		
	}

	@Override
	public Object remove(Object key) throws NullPointerException, ClassCastException{
		IsNotNull(key);
		if(!mappa.containsKey(key)) return null;
		return mappa.remove(key);
		
	}

	@Override
	public int size() {
		if(mappa.size() > Integer.MAX_VALUE) return Integer.MAX_VALUE;
		else return mappa.size();
		
	}

	@Override
	public HCollection values() {
		return new ValuesCollection();
	}
	
	
	private void IsNotNull(Object value) throws NullPointerException {
		if(value == null) throw new NullPointerException();
	}
	
	
	public static class Entry implements HMap.Entry {
		
		private Object key;
		private Object value;
		
		public Entry(Object key, Object value) {
			this.key = key;
			this.value = value;
		}

		public Object getKey() {
			return key;
		}

		public Object getValue() {
			return value;
		}

		public Object setValue(Object o) throws NullPointerException {
			value = o;
			return value;
		}
		
		public boolean equals(Object o) throws ClassCastException{
			HMap.Entry entry = (HMap.Entry)o;
			return (getKey().equals(entry.getKey())) && (getValue().equals(entry.getValue()));
		}
		
		public int hashCode() {
			return getKey().hashCode() + getValue().hashCode();
		}
		
	}
	
	private class EntrySet implements HSet {

		//add and addAll operations are not supported for this class
		public boolean add(Object obj) throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}

		public boolean addAll(HCollection c) throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}

		public void clear() {
			MapAdapter.this.clear();
		}

		public boolean contains(Object o) throws ClassCastException, NullPointerException {
			IsNotNull(o);
			HMap.Entry tempEntry = (HMap.Entry)o;
			Object tempValue = get(tempEntry.getKey());
			if(tempValue == null) {
				return false;
			}
			return tempValue.equals(tempEntry.getValue());
		}

		public boolean containsAll(HCollection c) throws ClassCastException, NullPointerException {
			IsNotNull(c);
			HIterator iterator = c.iterator();
			while(iterator.hasNext()) {
				if(!contains(iterator.next())) {
					return false;
				}
			}
			return true;
		}

		public boolean isEmpty() {
			return MapAdapter.this.isEmpty();
		}

		public HIterator iterator() {
			return new EntrySetIterator(mappa.keys());
		}

		public boolean remove(Object obj) throws ClassCastException, NullPointerException {
			IsNotNull(obj);
			HMap.Entry tempEntry = (HMap.Entry)obj;
			Object mapValue = get(tempEntry.getKey());
			Object objValue = tempEntry.getValue();
			if(mapValue == objValue) {
				MapAdapter.this.remove(tempEntry.getKey());
			}
			return mapValue == objValue;
		}

		public boolean removeAll(HCollection c) throws ClassCastException, NullPointerException {
			IsNotNull(c);
			HIterator iterator = iterator();
			boolean tempBool = false;
			while(iterator.hasNext()) {
				Object obj = iterator.next();
				//tempBool = True solo se HCollection c contiene almeno un elemento presente anche nella mappa
				if(c.contains(obj)) //contains() throws ClassCastException, NullPointerException
				{
					remove(obj);
					tempBool = true;
				}
			}
			return tempBool;
		}

		public boolean retainAll(HCollection c) throws ClassCastException, NullPointerException {
			IsNotNull(c);
			HIterator iterator = iterator();
			boolean tempBool = false;
			while(iterator.hasNext()) {
				Object obj = iterator.next();
				//tempBool = True solo se HCollection c contiene almeno un elemento presente anche nella mappa
				if(!c.contains(obj)) //contains() throws ClassCastException, NullPointerException
				{
					remove(obj);
					tempBool = true;
				}
			}
			return tempBool;
		}
		
		public boolean equals(Object obj) {
			if(obj==null) return false;
			EntrySet temp;
			try {
				temp = (EntrySet)obj;
			} catch (ClassCastException cce) {
				return false;
			}
			if(temp.size() != size()) {
				return false;
			}
			HIterator iterator = iterator();
			HIterator tempIterator = temp.iterator();
			while(iterator.hasNext()) {
				if(!iterator.next().equals(tempIterator.next())) {
					return false;
				}
			}
			return true;
		};

		public int hashCode() {
			int hCode = 0;
			HIterator iterator = iterator();
			while(iterator.hasNext()) {
				Object o = iterator.next();
				if(o != null) hCode = o.hashCode() + hCode;
			}
			return hCode;
		};

		public int size() {
			return MapAdapter.this.size();
		}

		public Object[] toArray() {
			return toArray(new HMap.Entry[size()]);
		}

		public Object[] toArray(Object[] obj) throws NullPointerException {
			IsNotNull(obj);
			if(obj.length >= size()) {
				HIterator iterator = iterator();
				int index = 0;
				while(iterator.hasNext()) {
					obj[index] = iterator.next();
					index++;
				}
				for(int i = size(); i < obj.length; i++) {
					obj[i] = null;
				}
				return obj;
			}
			return toArray();
		}
		
		private class EntrySetIterator implements HIterator {
			
			private Enumeration keysEn;
			private Object next;		//next key in Enumeration
			
			public EntrySetIterator(Enumeration keys) {
				keysEn = keys;
				next = null;
			}

			public boolean hasNext() {
				return keysEn.hasMoreElements();
			}

			public Object next() throws NoSuchElementException {
				if(!hasNext()) throw new NoSuchElementException();
				next = keysEn.nextElement();
				HMap.Entry tempEntry = new Entry(next, get(next));
				return tempEntry;
			}

			public void remove() throws IllegalStateException {
				if(next == null) throw new IllegalStateException();
				MapAdapter.this.remove(next);
				next = null;
			}
			
		}
		
	}
	
	private class KeySet extends EntrySet {
		
		public boolean add(Object obj) throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}

		public boolean addAll(HCollection c) throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}
		
		public boolean contains(Object o) throws NullPointerException, ClassCastException {
			IsNotNull(o);
			return MapAdapter.this.containsKey(o);
		}
		
		public boolean remove(Object obj) throws NullPointerException, ClassCastException {
			return !MapAdapter.this.remove(obj).equals(null);
		}
		
		public boolean removeAll(HCollection c) throws NullPointerException, ClassCastException {
			IsNotNull(c);
			HIterator iterator = iterator();
			boolean tempBool = false;
			while(iterator.hasNext()) {
				Object obj = iterator.next();
				//tempBool = True solo se HCollection c contiene almeno un elemento presente anche nella mappa
				if(c.contains(obj)) //contains() throws ClassCastException, NullPointerException
				{
					remove(obj);
					tempBool = true;
				}
			}
			return tempBool;
		}
		
		public boolean retainAll(HCollection c) throws ClassCastException, NullPointerException {
			IsNotNull(c);
			HIterator iterator = iterator();
			boolean tempBool = false;
			while(iterator.hasNext()) {
				Object obj = iterator.next();
				//tempBool = True solo se HCollection c contiene almeno un elemento presente anche nella mappa
				if(!c.contains(obj)) //contains() throws ClassCastException, NullPointerException
				{
					remove(obj);
					tempBool = true;
				}
			}
			return tempBool;
		}
		
		public void clear() {
			MapAdapter.this.clear();
		}
		
		public boolean equals(Object obj) {
			KeySet temp;
			try {
				temp = (KeySet)obj;
			} catch (ClassCastException cce) {
				return false;
			}
			if(temp.size() != size()) {
				return false;
			}
			HIterator iterator = iterator();
			HIterator tmpIterator = temp.iterator();
			while(iterator.hasNext()) {
				if(!iterator.next().equals(tmpIterator.next())) {
					return false;
				}
			}
			return true;
		};
		
		public HIterator iterator() {
			return new KeySetIterator(mappa.keys());
		}
		
		private class KeySetIterator extends EntrySet.EntrySetIterator {
			
			public KeySetIterator(Enumeration keys) {
				super(keys);
			}

			public Object next() throws NoSuchElementException {
				return ((HMap.Entry)super.next()).getKey();
			}
			
		}
		
	}
	
	private class ValuesCollection extends EntrySet {
		
		public boolean add(Object obj) throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}

		public boolean addAll(HCollection c) throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}
		
		public boolean contains(Object obj) throws NullPointerException, ClassCastException {
			IsNotNull(obj);
			return MapAdapter.this.containsValue(obj);
		}
		
		public boolean remove(Object obj) throws NullPointerException, ClassCastException {
			return !MapAdapter.this.remove(obj).equals(null);
		}
		
		public boolean removeAll(HCollection c) throws NullPointerException, ClassCastException {
			IsNotNull(c);
			HIterator iterator = iterator();
			boolean tempBool = false;
			while(iterator.hasNext()) {
				Object obj = iterator.next();
				//tempBool = True solo se HCollection c contiene almeno un elemento presente anche nella mappa
				if(c.contains(obj)) //contains() throws ClassCastException, NullPointerException
				{
					remove(obj);
					tempBool = true;
				}
			}
			return tempBool;
		}
		
		public boolean retainAll(HCollection c) throws ClassCastException, NullPointerException {
			IsNotNull(c);
			HIterator iterator = iterator();
			boolean tempBool = false;
			while(iterator.hasNext()) {
				Object obj = iterator.next();
				//tempBool = True solo se HCollection c contiene almeno un elemento presente anche nella mappa
				if(!c.contains(obj)) //contains() throws ClassCastException, NullPointerException
				{
					remove(obj);
					tempBool = true;
				}
			}
			return tempBool;
		}
		
		public void clear() {
			MapAdapter.this.clear();
		}
		
		public boolean equals(Object obj) {
			ValuesCollection temp;
			try {
				temp = (ValuesCollection)obj;
			} catch (ClassCastException error) {
				return false;
			}
			if(temp.size() != size()) {
				return false;
			}
			HIterator iterator = iterator();
			HIterator tmpIterator = temp.iterator();
			while(iterator.hasNext()) {
				if(!iterator.next().equals(tmpIterator.next())) {
					return false;
				}
			}
			return true;
		};

		public HIterator iterator() {
			return new ValuesCollIterator(mappa.keys());
		}
		
		private class ValuesCollIterator extends EntrySet.EntrySetIterator {
			
			public ValuesCollIterator(Enumeration keys) {
				super(keys);
			}

			public Object next() throws NoSuchElementException {
				return ((HMap.Entry)super.next()).getValue();
			}
		}
	}
}
