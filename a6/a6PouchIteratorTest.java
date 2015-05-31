package a6;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import supplies.*;

public class a6PouchIteratorTest {

	@Test
	public void testNameIterator() {
		Food s = new Sushi(3);
		Food b = new Burrito(10);
		Food r = new Ramen(1);
		Pouch<Food> food = new PouchImpl<Food>();
		food.add(s);
		food.add(b);
		food.add(r);

		Iterator<Supplies> nameItr = food.nameIterator();
		Supplies[] expect = new Supplies[]{b,r,s};
		Supplies[] actual = new Supplies[3];
		int i = 0;
		while(nameItr.hasNext()){
			actual[i++] = nameItr.next(); 
			System.out.println(actual[i-1].getName());
		}

		try{
			assertArrayEquals(expect, actual);
		} catch(Exception e){
			System.err.println("Error location: PouchImpl<Food>.nameIterator()");
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testAmountIterator() {
		Clothing t = new TShirt(10);
		Clothing f = new Fleece(9);
		Clothing b = new ButtonUp(100);
		Pouch<Clothing> clothing = new PouchImpl<Clothing>();
		clothing.add(t);
		clothing.add(f);
		clothing.add(b);

		Iterator<Supplies> nameItr = clothing.amountIterator();
		Supplies[] expect = new Supplies[]{b,t,f};
		Supplies[] actual = new Supplies[3];
		int i = 0;
		while(nameItr.hasNext()){
			actual[i++] = nameItr.next(); 
			System.out.println(actual[i-1].getName());
		}

		try{
			assertArrayEquals(expect, actual);
		} catch(Exception e){
			System.err.println("Error location: PouchImpl<Food>.nameIterator()");
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testWeightIterator() {
		try {
			Clothing f = new Fleece(1);
			Clothing bu = new ButtonUp(1000);
			Clothing t = new TShirt(100);
			Pouch<Clothing> clothing = new PouchImpl<Clothing>();
			clothing.add(f);
			clothing.add(bu);
			clothing.add(t);
			
			Supplies[] expected = { bu, t, f};
			Iterator<Supplies> clothingIter = clothing.weightIterator();
			Supplies[] result = new Supplies[3];
			int i = 0;
			while (clothingIter.hasNext()) {
				result[i] = clothingIter.next();
				i++;
			}

			try {
				assertArrayEquals(expected, result);
			} catch (AssertionError ae) {
				System.err.println("\n\nError location: PouchImpl<Clothing>.nameIterator()");
				ae.printStackTrace();
				fail();
			}

		} catch (Exception e) {
			System.err.println("\n\nError location: PouchImpl<Clothing>.nameIterator()");
			e.printStackTrace();
			fail();
		}
	}
}
