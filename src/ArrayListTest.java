import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.sun.corba.se.impl.orbutil.graph.Node;

public class ArrayListTest {
	
	ArrayList<String> al = null;
	
	@Mock
	HashMap<Integer, String> mockMap = Mockito.mock(HashMap.class);
	
	@Before
	public void setUp() throws Exception{
		al = new ArrayList<String>();
		MockitoAnnotations.initMocks(mockMap);
	}
	
	//1. The ArryaList was initialized to empty, so its contents should not be null.
	@Test
	public void testNotNull(){
		assertNotNull(al);
	}
	
	//2. An ArrayList should always equal itself
	@Test
	public void testEqualsItself(){
		assertEquals(al, al);
	}
	
	//3. Two empty ArrayLists should be equal.
	//Create two empty ArrayLists.
	//They should be equal to each other.
	@Test
	public void testEmptyEquals(){
		ArrayList<String> al2 = new ArrayList<String>();
		assertEquals(al, al2);
	}
	
	//4. Two ArrayLists that had the same values added in the same order should be equal.
	//Create two ArrayLists and initialize them with the same values
	//The arrays should be equal;
	@Test
	public void testNonEmptyEquals(){
		ArrayList<String> al2 = new ArrayList<String>();
		
		al.add("1");
		al.add("2");
		al2.add("1");
		al2.add("2");
		
		assertEquals(al, al2);
	}
	
	//5. Two ArrayLists of different values should never be equal
	//Create a second ArrayList and add values X, Y, and Z; these values 
	//should not be the same as the values in the first ArrayList.
	//The two ArrayLists should not be equal.
	@Test
	public void testNotEqual(){
		ArrayList<String> al2 = new ArrayList<String>();
		
		al2.add("1");
		al2.add("Bob");
		al2.add("Blue42");
		
		assertFalse(al.equals(al2));
	}
	
	//6. An ArrayList with items should have a size greater than zero.
	//Add at least one item to ArrayList al.
	//The ArrayList size should be greater than zero.
	@Test
	public void testGreaterThanZero(){
		al.add("Brett");
		al.add("Allison");
		al.add("0");
		al.add("2");
		
		assertTrue(al.size() > 0);
	}
	
	//7. An ArrayList with items X, Y, and Z added should contain
	//items X, Y, and Z.
	//This test checks the boundary values: First Item and Last Item
	@Test
	public void testNonEmptyExist(){
		ArrayList<Integer> al3 = new ArrayList<Integer>();
		
		for(int i = 0; i < 6; i++){
			al3.add(i);
		}
		
		assertTrue(al3.get(0) != null);
		assertTrue(al3.get(al3.size()-1) != null);
	}
	
	//8. An ArryaList of type String should not accept an int type added to it.
	//Use a try/catch block for this Fail() case test.
	//This test should fail.
	@Test
	public void testAddIntToStringList(){
	
		try{
			assertFalse(al.add(2));
		}
		catch(Exception e){
			fail();
		}
	}
	
	//9. When an element, X, exists in the ArrayList, it should be able to
	// be removed.
	//Add an element, X, to the ArrayList and then remove it.
	//The element should be removed.
	@Test
	public void testRemoveElement(){
		al.add("hello");
		al.add("there");
		assertTrue(al.remove("there"));
	}

	//10. All of the elements in an ArrayList should be able to be removed at once.
	//Add at least one item to the ArrayList and then removeAll elements.
	//The ArrayList elements should all be removed.
	@Test
	public void testRemoveAll(){
		al.add("hello");
		al.add("there");
		assertTrue(al.removeAll(al));
	}

	//11. An element that does not exist in the ArrayList should not be able 
	// to be removed.
	//Try to remove a unique element from the ArrayList that you know for
	// certain does not exist in the array.
	//The element should not be able to be removed.
	@Test
	public void testRemoveBadElement(){
		assertFalse(al.remove("beepbeepbeep"));
	}

	//12. Two ArrayLists should refer to the same ArrayList.
	//Create two ArrayLists.
	//Both ArrayLists should be the same.
	@Test
	public void testNotSameArrayList(){
		ArrayList<String> al2 = new ArrayList<String>();
		ArrayList<String> al3 = new ArrayList<String>();
		assertNotSame(al2, al3);
	}
	
	//13. Two ArrayLists initialized to the same values should be equal.
	//Create two arrays and add the same value to each of them.
	//The ArrayLists should be equal to each other.
	@Test
	public void testEqualALists(){
		ArrayList<String> al2 = new ArrayList<String>();
		ArrayList<String> al3 = new ArrayList<String>();
		al2.add("fun");
		al3.add("fun");
		assertEquals(al2, al3);
	}

	//14. An array with element X added to it should return the element X.
	//Add an element, X, to the array.
	//The element should contain element X.
	@Test
	public void testArrayContains(){
		al.add("dog");
		assertTrue(al.contains("dog"));
	}

	//15. An ArrayList that does not contain an element, X, should return that
	// it does contain X. 
	//Ensure that an element is not in the ArrayList, and try to see if the 
	// ArrayList contains the element.
	//The ArrayList should not contain the element X since it does not exist in the
	// array.
	@Test
	public void testArrayContainsFog(){
		assertFalse(al.contains("fog"));
	}

