/*
 * Recitation 3 JUNIT Testing of Assignment 2 Rectangle Class
 * 
 * 
 * @Author : KJ Moon, Brian Cristante, & Patrick Artman
 * Written expressly for COMP 401 Spring 2015 w/ Dr. Ketan Mayer-Patel
 * 
 * In this recitation, we will learn how to create and run JUnit Tests.
 * This is very important as testing your product is smart, responsible, and
 * it's may one day save lives. 
 * 
 * Please read the method headers below as they will detail what each test
 * tests for and what you need to fill in.
 * 
 * Happy hunting! (for bugs)
 */


package a2;

import static org.junit.Assert.*;

import java.lang.reflect.Field;

import org.junit.Assert;
import org.junit.Test;

import a2.*;

public class JUnitRectangleTest {

	
	/*
	 * testConstructorBottom_leftCase1():
	 * 
	 * In this test case we will test the constructor's ability to properly assign
	 * the coordinates to bottom_left if the first set of points is less than the
	 * second set of points.
	 * 
	 * That is (x1,y1) <  (x2, y2)
	 * 
	 * 
	 * WARNING: Your getLeft and getBottom methods must be implemented.
	 */
	
	@Test
	public void testConstructorBottom_leftCase1() {
		//We create a new instance of the Rectangle object with sample inputs (0, 0, 10, 10, "uut")
		Rectangle uut = new Rectangle(0, 0, 10, 10,  "uut");
		
		//FORMAT: assertEquals( "Message, which is optional", Expected, Actual)
		//Test if X1 is 0.
		assertEquals("Constructor Case 1 X1 value:", 0, uut.getLeft());
		//Test if Y1 is 0.
		assertEquals("Constructor Case 1 Y1 value:", 0, uut.getBottom());

	}
	
	/*
	 * testConstructorUpper_rightCase1():
	 * 
	 * In this test case we will test the constructor's ability to properly assign
	 * the coordinates to upper_right if the first set of points is less than the
	 * second set of points.
	 * 
	 * That is (x1,y1) <  (x2, y2)
	 * 
	 */
	
	@Test
	public void testConstructorUpper_rightCase1() {
		Rectangle uut = new Rectangle(0, 0, 10, 10,  "uut");
		//Test if X2 is 10
		assertEquals("Constructor Case 1 X2 value:", 10, uut.getRight());
		//Test if Y2 is 10
		assertEquals("Constructor Case 1 Y2 value:", 10, uut.getTop());

	}
	
	
	
	/* TODO:
	 * testConstructorBottom_leftCase2():
	 * 
	 * In this test case we will test the constructor's ability to properly assign
	 * the coordinates to bottom_left if the first set of points is GREATER than the
	 * second set of points.
	 * 
	 * That is (x1,y1) >  (x2, y2)
	 * 
	 */
	
	
	@Test
	public void testConstructorBottom_leftCase2() {
		Rectangle uut = new Rectangle(10, 10, 0, 0,  "uut");
		assertEquals("Constructor Case 2 X1 value:", 0, uut.getLeft());
		assertEquals("Constructor Case 2 Y1 value:", 0, uut.getBottom());

	}
	
	/* TODO:
	 * testConstructorUpper_rightCase2():
	 * 
	 * In this test case we will test the constructor's ability to properly assign
	 * the coordinates to upper_right if the first set of points is GREATER than the
	 * second set of points.
	 * 
	 * That is (x1,y1) >  (x2, y2)
	 * 
	 */
	
	
	@Test
	public void testConstructorUpper_rightCase2() {
		
		
		Rectangle uut = new Rectangle(10, 10, 0, 0,  "uut");
		assertEquals("Constructor Case 2 X2 value:", 10, uut.getRight());
		assertEquals("Constructor Case 2 Y2 value:", 10, uut.getTop());

	}
	
	
	
	/* TODO:
	 * testConstructorBottom_leftCase3():
	 * 
	 * In this test case we will test the constructor's ability to properly assign
	 * the coordinates to bottom_left points are given as bottom_right and upper_left.
	 * 
	 * That is (x1 > x2) && (y1 < y2)
	 * Ex. Rectangle (0, 10, 10, 0, "uut");
	 */
	
	
	@Test
	public void testConstructorBottom_leftCase3() {
		Rectangle uut = new Rectangle(0, 10, 10, 0,  "uut");
		assertEquals("Constructor Case 3 X1 value:", 0, uut.getLeft());
		assertEquals("Constructor Case 3 Y1 value:", 0, uut.getBottom());

	}
	
