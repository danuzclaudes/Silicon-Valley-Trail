package a3adept;

import static org.junit.Assert.*;

import org.junit.Test;


public class ExtractedDNAStrandTest {

	@Test
	public void testExtract_CharArray() throws Exception {
		DNAStrand src = new CharArrayDNAStrand(new char[]{'A','G','C','T','A','G','G','T','A','C'});

		DNAStrand ext = new ExtractedDNAStrand(src, 1, 6); // GCTAGG

		assertEquals("GCTAG EQUAL",ext.getBaseAt(0),'G'); // T
		assertEquals("GCTAG EQUAL",ext.getBaseAt(1),'C'); // A
		assertEquals("GCTAG EQUAL",ext.getBaseAt(2),'T'); // G
		assertEquals("GCTAG EQUAL",ext.getBaseAt(3),'A'); // G

		DNAStrand ext_ext = ext.extract(1, 4); // CTAG

		assertEquals("GCTAG EQUAL",ext_ext.getBaseAt(0),'C'); // T
		assertEquals("GCTAG EQUAL",ext_ext.getBaseAt(1),'T'); // A
		assertEquals("GCTAG EQUAL",ext_ext.getBaseAt(2),'A'); // G
		assertEquals("GCTAG EQUAL",ext_ext.getBaseAt(3),'G'); // G

	}
	@Test
	public void testExtract_CharArray2() throws Exception {
		DNAStrand src = new CharArrayDNAStrand(new char[]{'A','G','C','T','A','G','G','T','A','C'});

		DNAStrand ext = new ExtractedDNAStrand(src, 2, 5, "CTAG"); // CTAG

		assertEquals("GCTAG EQUAL",ext.getBaseAt(0),'C'); // A
		assertEquals("GCTAG EQUAL",ext.getBaseAt(1),'T'); // G
		assertEquals("GCTAG EQUAL",ext.getBaseAt(2),'A'); // G

		DNAStrand ext_ext = ext.extract(1, 2); // TA

		assertEquals("GCTAG EQUAL",ext_ext.getBaseAt(0),'T'); // T
		assertEquals("GCTAG EQUAL",ext_ext.getBaseAt(1),'A'); // A

	}

	@Test
	public void testExtract_String() throws Exception {
		DNAStrand src = new StringDNAStrand("AGCTAGGTAC");

		DNAStrand ext = new ExtractedDNAStrand(src, 2, 5, "CTAG"); // CTAG

		assertEquals("GCTAG EQUAL",ext.getBaseAt(0),'C'); // A
		assertEquals("GCTAG EQUAL",ext.getBaseAt(1),'T'); // G
		assertEquals("GCTAG EQUAL",ext.getBaseAt(2),'A'); // G

		DNAStrand ext_ext = ext.extract(1, 2); // TA

		assertEquals("GCTAG EQUAL",ext_ext.getBaseAt(0),'T'); // T
		assertEquals("GCTAG EQUAL",ext_ext.getBaseAt(1),'A'); // A

	}

	@Test
	public void testJoin_CharArray() throws Exception {
		DNAStrand src = new CharArrayDNAStrand(new char[]{'A','G','C','T','A','G','G','T','A','C'});

		DNAStrand ext = new ExtractedDNAStrand(src, 1, 6); // GCTAGG

		DNAStrand tail = new CharArrayDNAStrand(new char[]{'T','A','C'});

		DNAStrand ext_tail = ext.join(tail); // GCTAGGTAC

		assertEquals("GCTAG EQUAL",ext_tail.getBaseAt(0),'G'); // T
		assertEquals("GCTAG EQUAL",ext_tail.getBaseAt(1),'C'); // A
		assertEquals("GCTAG EQUAL",ext_tail.getBaseAt(2),'T'); // T
		assertEquals("GCTAG EQUAL",ext_tail.getBaseAt(3),'A'); // A
		assertEquals("GCTAG EQUAL",ext_tail.getBaseAt(4),'G'); // A
		assertEquals("GCTAG EQUAL",ext_tail.getBaseAt(5),'G'); // T
		assertEquals("GCTAG EQUAL",ext_tail.getBaseAt(6),'T'); // A
		assertEquals("GCTAG EQUAL",ext_tail.getBaseAt(7),'A'); // T
		assertEquals("GCTAG EQUAL",ext_tail.getBaseAt(8),'C'); // A

	}

	@Test
	public void testJoin_String() throws Exception {
		DNAStrand src = new StringDNAStrand("AGCTAGGTAC");

		DNAStrand ext = new ExtractedDNAStrand(src, 2, 5, "CTAG"); // CTAG

		assertEquals("GCTAG EQUAL",ext.getBaseAt(0),'C'); // A
		assertEquals("GCTAG EQUAL",ext.getBaseAt(1),'T'); // G
		assertEquals("GCTAG EQUAL",ext.getBaseAt(2),'A'); // G

		DNAStrand ext_ext = ext.extract(1, 2); // TA

		assertEquals("GCTAG EQUAL",ext_ext.getBaseAt(0),'T'); // T
		assertEquals("GCTAG EQUAL",ext_ext.getBaseAt(1),'A'); // A

	}
	
	@Test
	public void testJoin_JOIN() throws Exception {
		DNAStrand src = new StringDNAStrand("AGCTAGGTAC");

		DNAStrand ext = new ExtractedDNAStrand(src, 2, 5, "CTAG"); // CTAG

		DNAStrand sds1 = new CharArrayDNAStrand( new char[]{'A','G','C','T','A'});
		DNAStrand sds2 = new CharArrayDNAStrand( new char[]{'G','G','T','A','C'});
		DNAStrand tail = new JoinedDNAStrand(sds1, sds2);
		
		DNAStrand test = ext.join(tail); // CTAG 'A','G','C','T','A' 'G','G','T','A','C'

		assertEquals("GCTAG EQUAL",test.getBaseAt(0),'C'); // T
		assertEquals("GCTAG EQUAL",test.getBaseAt(1),'T'); // A
		assertEquals("GCTAG EQUAL",test.getBaseAt(2),'A'); // T
		assertEquals("GCTAG EQUAL",test.getBaseAt(3),'G'); // A
		assertEquals("GCTAG EQUAL",test.getBaseAt(4),'A'); // T
		assertEquals("GCTAG EQUAL",test.getBaseAt(5),'G'); // A
		assertEquals("GCTAG EQUAL",test.getBaseAt(6),'C'); // T
		assertEquals("GCTAG EQUAL",test.getBaseAt(7),'T'); // A
		assertEquals("GCTAG EQUAL",test.getBaseAt(8),'A'); // T
		assertEquals("GCTAG EQUAL",test.getBaseAt(9),'G'); // A
		assertEquals("GCTAG EQUAL",test.getBaseAt(10),'G'); // T
		assertEquals("GCTAG EQUAL",test.getBaseAt(11),'T'); // A
		assertEquals("GCTAG EQUAL",test.getBaseAt(12),'A'); // T
		assertEquals("GCTAG EQUAL",test.getBaseAt(13),'C'); // A
		

	}
}
