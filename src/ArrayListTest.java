import static org.junit.Assert.*;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class ArrayListTest {
	@SuppressWarnings("unchecked")
	
	ArrayList<String> al = null;
	
	@Before
	public void setUp() throws Exception{
		al = new ArrayList<String>();
	}
	
	//since all was declared to be an empty ArrayList, it should not be null
	@Test
	public void testNotNull(){
		assertNotNull(al);
	}
	
	//an ArrayList should always equal itself
	@Test
	public void testEqualsItself(){
		assertEquals(al, al);
	}
	
	//Two empty ArrayLists should be equal
	@Test
	public void testEmptyEquals(){
		ArrayList<String> al2 = new ArrayList<String>();
		assertEquals(al, al2);
	}
	
	//Two ArrayLists that had the same values added in the same order should be equal
	@Test
	public void testNonEmptyEquals(){
		ArrayList<String> al2 = new ArrayList<String>();
		
		al.add("1");
		al.add("2");
		al2.add("1");
		al2.add("2");
		
		assertEquals(al, al2);
	}
	
	//Two ArrayLists of different sizes should never be equal
	@Test
	public void testDiffSizeNotEqual(){
		ArrayList<String> al2 = new ArrayList<String>();
		
		al2.add("1");
		al2.add("Bob");
		al2.add("Blue42");
		
		assertFalse(al.equals(al2));
	}
	
	//An ArrayList with items should have a length greater than 0
	@Test
	public void testGreaterThanZero(){
		al.add("Brett");
		al.add("Allison");
		al.add("0");
		al.add("2");
		
		assertTrue(al.size() > 0);
	}
	
	//An ArrayList with items added should contain
	//those items. Boundary values: First Item and Last Item
	@Test
	public void testNonEmptyExist(){
		ArrayList<Integer> al3 = new ArrayList<Integer>();
		
		for(int i = 0; i < 6; i++){
			al3.add(i);
		}
		
		assertTrue(al3.get(0) != null);
		assertTrue(al3.get(al3.size()-1) != null);
	}
	
	// test to attempt to insert an int in an array of Strings
	@Test
	public void testAddIntFalse(){
		fail();
		//assertFalse(al.add(2));
	}

	// test to remove an element
	@Test
	public void testRemoveElement(){
		al.add("hello");
		al.add("there");
		assertTrue(al.remove("there"));
	}

	// test to remove all elements
	@Test
	public void testRemoveAll(){
		al.add("hello");
		al.add("there");
		assertTrue(al.removeAll(al));
	}

	// test to remove an element that does not exist
	@Test
	public void testRemoveBadElement(){
		assertFalse(al.remove("beepbeepbeep"));
	}

	// test that two ArrayLists are the same
	@Test
	public void testSameArrayList(){
		ArrayList<String> al2 = new ArrayList<String>();
		ArrayList<String> al3 = new ArrayList<String>();
		assertSame(al2, al3);
	}

	// test that two arrays are equal
	@Test
	public void testEqualALists(){
		ArrayList<String> al2 = new ArrayList<String>();
		ArrayList<String> al3 = new ArrayList<String>();
		al2.add("fun");
		al3.add("fun");
		assertEquals(al2, al3);
	}

	// test that the array contains the element "dog"
	@Test
	public void testArrayContains(){
		al.add("dog");
		assertTrue(al.contains("dog"));
	}

	// test that the array does not contain "fog"
	@Test
	public void testArrayContainsFog(){
		assertFalse(al.contains("fog"));
	}

	// fail test to see if the array contains the int, 100
	@Test
	public void testFailContains(){
		fail();
		al.contains(100);
	}

	// test to see if the array is empty.
	// to be done immediately after testClearList()
	@Test
	public void testArrayEmpty(){
		assertTrue(al.isEmpty());
	}

	// test false is array empty
	@Test
	public void testArrayEmptyFalse(){
		al.add("cat");
		assertFalse(al.isEmpty());
	}

	// test clear elements from list that is already empty
	@Test
	public void testClearEmptyArray(){
		al.removeAll(al);
		assertFalse(al.removeAll(al));
	}
	
	//Fail test - we know adding integers to an ArrayList of
	//strings is a no no
	@Test
	public void testFailure(){
		fail();
		for(int i = 0; i < 1000; i++){
			//al.add(i);
		}
	}
}