	/* TODO:
	 * testConstructorUpper_rightCase3():
	 * 
	 * In this test case we will test the constructor's ability to properly assign
	 * the coordinates to upper_right points are given as bottom_right and upper_left.
	 * 
	 * That is (x1 > x2) && (y1 < y2)
	 * Ex. Rectangle (0, 10, 10, 0, "uut");
	 * 
	 */
	
	@Test
	public void testConstructorUpper_rightCase3() {
		Rectangle uut = new Rectangle(0, 10, 10, 0,  "uut");
		assertEquals("Constructor Case 3 X2 value:", 10, uut.getRight());
		assertEquals("Constructor Case 3 Y2 value:", 10, uut.getTop());

	}
	
	/*
	 * TODO:
	 * testConstructorLabelAndGetter():
	 * 
	 * This tests to make sure that the label has been properly set and
	 * that the getter for it returns the right label.
	 * 
	 */
	
	
	@Test
	public void testConstructorLabelAndGetter() {
		Rectangle uut = new Rectangle(0, 0, 10, 10, "uut");
		assertEquals("Rectangle name", "uut", uut.getLabel());
	}
	
	/*
	 * TODO:
	 * 
	 * testGetWidth():
	 * 
	 * Check if getWidth() properly returns the correct width value.
	 * 
	 */
	
	@Test
	public void testGetWidth() {
		Rectangle uut = new Rectangle(0, 0, 10, 10, "uut");
		assertEquals("Rectangle Width", 10, uut.getWidth());
	}
	
	/*
	 * TODO:
	 * 
	 * testGetHeight():
	 * 
	 * Check if getHeight returns correct value.
	 * 
	 */
	
	@Test
	public void testGetHeight() {
		Rectangle uut = new Rectangle(0, 0, 10, 10, "uut");
		assertEquals("Rectangle height", 10, uut.getHeight());
		
		
	}
	
	
	/*
	 * TODO:
	 * 
	 * testGetArea():
	 * 
	 * Check if getArea returns correct value.
	 * 
	 */
	
	@Test
	public void testGetArea() {
		Rectangle uut = new Rectangle(0, 0, 5, 12, "uut");
		assertEquals("Rectangle height", 60, uut.getArea());
		
		
	}
	
	
	/* TODO:
	 * 
	 * testGetPerimeter():
	 * 
	 * Check if getPerimeter returns the correct value.
	 */
	
	@Test
	public void testGetPrimeter() {
		Rectangle uut = new Rectangle(0, 0, 5, 12, "uut");
		assertEquals("Rectangle perimeter", 34, uut.getPerimeter());
	}
	
	/*
	 * TODO:
	 * 
	 * testTranslate()
	 * 
	 * Test if the rectangle has been properly translated!
	 * 
	 * 
	 */
	
	@Test
	public void testTranslate() {
		Rectangle toBeTranslated = new Rectangle(0, 0, 10, 10, "toBeTranslated");
		
		
		Rectangle translated = toBeTranslated.translate(10, 10);
		
		assertEquals("Left X", 10, translated.getLeft());

		assertEquals("Left Y", 10, translated.getBottom());

		assertEquals("Right X", 20, translated.getRight());

		assertEquals("Right Y", 20, translated.getTop());
		
		
	}
	
	/*
	 * TODO:
	 * 
	 * testPointWithin():
	 * 
	 * Instantiates a rectangle and a point that is within rectangle,
	 * test if the point is in the rectangle. Expected True.
	 * 
	 * Then instantiate a point that is NOT in the rectangle and
	 * test if the point is in hte rectangle. Expected False.
	 * 
	 * 
	 */
	
	
	@Test
	public void testPointWithin() {
		
		Rectangle uutRectangle = new Rectangle(0, 0, 10, 10, "uut");
		Point uutPoint = new Point(5, 5);
		
		assertTrue("Is Point (5, 5) Within?",  uutRectangle.testPoint(uutPoint));
		uutPoint = new Point(15, 15);
		assertFalse("Is Point (15, 15) Within?", uutRectangle.testPoint(uutPoint));

		
	}
	
