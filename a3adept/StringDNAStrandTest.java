package a3adept;

import static org.junit.Assert.*;

import java.lang.reflect.Field;

import org.junit.Test;

public class StringDNAStrandTest {

	@Test
	public void testConstructor() throws Exception {
		StringDNAStrand sds = new StringDNAStrand("AG");
//		Field field = Rectangle.class.getDeclaredField("bottom_left");
//        field.setAccessible(true);
//        Point value = (Point) field.get(uut);
//		assertEquals("Bottom left x cord:", value.getX(), 0);
		Field field = StringDNAStrand.class.getDeclaredField("bases");
		field.setAccessible(true);
		String value = (String) field.get(sds);
		assertEquals("AA",value,"AG");
	}
	
	@Test
	public void testExtract() throws Exception {
		StringDNAStrand sds = new StringDNAStrand("AGCTAGGTAC");
		DNAStrand ext = sds.extract(1, 9); // GCTAG
		
		Field field = StringDNAStrand.class.getDeclaredField("bases");
		field.setAccessible(true);
		String value = (String) field.get(ext);
		assertEquals("GCTAG EQUAL",value,"GCTAGGTAC");
	}
	
	@Test
	public void testJoin() throws Exception {
		StringDNAStrand sds1 = new StringDNAStrand("AGCTA");
		StringDNAStrand sds2 = new StringDNAStrand("GGTAC");
		DNAStrand jn = sds1.join(sds2); // AGCTAGGTAC
		
		Field field = StringDNAStrand.class.getDeclaredField("bases");
		field.setAccessible(true);
		String value = (String) field.get(jn);
		assertEquals("join test",value,"AGCTAGGTAC");
		assertTrue(value.equals("AGCTAGGTAC"));
	}

}
