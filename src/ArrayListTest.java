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
	
	@Test
	public void testNotNull(){
		assertNotNull(al);
	}

}
