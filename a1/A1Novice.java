/*
 * Chongrui Zhang
 * 
 *  read and process input to calculate and report:
 * The number of rectangles that were square.
 * The number of rectangles that were wider than they were tall.
 * The number of rectangles that were taller than they were wide.
 * The rectangle with the minimum perimeter.
 * The rectangle with the maximum perimeter.
 * The rectangle with the minimum area.
 * The rectangle with the maximum area.
 * */

package a1;

import java.util.Scanner;

public class A1Novice {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		process(s);
	}

	public static void process(Scanner s) {
		/* Here is where your code will go. */
		// first read in the value of number of rectangles
		int number_of_rect = s.nextInt();

		// initialize computing results
		int number_of_square = 0;
		int number_of_wider_count = 0;
		int number_of_taller_count = 0;
		int max_peri = 0;
		int min_peri = Integer.MAX_VALUE;
		String max_peri_type = "";
		String min_peri_type = "";
		int max_area = 0;
		int min_area = Integer.MAX_VALUE;
		String max_area_type = "";
		String min_area_type = "";

		for(int i = 0; i < number_of_rect; i++){
			String type_of_rect = s.next(); // labeled "A"
			int x1 = s.nextInt();	
			int y1 = s.nextInt();	// point 1: (0,0)
			int x2 = s.nextInt();
			int y2 = s.nextInt();	// point 2: (10, 10)

			// Calculating length
			int wide = Math.abs(x2-x1);
			int tall = Math.abs(y2-y1);

			if (wide == tall) {
				// count number of rectangles that were square
				number_of_square++;
			} else if (wide > tall) {
				// number of rectangles that were wider than they were tall
				number_of_wider_count++;
			} else {
				// number of rectangles that were taller than they were wide
				number_of_taller_count++;
			}

			// Calculating perimeter
			int perimeter = 2*(wide + tall);
			if (max_peri < perimeter) {
				max_peri = perimeter;		  // record max perimeter value
				max_peri_type = type_of_rect; // record type with max perimeter
			}
			if (min_peri > perimeter) {
				min_peri = perimeter;
				min_peri_type = type_of_rect;
			}

			// Calculating area
			int area = wide * tall;
			if (max_area < area) {
				max_area = area;			  // record max area value
				max_area_type = type_of_rect; // record type with max area
			}
			if (min_area > area) {
				min_area = area;
				min_area_type = type_of_rect;
			}
		}

		// Output
		System.out.println("Square count = "+number_of_square);
		System.out.println("Wide count = "+number_of_wider_count);
		System.out.println("Tall count = "+number_of_taller_count);
		System.out.println("Min perimeter = "+min_peri+
				" ("+min_peri_type+")");
		System.out.println("Max perimeter = "+max_peri+
				" ("+max_peri_type+")");
		System.out.println("Min area = "+min_area+
				" ("+min_area_type+")");
		System.out.println("Max area = "+max_area+
				" ("+max_area_type+")");

	}
}
