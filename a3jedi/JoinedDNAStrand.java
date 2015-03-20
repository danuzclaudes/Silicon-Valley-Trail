package a3jedi;

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
		/* Your code here. */
		if( start<0 || start>end || end>=this.getLength() ) 
			throw new RuntimeException("Illegal");

		return new ExtractedDNAStrand(this, start, end);
	}

	public DNAStrand join(DNAStrand tail) {
		/* Your code here. */
		if(tail == null) throw new RuntimeException("Illegal");
		return new JoinedDNAStrand(this, tail);
	}
	
	public int findSubstrand(DNAStrand substrand) {
		int len = substrand.getLength();
		if(len>this.getLength()) throw new RuntimeException("Illegal");
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
		if(len>this.getLength()) throw new RuntimeException("Illegal");
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