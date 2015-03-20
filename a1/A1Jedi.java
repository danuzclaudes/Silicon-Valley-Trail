/*
 * Chongrui Zhang
 * report on which rectangles intersect with which other rectangles
 * */
package a1;

import java.util.Scanner;

public class A1Jedi {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		process(s);
	}

	public static void process(Scanner s) {
		/* Here is where your code will go. */
		// first read in the value of number of rectangles
		int number_of_rect = s.nextInt();

		// store rectangle labels into array
		String[] rect_label = new String[number_of_rect];
		// store rectangle corners into array
		int[] rect_x1 = new int[number_of_rect];
		int[] rect_y1 = new int[number_of_rect];
		int[] rect_x2 = new int[number_of_rect];
		int[] rect_y2 = new int[number_of_rect];

		// store counting of overlapping into array
		boolean[][] overlapping = new boolean[number_of_rect][number_of_rect];
		// count number of intersections
		int[] number_of_intersection = new int[number_of_rect];

		// read in value of rectangle labels and corners
		for(int i = 0; i < number_of_rect; i++){
			rect_label[i] = s.next(); // labeled "A"
			rect_x1[i] = s.nextInt();	
			rect_y1[i] = s.nextInt();	// point 1: (0,0)
			rect_x2[i] = s.nextInt();
			rect_y2[i] = s.nextInt();	// point 2: (10, 10)		
		}

		// for each rect i, check if the rest rect j is NOT OVERLAPPING:
		for(int i = 0; i < number_of_rect; i++){
			// get the corner of rect i
			int xi_min = Math.min(rect_x1[i], rect_x2[i]); // Left x coordinate of first rectangle
			int xi_max = Math.max(rect_x1[i], rect_x2[i]); // Right x coordinate of first rectangle
			int yi_min = Math.min(rect_y1[i], rect_y2[i]); // Bottom y coordinate of first rectangle
			int yi_max = Math.max(rect_y1[i], rect_y2[i]); // Top y coordinate of first rectangle

			for (int j = 0; j < number_of_rect; j++){
				if (j == i) continue;
				else {
					int xj_min = Math.min(rect_x1[j], rect_x2[j]); // Left x coordinate of second rectangle
					int xj_max = Math.max(rect_x1[j], rect_x2[j]); // Right x coordinate of second rectangle
					int yj_min = Math.min(rect_y1[j], rect_y2[j]); // Bottom y coordinate of second rectangle
					int yj_max = Math.max(rect_y1[j], rect_y2[j]); // Top y coordinate of second rectangle

					// if rect i is above/below rect j, or
					// if rect i is left/right to rect j
					// the two rectangles are NOT overlapping
					// Not sharing edge and not sharing corner
					if (!( xi_max<=xj_min || xi_min>=xj_max || yi_max<=yj_min || yi_min>=yj_max )){
						overlapping[i][j] = true;
						number_of_intersection[i] += 1;
					}
				}
			}
		}

		// Output:
		for(int i = 0; i < number_of_rect; i++){
			// if i intersects nothing
			if (number_of_intersection[i] == 0) {
				System.out.println(rect_label[i]+" intersects nothing");
			} else {
				// else print out each intersected j's label
				System.out.print(rect_label[i]+" intersects ");
				for(int j = 0; j < number_of_rect; j++){
					if (overlapping[i][j]) System.out.print(rect_label[j]+" ");
				}
				System.out.println();
			}

		}
	}
}
