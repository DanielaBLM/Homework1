package MyAdapter;
import java.util.Hashtable;


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
	public boolean containsKey(Object key) {
		return mappa.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return mappa.contains(value);
	}

	@Override
	public HSet entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object get(Object key) {
		return mappa.get(key);
	}

	@Override
	public boolean isEmpty() {
		return mappa.size() == 0;
	}
	
	@Override
	public int hashCode() {
		return 0;
	}

	@Override
	public HSet keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object put(Object key, Object value) {
		return mappa.put(key, value);
	}

	@Override
	public void putAll(HMap t) {
		for(int i = 0; i < t.size(); i++) {

		}
		
	}

	@Override
	public Object remove(Object key) {
		return mappa.remove(key);
		
	}

	@Override
	public int size() {
		return mappa.size();
	}

	@Override
	public HCollection values() {
		// TODO Auto-generated method stub
		return null;
	}
	
		
	
	
}
