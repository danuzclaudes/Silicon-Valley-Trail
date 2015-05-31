package a3adept;

public class ExtractedDNAStrand implements DNAStrand {

	private DNAStrand source_strand;
	private String name;
	private int start;
	private int end;
	
	public ExtractedDNAStrand(
			DNAStrand source_strand, 
			int start, int end, String name) {
		/* Your code here. */
		if(	source_strand == null 
				|| start<0 || end>=source_strand.getLength() 
				|| start > end) 
			throw new RuntimeException("Illegal");
		this.source_strand = source_strand;
		this.start = start;
		this.end = end;
		this.name = name;
	}

	public ExtractedDNAStrand(
			DNAStrand source_strand, 
			int start, int end) {
		/* Your code here. */
		this(source_strand, start, end, "Unnamed");
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
		if(idx < 0|| idx > end-start) 
			throw new RuntimeException("Illegal");
		return this.source_strand.getBaseAt(idx+start);
	}

	public int getLength() {
		/* Your code here. */
		return end-start+1;
	}

	public DNAStrand extract(int start, int end) {
		/* Your code here. */
		/* check inputs validity*/ 
		if( start<0 || start>end || end>this.end-this.start ) 
			throw new RuntimeException("Illegal");
		return new ExtractedDNAStrand(source_strand, 
				start+this.start, end+this.start);
	}

	public DNAStrand join(DNAStrand tail) {
		/* Your code here. */
		if(tail == null) 
			throw new RuntimeException("Illegal");
		return new JoinedDNAStrand(this, tail);
	}
}