package a3adept;

public class CharArrayDNAStrand implements DNAStrand {
	private char[] bases;
	private String name;
	
	public CharArrayDNAStrand(char[] base_array, String name) {
		/* Your code here. */
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
		if( idx<0 || idx>=this.getLength() ) throw new RuntimeException("Illegal");
		return bases[idx];
	}

	public int getLength() {
		return this.bases.length;
	}

	public DNAStrand extract(int start, int end) {
		if(start<0 || start>end || end>=this.getLength()) 
			throw new RuntimeException("Illegal");
		return new ExtractedDNAStrand(this, start, end);
	}

	public DNAStrand join(DNAStrand tail) {
		if(tail == null) throw new RuntimeException("Illegal");
		
		return new JoinedDNAStrand(this, tail, "Unnamed");
	}

}
