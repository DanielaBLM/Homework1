package MyAdapter;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

public class CollectionTest {

	private HCollection col;
	private HCollection c;
	
	@Before
	public void init() {
		col = new Collection();
		c = new Collection();
		col.add("primo");
		col.add("primo");
		col.add("secondo");
		col.add("terzo");
		col.add("quarto");
		col.add("quinto");
		
		//collection con 3 elementi presenti in col e 3 elementi non presenti in c
		c.add("primo");
		c.add("secondo");
		c.add("terzo");
		c.add("sesto");
		c.add("settimo");
		c.add("ottavo");
		
	}

	//@AfterClass
	//public static void tearDownAfterClass() throws Exception {
	//}


	@Test
	public void testAdd() {
		
		Assert.assertTrue(col.add("sesto"));
		Assert.assertEquals(col.size(), 7);
		Assert.assertThrows(NullPointerException.class, 
				() -> col.add(null));
	}

	@Test
	public void testAddAll() {
		HCollection a = null;
		
		Assert.assertThrows(NullPointerException.class, () -> col.containsAll(a));
		 
		Assert.assertTrue(col.addAll(c));
		Assert.assertEquals(col.size(), 12);
		
		//non poso controllare se containsAll controlla se ci sono elementi null perchè 
		//non posso aggiungere a una collection elementi null con add(null) - viene lanciata 
		//un'eccezione
		
	}

	@Test
	public void testClear() {
		col.clear();
		Assert.assertTrue(col.isEmpty());
	}

	
	@Test
	public void testContains() {
		Assert.assertTrue(col.contains("primo"));
		Assert.assertFalse(col.contains("decimo"));
		Assert.assertThrows(NullPointerException.class, () -> col.contains(null));
	}

	@Test
	public void testContainsAll() {
		HCollection a = null;
		Assert.assertThrows(NullPointerException.class, () -> col.containsAll(a));
		
		//creo una collection e con soli elementi presenti in col
		HCollection e = new Collection();
		e.add("primo");
		e.add("secondo");
		Assert.assertTrue(col.containsAll(e));
		
		//collection c contiene elementi non presenti in col
		Assert.assertFalse(col.containsAll(c));
		
		//non poso controllare se containsAll controlla se ci sono elementi null perchè per 
		//non posso aggiungere a una collection elementi null con add(null) - viene lanciata 
		//un'eccezione
	}

	@Test
	public void testHashCode() {
		Assert.assertNotEquals(col.hashCode(), c.hashCode());
	}
	@Test
	public void testIsEmpty() {
		Assert.assertFalse(col.isEmpty());
		col.clear();
		Assert.assertTrue(col.isEmpty());
	}

	@Test
	public void testIterator() {
		Assert.assertNotNull(col.iterator());
	}

	@Test
	public void testRemove() {
		//remove elementi presenti nella collection
		Assert.assertTrue(col.remove("secondo"));
		Assert.assertEquals(col.size(), 5);
		Assert.assertTrue(col.remove("primo"));
		Assert.assertEquals(col.size(), 4);
		//remove elemento non presente nella collection
		Assert.assertFalse(col.remove("decimo"));
		
		Assert.assertThrows(NullPointerException.class, () -> col.remove(null));
		
	}

	@Test
	public void testRemoveAll() {
		HCollection a = null;
		
		Assert.assertThrows(NullPointerException.class, () -> col.containsAll(a));

		col.removeAll(c);
		Assert.assertEquals(col.size(), 3);
		
		//col contiene ancora l'elemento "primo", se removeAll(c) viene invocata un'altra vola anche l'elemento
		//"primo" viene rimosso dalla collection 
		col.removeAll(c);
		Assert.assertEquals(col.size(), 2);
		
	}

	@Test
	public void testRetainAll() {
		//HCollection a = null;
		//Assert.assertThrows(NullPointerException.class, () -> col.retainAll(a));
		
		Assert.assertTrue(col.retainAll(c));
		/*col.retainAll(c);
		Assert.assertEquals(col.size(), 3);
		
		Assert.assertTrue(col.contains("primo"));
		Assert.assertTrue(col.contains("Secondo"));
		Assert.assertTrue(col.contains("Terzo"));
		Assert.assertFalse(col.contains("Quarto"));*/
	}

	@Test
	public void testSize() {
		Assert.assertEquals(col.size(), 6);
	}

	@Test
	public void testToArray() {
		Assert.assertNotNull(col.toArray());	
	}

	@Test
	public void testToArrayObjectArray() {
		 Assert.assertNotNull(col.toArray(new Object[col.size()]));
	}

}