	/*
	 * TODO:
	 * 
	 * testEquals():
	 * 
	 * Instantiates a rectangle and another rectangle that is equal.
	 * Test if the two rectangles are equal. Expected True.
	 * 
	 * Then instantiate a rectangle that is NOT equal
	 * and test if they are equal. Expected False.
	 * 
	 * 
	 */
	
	@Test
	public void testEquals() {
		
		Rectangle uutRectangle1 = new Rectangle(0, 0, 10, 10, "uut1");
		Rectangle uutRectangle2 = new Rectangle(0, 0, 10, 10, "uut2");
		assertTrue("Equal Rectangles:", uutRectangle1.equals(uutRectangle2));
		
		Rectangle uutRectangle3 = new Rectangle(0, 0, 5, 5, "uut3");
		assertFalse("Non-Equal Rectangles:", uutRectangle1.equals(uutRectangle3));

		
		
	}
	/*
	 * TODO:
	 * 
	 * testIntersects():
	 * 
	 * Create two new rectangles that intersect. Test. Expect True.
	 * 
	 * Create a rectangle that does not intersect with the first rectangle
	 * and test if intersect. Expect False.
	 * 
	 * 
	 */
	
	@Test
	public void testIntersects() {
		//Test intersecting rectangles. Expected: True
		Rectangle uutRectangle1 = new Rectangle(5,5,10,10, "uut");
		Rectangle uutRectangle2 = new Rectangle(4,4,6,6, "uut2");
		assertTrue("Rectangle intersects:", uutRectangle1.intersects(uutRectangle2));
		
		//Test false
		Rectangle uutRectangle3 = new Rectangle(0,0,2,2, "uut3");
		assertFalse("Rectangle non-intersect:", uutRectangle1.intersects(uutRectangle3));

		
	}
	
	/*
	 * TODO:
	 * 
	 * testIsTall():
	 * 
	 * Instantiates a rectangle that is taller than wide. Test. 
	 * Expect true.
	 * 
	 * Instantiate a rectangle that is wider than tall. test.
	 * Expect false.
	 * 
	 * 
	 */
	
	@Test
	public void testIsTall() {
		Rectangle uutTall = new Rectangle(0, 0, 5, 10, "uutTall");
		assertTrue("Tall Rectangle:", uutTall.isTall());
		
		Rectangle uutWide = new Rectangle(0, 0, 10, 5, "uutWide");
		assertFalse("Wide Rectangle:", uutWide.isTall());
	}
	
	/*
	 * TODO:
	 * 
	 * testIsWide():
	 * 
	 * Instantiates a rectangle that is taller than wide. Test. 
	 * Expect false.
	 * 
	 * Instantiate a rectangle that is wider than tall. test.
	 * Expect true.
	 * 
	 */
	
	@Test
	public void testIsWide() {
		Rectangle uutTall = new Rectangle(0, 0, 5, 10, "uutTall");
		assertFalse("Tall Rectangle:", uutTall.isWide());
		
		Rectangle uutWide = new Rectangle(0, 0, 10, 5, "uutWide");
		assertTrue("Wide Rectangle:", uutWide.isWide());
	}
	
	/*
	 * TODO:
	 * 
	 * testIsSquare():
	 * 
	 * Test rectangle that is square.
	 * 
	 * Test rectangle that is not square.
	 * 
	 * 
	 */
	
	@Test
	public void testIsSquare() {
		Rectangle uutSquare = new Rectangle(0, 0, 10, 10, "uutSquare");
		assertTrue("Square Rectangle:", uutSquare.isSquare());
		Rectangle uutNotSquare = new Rectangle(0, 0, 10, 5, "uutNotSquare");
		assertFalse("NonSquare Rectangle:", uutNotSquare.isSquare());
		
	}
	
	
	
	// This is reflection magic! Using reflection we are testing the private
 //class field "bottom_left". Cool, right?!
	@Test
	public void testConstructorAssignment() throws Exception {
		Rectangle uut = new Rectangle(0, 0, 10, 10,  "uut");
		//Remember: AssertEquals( Expected, Actual)
		//assertEquals("Bottom left x cord:", uut.getLeft(), 10);
		
		Field field = Rectangle.class.getDeclaredField("bottom_left");
        field.setAccessible(true);
        Point value = (Point) field.get(uut);
		assertEquals("Bottom left x cord:", value.getX(), 0);

        
	}
	
	

}
