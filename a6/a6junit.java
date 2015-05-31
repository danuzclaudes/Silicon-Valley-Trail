package a6;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import a6.*;
import supplies.*;

public class a6junit {

	@Test
	public void foodPouchAmountIterTest() {

		try {
			Food s = new Sushi(3);
			Food b = new Burrito(10);
			Food r = new Ramen(1);
			Pouch<Food> food = new PouchImpl<Food>();
			food.add(s);
			food.add(b);
			food.add(r);
			
			Supplies[] expected = { b, s, r };
			Iterator<Supplies> foodIter = food.amountIterator();
			Supplies[] result = new Supplies[3];
			int i = 0;
			while (foodIter.hasNext()) {
				result[i] = foodIter.next();
				i++;
			}
			
			try {
				assertArrayEquals(expected, result);
			} catch (AssertionError ae) {
				System.err.println("Error location: PouchImpl<Food>.amountIterator()");
				ae.printStackTrace();
				fail();
			}

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void foodPouchWeightIterTest() {

		try {
			Food s = new Sushi(1);
			Food b = new Burrito(10);
			Food r = new Ramen(1000);
			Pouch<Food> food = new PouchImpl<Food>();
			food.add(s);
			food.add(b);
			food.add(r);
			
			Supplies[] expected = { r, b, s };
			Iterator<Supplies> foodIter = food.weightIterator();
			Supplies[] result = new Supplies[3];
			int i = 0;
			while (foodIter.hasNext()) {
				result[i] = foodIter.next();
				i++;
			}
			
			try {
				assertArrayEquals(expected, result);
			} catch (AssertionError ae) {
				System.err.println("\n\nError location: PouchImpl<Food>.weightIterator()");
				ae.printStackTrace();
				fail();
			}

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void foodPouchNameIterTest() {

		try {
			Food s = new Sushi(3);
			Food b = new Burrito(10);
			Food r = new Ramen(1);
			Pouch<Food> food = new PouchImpl<Food>();
			food.add(s);
			food.add(b);
			food.add(r);
			
			Supplies[] expected = { b, r, s };
			Iterator<Supplies> foodIter = food.nameIterator();
			Supplies[] result = new Supplies[3];
			int i = 0;
			while (foodIter.hasNext()) {
				result[i] = foodIter.next();
				i++;
			}
			
			try {
				assertArrayEquals(expected, result);
			} catch (AssertionError ae) {
				System.err.println("Error location: PouchImpl<Food>.nameIterator()");
				ae.printStackTrace();
				fail();
			}

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void powerupPouchAmountIterTest() {

		try {
			PowerUp c = new Coffee(3);
			PowerUp rb = new RedBison(10);
			Pouch<PowerUp> powerup = new PouchImpl<PowerUp>();
			powerup.add(c);
			powerup.add(rb);
			
			Supplies[] expected = { rb, c};
			Iterator<Supplies> powerupIter = powerup.amountIterator();
			Supplies[] result = new Supplies[2];
			int i = 0;
			while (powerupIter.hasNext()) {
				result[i] = powerupIter.next();
				i++;
			}
			
			try {
				assertArrayEquals(expected, result);
			} catch (AssertionError ae) {
				System.err.println("\n\nError location: PouchImpl<PowerUp>.amountIterator()");
				ae.printStackTrace();
				fail();
			}

		} catch (Exception e) {
			System.err.println("\n\nError location: PouchImpl<PowerUp>.amountIterator()");
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void powerupPouchWeightIterTest() {
		try {
			PowerUp c = new Coffee(3);
			PowerUp rb = new RedBison(100);
			Pouch<PowerUp> powerup = new PouchImpl<PowerUp>();
			powerup.add(c);
			powerup.add(rb);
			
			Supplies[] expected = { rb, c};
			Iterator<Supplies> powerupIter = powerup.weightIterator();
			Supplies[] result = new Supplies[2];
			int i = 0;
			while (powerupIter.hasNext()) {
				result[i] = powerupIter.next();
				i++;
			}
			
			try {
				assertArrayEquals(expected, result);
			} catch (AssertionError ae) {
				System.err.println("\n\nError location: PouchImpl<PowerUp>.weightIterator()");
				ae.printStackTrace();
				fail();
			}

		} catch (Exception e) {
			System.err.println("\n\nError location: PouchImpl<PowerUp>.weightIterator()");
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void powerupPouchNameIterTest() {
		try {
			PowerUp c = new Coffee(3);
			PowerUp rb = new RedBison(100);
			Pouch<PowerUp> powerup = new PouchImpl<PowerUp>();
			powerup.add(c);
			powerup.add(rb);
			
			Supplies[] expected = { c, rb};
			Iterator<Supplies> powerupIter = powerup.nameIterator();
			Supplies[] result = new Supplies[2];
			int i = 0;
			while (powerupIter.hasNext()) {
				result[i] = powerupIter.next();
				i++;
			}
			
			try {
				assertArrayEquals(expected, result);
			} catch (AssertionError ae) {
				System.err.println("\n\nError location: PouchImpl<PowerUp>.nameIterator()");
				ae.printStackTrace();
				fail();
			}

		} catch (Exception e) {
			System.err.println("\n\nError location: PouchImpl<PowerUp>.nameIterator()");
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void clothingPouchAmountIterTest() {
		try {
			Clothing f = new Fleece(3);
			Clothing bu = new ButtonUp(10);
			Clothing t = new TShirt(1);
			Pouch<Clothing> clothing = new PouchImpl<Clothing>();
			clothing.add(f);
			clothing.add(bu);
			clothing.add(t);
			
			Supplies[] expected = { bu, f, t};
			Iterator<Supplies> clothingIter = clothing.amountIterator();
			Supplies[] result = new Supplies[3];
			int i = 0;
			while (clothingIter.hasNext()) {
				result[i] = clothingIter.next();
				i++;
			}
			
			try {
				assertArrayEquals(expected, result);
			} catch (AssertionError ae) {
				System.err.println("\n\nError location: PouchImpl<Clothing>.amountIterator()");
				ae.printStackTrace();
				fail();
			}

		} catch (Exception e) {
			System.err.println("\n\nError location: PouchImpl<Clothing>.amountIterator()");
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void clothingPouchWeightIterTest() {
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
				System.err.println("\n\nError location: PouchImpl<Clothing>.weightIterator()");
				ae.printStackTrace();
				fail();
			}

		} catch (Exception e) {
			System.err.println("\n\nError location: PouchImpl<Clothing>.weightIterator()");
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void clothingPouchNameIterTest() {
		try {
			Clothing f = new Fleece(1);
			Clothing bu = new ButtonUp(1000);
			Clothing t = new TShirt(100);
			Pouch<Clothing> clothing = new PouchImpl<Clothing>();
			clothing.add(f);
			clothing.add(bu);
			clothing.add(t);
			
			Supplies[] expected = { bu, f, t};
			Iterator<Supplies> clothingIter = clothing.nameIterator();
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
	
	@Test
	public void knapsackAmountIterTest() {
		try {
			Food r = new Ramen(3);
			Food b = new Burrito(6);
			PowerUp c = new Coffee(1);
			PowerUp rb = new RedBison(5);
			Clothing t = new TShirt(4);
			Clothing f = new Fleece(2);
			Knapsack k = new KnapsackImpl();
			k.add(r);
			k.add(b);
			k.add(c);
			k.add(rb);
			k.add(t);
			k.add(f);
			Supplies[] expected = { b, rb, t, r, f, c };
			Iterator<Supplies> knapIter = k.amountIterator();
			Supplies[] result = new Supplies[6];
			int i = 0;
			System.out.println("\nentering\n");
			while (knapIter.hasNext()) {
				result[i] = knapIter.next();
				
				System.out.println(result[i].getName()+" "+result[i].getAmount());
				i++;
			}
			try {
				assertArrayEquals(expected, result);
			} catch (AssertionError ae) {
				System.err.println("Error location: KnapsackImpl.amountIterator()");
				ae.printStackTrace();
				fail();
			}
			
		} catch (Exception e) {
			System.err.println("Error location: KnapsackImpl.amountIterator()");
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void knapsackWeightIterTest() {
		try {
			Food r = new Ramen(1);
			Food b = new Burrito(100);
			PowerUp c = new Coffee(50);
			PowerUp rb = new RedBison(3000);
			Clothing t = new TShirt(600);
			Clothing f = new Fleece(1000000);
			Knapsack k = new KnapsackImpl();
			k.add(r);
			k.add(b);
			k.add(c);
			k.add(rb);
			k.add(t);
			k.add(f);
			
			Supplies[] expected = {f, rb, t, b, c, r};
			Iterator<Supplies> knapIter = k.weightIterator();
			Supplies[] result = new Supplies[6];
			int i = 0;
			while (knapIter.hasNext()) {
				result[i] = knapIter.next();
				i++;
			}
			
			try {
				assertArrayEquals(expected, result);
			} catch (AssertionError ae) {
				System.err.println("Error location: KnapsackImpl.weightIterator()");
				ae.printStackTrace();
				fail();
			}
			
		} catch (Exception e) {
			System.err.println("Error location: KnapsackImpl.weightIterator()");
			e.printStackTrace();
		}
	}
	
	@Test
	public void knapsackNameIterTest() {
		try {
			Food r = new Ramen(1);
			Food b = new Burrito(100);
			PowerUp c = new Coffee(50);
			PowerUp rb = new RedBison(3000);
			Clothing t = new TShirt(600);
			Clothing f = new Fleece(1000000);
			Knapsack k = new KnapsackImpl();
			k.add(r);
			k.add(b);
			k.add(c);
			k.add(rb);
			k.add(t);
			k.add(f);
			
			Supplies[] expected = {b, c, f, r, rb, t};
			Iterator<Supplies> knapIter = k.nameIterator();
			Supplies[] result = new Supplies[6];
			int i = 0;
			while (knapIter.hasNext()) {
				result[i] = knapIter.next();
				i++;
			}
			
			try {
				assertArrayEquals(expected, result);
			} catch (AssertionError ae) {
				System.err.println("Error location: KnapsackImpl.nameIterator()");
				ae.printStackTrace();
				fail();
			}
		} catch (Exception e) {
			System.err.println("Error location: KnapsackImpl.nameIterator()");
			e.printStackTrace();
		}
	}
	
	@Test
	public void emptyPouchKnapsackAmountIterTest () {
		try {
			Food r = new Ramen(1);
			Food b = new Burrito(100);
			PowerUp c = new Coffee(50);
			PowerUp rb = new RedBison(3000);
			Knapsack k = new KnapsackImpl();
			k.add(r);
			k.add(b);
			k.add(c);
			k.add(rb);
			
			Supplies[] expected = {rb, b, c, r};
			Iterator<Supplies> knapIter = k.amountIterator();
			Supplies[] result = new Supplies[4];
			int i = 0;
			while (knapIter.hasNext()) {
				result[i] = knapIter.next();
				i++;
			}
			
			try {
				assertArrayEquals(expected, result);
			} catch (AssertionError ae) {
				System.err.println("Error location: KnapsackImpl.amountIterator()");
				ae.printStackTrace();
				fail();
			}
			
		} catch (Exception e) {
			System.err.println("Error location: KnapsackImpl.amountIterator()");
			System.err.println("Error caused by one of the pouches being empty");
			e.printStackTrace();
		}
	}
	
	@Test
	public void emptyPouchKnapsackWeightIterTest() {
		try {
			Food r = new Ramen(1);
			Food b = new Burrito(100);
			Clothing t = new TShirt(600);
			Clothing f = new Fleece(1000000);
			Knapsack k = new KnapsackImpl();
			k.add(r);
			k.add(b);
			k.add(t);
			k.add(f);
			
			Supplies[] expected = {f, t, b, r};
			Iterator<Supplies> knapIter = k.weightIterator();
			Supplies[] result = new Supplies[4];
			int i = 0;
			while (knapIter.hasNext()) {
				result[i] = knapIter.next();
				i++;
			}
			
			try {
				assertArrayEquals(expected, result);
			} catch (AssertionError ae) {
				System.err.println("Error location: KnapsackImpl.weightIterator()");
				ae.printStackTrace();
				fail();
			}
			
		} catch (Exception e) {
			System.err.println("Error location: KnapsackImpl.weightIterator()");
			System.err.println("Error caused by one of the pouches being empty");
			e.printStackTrace();
		}
	}
	
	@Test
	public void emptyPouchKnapsackNameIterTest() {
		try {
			PowerUp c = new Coffee(1);
			PowerUp rb = new RedBison(100);
			Clothing t = new TShirt(600);
			Clothing f = new Fleece(1000000);
			Knapsack k = new KnapsackImpl();
			k.add(c);
			k.add(rb);
			k.add(t);
			k.add(f);
			
			Supplies[] expected = {c, f, rb, t};
			Iterator<Supplies> knapIter = k.nameIterator();
			Supplies[] result = new Supplies[4];
			int i = 0;
			while (knapIter.hasNext()) {
				result[i] = knapIter.next();
				i++;
			}
			
			try {
				assertArrayEquals(expected, result);
			} catch (AssertionError ae) {
				System.err.println("Error location: KnapsackImpl.nameIterator()");
				ae.printStackTrace();
				fail();
			}
			
		} catch (Exception e) {
			System.err.println("Error location: KnapsackImpl.nameIterator()");
			System.err.println("Error caused by one of the pouches being empty");
			e.printStackTrace();
		}
	}
}
