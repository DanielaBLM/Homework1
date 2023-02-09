package myTest;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import MyAdapter.HMap;
import MyAdapter.HMap.Entry;
import MyAdapter.HSet;
import MyAdapter.MapAdapter;

public class EntrySetTest {

	private HSet entry1;
	private HSet entry2;
	
	private MapAdapter ma1;
	private MapAdapter ma2;
	
	
	
	@Before
	public void setUpBeforeClass() throws Exception {
		ma1 = new MapAdapter();
		ma1.put("k1", "primo");
		ma1.put("k2", "secondo");
		ma1.put("k3", "terzo");
		ma1.put("k4", "quarto");
		
		entry1 = ma1.entrySet();
		entry2 = new MapAdapter().entrySet(); 
		
		
	}

	@Test
	public void addTest() {
		Assert.assertThrows(UnsupportedOperationException.class, 
				() -> entry1.add("oggetto"));
	}
	
	@Test
	public void addAllTest() {
		Assert.assertThrows(UnsupportedOperationException.class, 
				() -> entry1.addAll(entry1));
	}
	
	@Test
	public void clearTest() {
		Assert.assertEquals(entry1.size(), 4);
		entry1.clear();
		Assert.assertEquals(entry1.size(), 0);
		Assert.assertEquals(ma1.size(), 0);
	}
	
	@Test
	public void containsTest(){
		Assert.assertThrows(NullPointerException.class, 
				() -> entry1.contains(null));
		
		HMap.Entry tempEntry1 = new MapAdapter.Entry("k1", "primo");
		Assert.assertTrue(entry1.contains(tempEntry1));
		
		HMap.Entry tempEntry2 = new MapAdapter.Entry("k5", "secondo");
		Assert.assertFalse(entry1.contains(tempEntry2));
		
		HMap.Entry tempEntry3 = new MapAdapter.Entry("k1", "quarto");
		Assert.assertFalse(entry1.contains(tempEntry3));
		
		HMap tempMap = new MapAdapter();
		//test se provo ad inserire oggetti che non possono essere convertiti a HMap.Entry
		//ad esempio un oggetto HSet contenente il set tempMap.entrySet()
		HSet tempEntry = tempMap.entrySet();
		Assert.assertThrows(ClassCastException.class, () -> entry1.contains(tempEntry));
	}
	
	@Test
	public void containsAllTest(){
		Assert.assertThrows(NullPointerException.class, 
				() -> entry1.containsAll(null));
		
		ma2 = new MapAdapter();
		ma2.put("k1", "primo");
		ma2.put("k2", "secondo");
		ma2.put("k3", "terzo");
		HSet tempEntry = ma2.entrySet();
		Assert.assertTrue(entry1.containsAll(tempEntry));
		
		ma2.put("k5", "quinto");
		tempEntry = ma2.entrySet();
		Assert.assertFalse(entry1.containsAll(tempEntry));
		
	}
	
	@Test
	public void iteratorTest() {
		Assert.assertNotNull(entry1.iterator());
	}
	
	@Test
	public void isEmptyTest() {
		Assert.assertFalse(entry1.isEmpty());
		Assert.assertFalse(ma1.isEmpty());
		
		entry1.clear();
		
		Assert.assertTrue(entry1.isEmpty());
		Assert.assertTrue(ma1.isEmpty());
	}
	
	@Test
	public void removeTest() {
		Assert.assertThrows(NullPointerException.class, 
				() -> entry1.remove(null));
		
		HMap.Entry tempEntry1 = new MapAdapter.Entry("k1", "primo");
		Assert.assertTrue(entry1.remove(tempEntry1));
		Assert.assertFalse(entry1.contains(tempEntry1));
		
		HMap.Entry tempEntry2 = new MapAdapter.Entry("k5", "secondo");
		Assert.assertFalse(entry1.remove(tempEntry2));
		
		
		HMap tempMap = new MapAdapter();;
		//test se provo ad inserire oggetti che non possono essere convertiti a HMap.Entry
		//ad esempio un oggetto HSet contenente il set tempMap.entrySet()
		HSet tempEntry = tempMap.entrySet();
		Assert.assertThrows(ClassCastException.class, () -> entry1.remove(tempEntry));
	}
	
	@Test
	public void removeAllTest() {
		Assert.assertThrows(NullPointerException.class, 
				() -> entry1.removeAll(null));
		ma2 = new MapAdapter();
		ma2.put("k1", "primo");
		ma2.put("k2", "secondo");
		ma2.put("k3", "terzo");
		entry2 = ma2.entrySet();
		Assert.assertTrue(entry1.removeAll(entry2));
		Assert.assertEquals(entry1.size(), 1);
		
		MapAdapter ma3 = new MapAdapter();
		ma3.put("k8", "quarto");
		ma3.put("k6", "secondo");
		ma3.put("k7", "terzo");
		entry2 = ma3.entrySet();
		Assert.assertFalse(entry1.removeAll(entry2));
		Assert.assertEquals(entry1.size(), 1);
		
	}
	
	@Test
	public void retainAllTest() {
		Assert.assertThrows(NullPointerException.class, 
				() -> entry1.removeAll(null));
		ma2 = new MapAdapter();
		ma2.put("k1", "primo");
		ma2.put("k2", "secondo");
		ma2.put("k3", "terzo");
		entry2 = ma2.entrySet();
		Assert.assertTrue(entry1.retainAll(entry2));
		
		HMap.Entry tempEntry1 = new MapAdapter.Entry("k4", "quarto");
		Assert.assertFalse(entry1.contains(tempEntry1));
	}

	@Test
	public void equalsTest() {
		ma2 = new MapAdapter();
		ma2.put("k3", "terzo");
		ma2.put("k2", "secondo");
		ma2.put("k4", "quarto");
		ma2.put("k1", "primo");
		entry2 = ma2.entrySet();
		Assert.assertTrue(entry1.equals(entry2));
		
		ma2.put("k5", "quinto");
		entry2 = ma2.entrySet();
		Assert.assertFalse(entry1.equals(entry2));
		
	}
	
	@Test
	public void sizeTest() {
		Assert.assertEquals(entry1.size(), 4);
	}
	
	@Test
	public void hashCodeTest() {
		Assert.assertNotEquals(entry1.hashCode(), 0);
	}
	
	@Test
	public void toArrayTest() {
		
	}

}
