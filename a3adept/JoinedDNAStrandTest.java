package a3adept;

import static org.junit.Assert.*;

import org.junit.Test;



public class JoinedDNAStrandTest {

	@Test
	public void testExtract_String() throws Exception {
		DNAStrand sds1 = new StringDNAStrand("AGCTA");
		DNAStrand sds2 = new StringDNAStrand("GGTAC");
		
		JoinedDNAStrand join = new JoinedDNAStrand(sds1, sds2);
		
		DNAStrand join_ext = join.extract(1, 5); // GCTAG
		
		assertEquals("GCTAG EQUAL",join_ext.getBaseAt(0),'G');
		assertEquals("GCTAG EQUAL",join_ext.getBaseAt(1),'C');
		assertEquals("GCTAG EQUAL",join_ext.getBaseAt(2),'T');
		assertEquals("GCTAG EQUAL",join_ext.getBaseAt(3),'A');
		assertEquals("GCTAG EQUAL",join_ext.getBaseAt(4),'G');
//		assertEquals("GCTAG EQUAL",join_ext.getBaseAt(5),'G');
		
		
	}
	
	@Test
	public void testExtract_CharArray() throws Exception {
		CharArrayDNAStrand sds1 = new CharArrayDNAStrand( new char[]{'A','G','C','T','A'});
		CharArrayDNAStrand sds2 = new CharArrayDNAStrand( new char[]{'G','G','T','A','C'});
		
		JoinedDNAStrand join = new JoinedDNAStrand(sds1, sds2);
		
		DNAStrand join_ext = join.extract(6, 9); 
		assertEquals("GCTAG EQUAL",join_ext.getBaseAt(0),'G');
		assertEquals("GCTAG EQUAL",join_ext.getBaseAt(1),'T');
		assertEquals("GCTAG EQUAL",join_ext.getBaseAt(2),'A');
		assertEquals("GCTAG EQUAL",join_ext.getBaseAt(3),'C');
//		assertEquals("GCTAG EQUAL",join_ext.getBaseAt(4),'G');
//		assertEquals("GCTAG EQUAL",join_ext.getBaseAt(5),'G');
		
	}
	
	@Test
	public void testExtract_EXTRACT() throws Exception {
		DNAStrand src = new CharArrayDNAStrand(new char[]{'A','G','C','T','A','G','G','T','A','C'});

		DNAStrand ext1 = new ExtractedDNAStrand(src, 1, 6); // GCTAGG
		DNAStrand ext2 = new ExtractedDNAStrand(src, 5, 7); // GGT
		
		DNAStrand EXT_ext = ext1.join(ext2); // GCTAGGGGT
		
		assertEquals("GCTAG EQUAL",EXT_ext.getBaseAt(0),'G');
		assertEquals("GCTAG EQUAL",EXT_ext.getBaseAt(1),'C');
		assertEquals("GCTAG EQUAL",EXT_ext.getBaseAt(2),'T');
		assertEquals("GCTAG EQUAL",EXT_ext.getBaseAt(3),'A');
		assertEquals("GCTAG EQUAL",EXT_ext.getBaseAt(4),'G');
		assertEquals("GCTAG EQUAL",EXT_ext.getBaseAt(5),'G');
		assertEquals("GCTAG EQUAL",EXT_ext.getBaseAt(6),'G');
		assertEquals("GCTAG EQUAL",EXT_ext.getBaseAt(7),'G');
		assertEquals("GCTAG EQUAL",EXT_ext.getBaseAt(8),'T');
	}
	
	
	
	@Test
	public void testJoin_String() throws Exception {
		DNAStrand sds1 = new StringDNAStrand("AGCTA");
		DNAStrand sds2 = new StringDNAStrand("GGTAC");
		
		JoinedDNAStrand join = new JoinedDNAStrand(sds1, sds2);
		
		DNAStrand test_tail = new CharArrayDNAStrand( new char[]{'A','G','C','T','A'});

		DNAStrand join_ext = join.join(test_tail); 
		
		assertEquals("GCTAG EQUAL",join_ext.getBaseAt(0),'A');
		assertEquals("GCTAG EQUAL",join_ext.getBaseAt(4),'A');
		assertEquals("GCTAG EQUAL",join_ext.getBaseAt(5),'G');
		assertEquals("GCTAG EQUAL",join_ext.getBaseAt(9),'C');
		assertEquals("GCTAG EQUAL",join_ext.getBaseAt(10),'A');
		assertEquals("GCTAG EQUAL",join_ext.getBaseAt(14),'A');
		
		
		assertEquals("length", join_ext.getLength(), 15);
		
	}
	@Test
	public void testJoin_CharArray() throws Exception {
		CharArrayDNAStrand sds1 = new CharArrayDNAStrand( new char[]{'A','G','C','T','A'});
		CharArrayDNAStrand sds2 = new CharArrayDNAStrand( new char[]{'G','G','T','A','C'});
		
		JoinedDNAStrand join = new JoinedDNAStrand(sds1, sds2);
		
		DNAStrand test_tail = new StringDNAStrand("AGCTC");
		
		DNAStrand join_ext = join.join(test_tail); // GCT
		
		assertEquals("GCTAG EQUAL",join_ext.getBaseAt(0),'A');
		assertEquals("GCTAG EQUAL",join_ext.getBaseAt(4),'A');
		assertEquals("GCTAG EQUAL",join_ext.getBaseAt(5),'G');
		assertEquals("GCTAG EQUAL",join_ext.getBaseAt(9),'C');
		assertEquals("GCTAG EQUAL",join_ext.getBaseAt(10),'A');
		assertEquals("GCTAG EQUAL",join_ext.getBaseAt(14),'C');
		
	}
	

	
}
