package a3adept;

/**
 * StringDNAStrand encapsulates a String to represent the strand bases
 * @author danuzclaudes
 *
 */
public class StringDNAStrand implements DNAStrand{
	private String bases;
	private String name;

	public StringDNAStrand(String base_string, String name) {
		/* Your code here. */
		for(char c : base_string.toCharArray()){
			if (c!='C' && c!='G' && c!='T' && c!='A') 
				throw new RuntimeException("Illegal");
		}
		this.bases = base_string;
		this.name = (name==null)?"Unnamed":name;		
	}

	public StringDNAStrand(String strand_string) {
		/* Your code here. */
		this(strand_string, "Unamed");
	}

	public String getName() {
		/* Your code here. */
		return this.name;
	}

	public void setName(String name) {
		/* Your code here. */
		this.name = (name==null)?"Unnamed":name;
	}

	public char getBaseAt(int idx) {
		/* Your code here. */
		/* check inputs validity*/ 
		if( idx<0 || idx>=this.getLength() ) 
			throw new RuntimeException("Illegal");
		return this.bases.charAt(idx);
	}

	public int getLength() {
		/* Your code here. */
		return this.bases.length();
	}

	public DNAStrand extract(int start, int end) {
		/* Your code here. */
		/* check inputs validity*/ 
		if( start<0 || start>end || end>=this.getLength() ) 
			throw new RuntimeException("Illegal");
		return new ExtractedDNAStrand(this, start, end, "Unnamed");
	}

	public DNAStrand join(DNAStrand tail) {
		/* Your code here. */
		if(tail == null) throw new RuntimeException("Illegal");
		
		return new JoinedDNAStrand(this, tail, "Unnamed");
	}
}
