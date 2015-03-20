package a3jedi;

import static org.junit.Assert.*;

import org.junit.Test;


public class JoinedDNAStrandTest {

	@Test
	public void testFind() {
		DNAStrand sds1 = new StringDNAStrand("AGCTA");
		DNAStrand sds2 = new StringDNAStrand("GGTAC");
		JoinedDNAStrand join = new JoinedDNAStrand(sds1, sds2); 
	}

}
