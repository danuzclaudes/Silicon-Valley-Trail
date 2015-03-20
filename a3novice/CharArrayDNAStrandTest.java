package a3novice;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.util.Arrays;

import org.junit.Test;

public class CharArrayDNAStrandTest {

	@Test
	public void testConstructor() throws Exception {
		char[] ag = new char[]{'A','G'};
		CharArrayDNAStrand sds = new CharArrayDNAStrand(ag);
//		Field field = Rectangle.class.getDeclaredField("bottom_left");
//        field.setAccessible(true);
//        Point value = (Point) field.get(uut);
//		assertEquals("Bottom left x cord:", value.getX(), 0);
		Field field = CharArrayDNAStrand.class.getDeclaredField("bases");
		field.setAccessible(true);
		char[] value = (char[]) field.get(sds);
		assertEquals("constructor test",value,ag);
	}
	
	@Test
	public void testExtract() throws Exception {
		char[] test = {'A','G', 'C','T','A','G','G','T','A','C'};
		CharArrayDNAStrand sds = new CharArrayDNAStrand(test);
		DNAStrand ext = sds.extract(1, 7); // GCTAG
		
		Field field = CharArrayDNAStrand.class.getDeclaredField("bases");
		field.setAccessible(true);
		char[] value = (char[]) field.get(ext);
//		assertEquals("GCTAG EQUAL",value, new char[]{'G','C','T','A','G','G','T','A','C'});
		assertTrue("test extract",Arrays.equals(new char[]{'G','C','T','A','G','G','T'}, value));
	}
	
	@Test
	public void testJoin() throws Exception {
		CharArrayDNAStrand sds1 = new CharArrayDNAStrand( new char[]{'A','G','C','T','A'});
		CharArrayDNAStrand sds2 = new CharArrayDNAStrand( new char[]{'G','G','T','A','C'});
		DNAStrand jn = sds1.join(sds2); // AGCTAGGTAC
		
		Field field = CharArrayDNAStrand.class.getDeclaredField("bases");
		field.setAccessible(true);
		char[] value = (char[]) field.get(jn);
//		assertEquals("join test",value,new char[] {'A','G', 'C','T','A','G','G','T','A','C'});
		assertTrue("test extract",Arrays.equals(new char[]{'A','G', 'C','T','A','G','G','T','A','C'}, value));
	}
	
	@Test
	public void testGetBase() {
		CharArrayDNAStrand sds = new CharArrayDNAStrand(new char[]{'A','G','C','T','A'});
		
		char bs4 = sds.getBaseAt(4);
		assertTrue("test get base 4", bs4=='A');
		char bs5 = sds.getBaseAt(5);
	}
	
	@Test
	public void testName() {
		CharArrayDNAStrand sds = new CharArrayDNAStrand(new char[]{'A','G','C','T','A'});
		String name1 = sds.getName();
		assertTrue("test unamed", name1.equals("Unnamed"));
		sds.setName("MyName is na");
		assertTrue("test unamed", sds.getName().equals("MyName is na"));
	}

}
