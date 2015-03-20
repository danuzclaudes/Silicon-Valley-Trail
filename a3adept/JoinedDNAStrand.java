package a3adept;

public class JoinedDNAStrand implements DNAStrand {

	private DNAStrand head;
	private DNAStrand tail;
	private String name;
	
	public JoinedDNAStrand(DNAStrand head, DNAStrand tail, String name) {
		/* Your code here. */
		if(head == null || tail == null) throw new RuntimeException("Illegal");
		this.head = head;
		this.tail = tail;
		this.name = name;
	}

	public JoinedDNAStrand(DNAStrand head, DNAStrand tail) {
		/* Your code here. */
		this(head, tail, "Unnamed");
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		/* Your code here. */
		this.name = (name==null)?"Unnamed":name;
	}

	public char getBaseAt(int idx) {
		/* Your code here. */
		if(idx<0 || idx>=this.getLength()) throw new RuntimeException("Illegal");
		else if(idx<head.getLength()) return head.getBaseAt(idx);
		else return tail.getBaseAt(idx-head.getLength());
	}

	public int getLength() {
		/* Your code here. */
		return head.getLength()+tail.getLength();
	}

	public DNAStrand extract(int start, int end) {
//		/* Your code here. */
		if( start<0 || start>end || end>=this.getLength() ) 
			throw new RuntimeException("Illegal");
//		if(end < head.getLength()) return head.extract(start, end);
//		else if(start>=head.getLength()) return tail.extract(start, end);
//		else return new JoinedDNAStrand(this.head.extract(start, head.getLength()-1),
//										this.tail.extract(0, end));
		return new ExtractedDNAStrand(this, start, end);
	}

	public DNAStrand join(DNAStrand tail) {
		/* Your code here. */
		if(tail == null) throw new RuntimeException("Illegal");
		return new JoinedDNAStrand(this, tail);
	}
}