	//16. An ArryaList of type String should not contain any elements of type int.
	//Use a try/catch block for this Fail() case test.
	//This test should fail.
	@Test
	public void testFailContains(){
		//al = new ArrayList<String>();
		try{
			assertTrue(al.contains(100));
		} 
		catch(Exception e){
			fail();
		}
		
	}

	//17. An array that is cleared should be empty.
	//Clear the ArrayList.
	//The ArrayList should be empty.
	@Test
	public void testArrayEmpty(){
		al.clear();
		assertTrue(al.isEmpty());
	}

	//18. An ArryaList with at least one element should not be empty.
	//Add at least one element to the ArrayList.
	//The ArrayList should not be empty.
	@Test
	public void testArrayEmptyFalse(){
		al.add("cat");
		assertFalse(al.isEmpty());
	}

	//19. An ArrayList that is empty should not be able to have all of its
	// elements removed.
	//Remove all of the elements from an ArrayList that contains no
	// elements.
	//The "elements" should not be able to be removed, since there are no
	// elements in the ArrayList.
	@Test
	public void testClearEmptyArray(){
		al.removeAll(al);
		assertFalse(al.removeAll(al));
	}
	
	// Mock and Stub section
	// Mocking an ArrayList may be very hard, so you told us
	// we could mock another object to prove to you that we 
	// understand the purpose of mocks

	//20. Test putting mock nodes in a Hashmap works
	@Test
	public void testMockPut(){
		HashMap<Node, Node> map = new HashMap<Node, Node>();
		
		Node mockString = Mockito.mock(Node.class);
		Node mockInt = Mockito.mock(Node.class);
		
		map.put(mockInt, mockString);
	}
	
	//20. test getting a mock value that is in the map works
	@Test
	public void testMockGet(){
		HashMap<Node, Node> map = new HashMap<Node, Node>();
		
		Node mockKey = Mockito.mock(Node.class);
		Node mockValue = Mockito.mock(Node.class);
		
		map.put(mockKey, mockValue);
		map.get(mockKey);
	}
	
	//22. test removing mock object
	@Test
	public void testMockRemove(){
		HashMap<Node, Node> map = new HashMap<Node, Node>();
		
		Node mockKey = Mockito.mock(Node.class);
		Node mockValue = Mockito.mock(Node.class);
		
		map.put(mockKey, mockValue);
		map.remove(mockKey);
	}
	
	// Stubbing the HashMap method isEmpty
	// We're using the Mockito testing framework to do so
	
	//23. We know that an empty Hashmap will return true when isEmpty() is
	// called ... so we're returning true automatically for this empty
	// mock HashMap
	@Test
	public void testIsEmpty(){
		HashMap<Node, Node> map = Mockito.mock(HashMap.class);
	
		Mockito.when(map.isEmpty()).thenReturn(true);
	}
	
	//24. A mock HashMap that had a key-value pair put in it
	// will contain that key
	@Test
	public void testContainsKey(){
		HashMap<Node, Node> map = Mockito.mock(HashMap.class);
		
		Node mockKey = Mockito.mock(Node.class);
		Node mockValue = Mockito.mock(Node.class);
		map.put(mockKey, mockValue);
		
		Mockito.when(map.containsKey(mockKey)).thenReturn(true);
	}
	
	//25. A mock HashMap that had a key-value pair put in it
	// will contain that value
	@Test
	public void testContainsValue(){
		HashMap<Node, Node> map = Mockito.mock(HashMap.class);
		
		Node mockKey = Mockito.mock(Node.class);
		Node mockValue = Mockito.mock(Node.class);
		map.put(mockKey, mockValue);
		
		Mockito.when(map.containsValue(mockValue)).thenReturn(true);
	}
	
	//26. An empty mock HashMap should have a size of 0
	@Test
	public void testMapSize(){
		HashMap<Node, Node> map = Mockito.mock(HashMap.class);
		
		Mockito.when(map.size()).thenReturn(0);
	}
	
	//27. An ArrayList with x items should have a size of x items
	@Test
	public void testSize(){
		al = new ArrayList<String>();
		
		al.add("Brett");
		al.add("Allison");
		al.add("Scruffy");
		
		assertTrue(al.size() == 3);
	}
	
	//28. Test that the lastIndexOf method returns the correct index
	// If x items are in the list, and the method is called
	// on the xth item, then it should return x-1
	@Test
	public void testLastIndexOf(){
		al = new ArrayList<String>();
		
		al.add("Philadelphia");
		al.add("Pittsburgh");
		al.add("Pennsylvania");
		
		assertTrue(al.lastIndexOf("Pennsylvania") == 2);
	}

	//29. Two arraylists that refer to the same object (arraylist) should be the same
	@Test
	public void testSameArrayList(){
		ArrayList<String> al2 = new ArrayList<String>();
		ArrayList<String> al3 = al2;
		assertSame(al2, al3);
	}
	
	//30. An ArrayList that has been declared and initialized to null should be null
	@Test
	public void testNull(){
		ArrayList<String> list = null;
		assertNull(list);
	}
	
}
