package myTest;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import MyAdapter.MapAdapter;

public class MapAdapterTest {

	private MapAdapter map;
	
	@Before
	public void setUpBeforeClass() throws Exception {
		map = new MapAdapter();
		map.put("k1", "value1");
		map.put("k2", "value2");
		map.put("k3", "value3");
		map.put("k4", "value4");
		map.put("k5", "value5");
	}

	@Test
	public void testHashCode() {
		Assert.assertNotEquals(map.hashCode(), 0);
	}

	@Test
	public void testClear() {
		Assert.assertFalse(map.isEmpty());
		map.clear();
		Assert.assertTrue(map.isEmpty());
	}

	@Test
	public void testContainsKey() {
		Assert.assertThrows(NullPointerException.class, 
				() -> map.containsKey(null));
		
		Assert.assertTrue(map.containsKey("k1"));
		Assert.assertFalse(map.containsKey("k6"));
		
	}

	@Test
	public void testContainsValue() {
		Assert.assertThrows(NullPointerException.class, 
				() -> map.containsValue(null));
		
		Assert.assertTrue(map.containsValue("value1"));
		Assert.assertFalse(map.containsValue("value6"));
	}

	@Test
	public void testEntrySet() {
		Assert.assertNotNull(map.entrySet());
	}

	@Test
	public void testGet() {
		Assert.assertThrows(NullPointerException.class, 
				() -> map.get(null));
		Assert.assertNull(map.get("k6"));
		Assert.assertEquals(map.get("k1"), "value1");
	}

	@Test
	public void testIsEmpty() {
		Assert.assertFalse(map.isEmpty());
		map.clear();
		Assert.assertTrue(map.isEmpty());
	}

	@Test
	public void testKeySet() {
		Assert.assertNotNull(map.keySet());
	}

	@Test
	public void testPut() {
		Assert.assertThrows(NullPointerException.class, 
				() -> map.put("k7", null));
		Assert.assertThrows(NullPointerException.class, 
				() -> map.put(null, "value7"));
		Assert.assertThrows(NullPointerException.class, 
				() -> map.put(null, null));
		
		
		map.put("k6", "value6");
		Assert.assertTrue(map.size() == 6);
		Assert.assertTrue(map.containsKey("k6"));
		Assert.assertTrue(map.containsValue("value6"));
	}

	@Test
	public void testPutAll() {
		MapAdapter tempMap = new MapAdapter();
		tempMap.put("k6", "value6");
		tempMap.put("k7", "value7");
		map.putAll(tempMap);
		Assert.assertTrue(map.containsKey("k6"));
		Assert.assertTrue(map.containsKey("k7"));
	}

	@Test
	public void testRemove() {
		Assert.assertThrows(NullPointerException.class, 
				() -> map.remove(null));
		map.remove("k1");
		Assert.assertEquals(map.size(), 4);
		Assert.assertFalse(map.containsKey("k1"));
		Assert.assertNull(map.remove("k6"));
	}

	@Test
	public void testSize() {
		Assert.assertEquals(map.size(), 5);
	}

	@Test
	public void testValues() {
		Assert.assertNotNull(map.values());
	}

}
