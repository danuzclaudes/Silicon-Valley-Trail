package a3novice;

/**
 * Abstraction for representing strands of DNA 
 * as a sequence of "bases".
 * CharArrayDNAStrand encapsulates a char 
 * array to represent the strand bases
 * 
 * @author danuzclaudes
 *
 */
public class CharArrayDNAStrand implements DNAStrand {
	private char[] bases;
	private String name;
	
	public CharArrayDNAStrand(char[] base_array, String name) {
		/* Your code here. */
		/* check inputs validity*/
		for(char c : base_array){
			if (c!='C' && c!='G' && c!='T' && c!='A') 
				throw new RuntimeException("Illegal");
		}
		this.bases = base_array;
		this.name = name;
	}
	
	public CharArrayDNAStrand(char[] base_array) {
		/* Your code here. */
		this(base_array, "Unnamed");
	}
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = (name==null)?"Unnamed":name;
	}

	public char getBaseAt(int idx) {
		/* check inputs validity*/
		if( idx<0 || idx>=this.getLength() ) 
			throw new RuntimeException("Illegal");
		return bases[idx];
	}

	public int getLength() {
		return this.bases.length;
	}

	public DNAStrand extract(int start, int end) {
		if(start<0 || start>end || end>=this.getLength()) 
			throw new RuntimeException("Illegal");
		char[] new_bases = new char[end-start+1];
		for(int i = 0; i <= end-start; i++) 
			new_bases[i] = this.getBaseAt(start+i);
		return new CharArrayDNAStrand(new_bases, "Unnamed");
	}

	/**
	 * Join two Strand and return a new CharArrayDNAStrand
	 */
	public DNAStrand join(DNAStrand tail) {
		if(tail == null) 
			throw new RuntimeException("Illegal");
		char[] new_bases = new char[this.getLength()+tail.getLength()];
		for(int i = 0; i < this.getLength(); i++){
			new_bases[i] = this.getBaseAt(i);
		}
		for(int j = 0; j < tail.getLength(); j++){
			new_bases[this.getLength()+j] = tail.getBaseAt(j);
		}
		return new CharArrayDNAStrand(new_bases, "Unnamed");
	}

}
