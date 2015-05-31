package a3jedi;

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
		return new ExtractedDNAStrand(this, start, end);
	}

	public DNAStrand join(DNAStrand tail) {
		if(tail == null) throw new RuntimeException("Illegal");
		
		return new JoinedDNAStrand(this, tail, "Unnamed");
	}

	public int findSubstrand(DNAStrand substrand) {
		int len = substrand.getLength();
		for(int i=0; i<=this.getLength()-len; i++){
			boolean matched = true;
			for(int j=0; j<len; j++){
				if(this.getBaseAt(i+j) != substrand.getBaseAt(j)){
					matched = false;
					break;
				}
			}
			if(matched) return i;
		}
		return -1;
	}

	public int findSubstrand(DNAStrand substrand, int search_start_position) {
		int len = substrand.getLength();
		for(int i=search_start_position; i<=this.getLength()-len; i++){
			boolean matched = true;
			for(int j=0; j<len; j++){
				if(this.getBaseAt(i+j) != substrand.getBaseAt(j)){
					matched = false;
					break;
				}
			}
			if(matched) return i;
		}
		return -1;
	}

}
