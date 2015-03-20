package a2;

public class Rectangle {

	// These are the object fields
	// that represent the bottom left and upper right
	// corners of the rectangle and the rectangle's
	// label.
	//
	// Do not change the declaration of these fields.
	// Do not add any additional fields.

	private Point bottom_left;
	private Point upper_right;	
	private String label;
	
	
	// This is the constructor for a Rectangle object.
	// It requires the x and y coordinates of two points
	// for opposite corners of the rectangle. The coordinates
	// as given may or may not be the bottom left and upper right
	// corners (you'll have to check and adust as necessary). 
	// It also takes a String l that should be the rectangle's
	// label.
	// Complete the constructor to initialize
	// the rectangle's fields as appropriate.
	public Rectangle(int x1, int y1, int x2, int y2, String l) {

		/* Your code here. */
		bottom_left = new Point(Math.min(x1, x2), Math.min(y1, y2));
		upper_right = new Point(Math.max(x1, x2), Math.max(y1, y2));
		label = l;

	}
	
	// This method should return the label
	// for the rectangle.
	public String getLabel() {
		
		/* Your code here. */
		return label;
	}
	
	// This method should return the x-coordinate of the
	// rectangle's left side.
	public int getLeft() {

		/* Your code here. */
		return this.bottom_left.getX();
	}
	
	// This method should return the x-coordinate of the
	// rectangle's right side.
	public int getRight() {

		/* Your code here. */
		return upper_right.getX();
	}

	// This method should return the y-coordinate of the
	// rectangle's top side.
	public int getTop() {

		/* Your code here. */
		return upper_right.getY();
	}
	
	// This method should return the y-coordinate of the
	// rectangle's bottom side.
	public int getBottom() {

		/* Your code here. */
		return bottom_left.getY();
	}
	
	// This method should return the width of the rectangle.
	public int getWidth() {

		/* Your code here. */
		return this.getRight() - this.getLeft();

	}
	
	// This method should return the height of the rectangle.
	public int getHeight() {

		/* Your code here. */
		return this.getTop() - this.getBottom();
	}
	
	// This method should return the area of the rectangle.
	public int getArea() {

		/* Your code here. */
		return this.getWidth() * this.getHeight();
	}
	
	// This method should return the perimeter of the rectangle.
	public int getPerimeter() {

		/* Your code here. */
		return 2*(this.getWidth() + this.getHeight());
	}
	
	// This method should return a new Rectangle object
	// that is the same size as the rectangle but
	// translated by dx in the x-direction and dy in
	// the y-direction.
	public Rectangle translate(int dx, int dy) {

		/* Your code here. */
//		public Rectangle(int x1, int y1, int x2, int y2, String l)
		return new Rectangle(this.getLeft() + dx, this.getBottom() + dy,
							 this.getRight()+ dx, this.getTop()    + dy,
							 this.getLabel()+"_translation");
	}
	
	// This method should test the given Point p
	// for being inside the rectangle. Note that
	// a point on the edge of a rectangle is NOT inside.
	public boolean testPoint(Point p) {

		/* Your code here. */
		return p.getX() > this.getLeft() && p.getX() < this.getRight()
				&& p.getY() > this.getBottom() && p.getY() < this.getTop();
	}
	
	// This method should test the given Rectangle r
	// for having the same geometry (i.e., same 
	// coordinates for top/bottom/left/right).
	public boolean equals(Rectangle r) {

		/* Your code here. */
		return  this.getTop()    == r.getTop()    &&
				this.getBottom() == r.getBottom() &&
				this.getLeft()   == r.getLeft()   &&
				this.getRight()  == r.getRight();
	}
	
	// This method should test the given Rectangle r
	// for intersection with the rectangle. 
	public boolean intersects(Rectangle r) {

		/* Your code here. */
		return !(r.getLeft()  >= this.getRight() ||
				 r.getTop()   <= this.getBottom()||
				 r.getRight() <= this.getLeft()  ||
				 r.getBottom()>= this.getTop());
	}
	
	// This method should test whether the 
	// rectangle is taller than it is wide.
	public boolean isTall() {

		/* Your code here. */
		return this.getHeight() > this.getWidth();
	}
	
	// This method should test whether the
	// rectangle is wider than it is tall.
	public boolean isWide() {

		/* Your code here. */
		return this.getHeight() < this.getWidth();
	}
	
	// This method should test whether the
	// rectangle is a square.
	public boolean isSquare() {

		/* Your code here. */
		return this.getWidth() == this.getHeight();
	}
}

