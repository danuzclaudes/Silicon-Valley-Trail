package a6;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import supplies.Burrito;
import supplies.Clothing;
import supplies.Coffee;
import supplies.Fleece;
import supplies.Food;
import supplies.PowerUp;
import supplies.Ramen;
import supplies.RedBison;
import supplies.Supplies;
import supplies.TShirt;


public class a6KnapsackIteratorTest {

	@Test
	public void testArrayList() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);list.add(2);list.add(3);
		Integer s0 = list.get(0);
		Integer s1 = list.get(1);
		Integer s2 = list.get(2);
		list.set(0, 5);
//		System.out.println(s0);
		assertEquals(new Integer(1),s0);
		assertEquals(new Integer(2),s1);
		assertEquals(new Integer(3),s2);
		
		list.set(0, null);
		assertEquals(null, list.get(0));
	}
	
	@Test
	public void testKnapsackNameIterator(){
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
		
		Supplies[] expect = {b, c, f, r, rb, t};
		Supplies[] result = new Supplies[6];
		
		Iterator<Supplies> knapIter = k.nameIterator();
		
		int i = 0;
		while(knapIter.hasNext()){
			result[i] = knapIter.next();
//			System.out.println(result[i].getName());
			i++;
		}
		
		try {
			assertArrayEquals(expect, result);
		} catch (AssertionError ae) {
			System.err.println("Error location: KnapsackImpl.nameIterator()");
//			ae.printStackTrace();
			fail();
		}
	}

	@Test
	public void testknapsackAmountIter() {
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
			while (knapIter.hasNext()) {
				result[i] = knapIter.next();
				
				System.out.println(result[i].getName()+" "+result[i].getAmount());
				i++;
			}
			try {
				assertArrayEquals(expected, result);
			} catch (AssertionError ae) {
				System.err.println("Error location: KnapsackImpl.amountIterator()");
//				ae.printStackTrace();
				fail();
			}
			
		} catch (Exception e) {
			System.err.println("Error location: KnapsackImpl.amountIterator()");
//			e.printStackTrace();
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
				System.out.println(result[i].getName()+" "+result[i].getTotalWeight());
				i++;
			}
			
			try {
				assertArrayEquals(expected, result);
			} catch (AssertionError ae) {
				System.err.println("Error location: KnapsackImpl.weightIterator()");
//				ae.printStackTrace();
				fail();
			}
			
		} catch (Exception e) {
			System.err.println("Error location: KnapsackImpl.weightIterator()");
//			e.printStackTrace();
		}
	}
}
