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
}
