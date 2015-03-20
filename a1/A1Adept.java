/*
 * Chongrui Zhang
 * report for each labeled rectangle, how many of the points are contained inside the rectangle
 * */
package a1;

import java.util.Scanner;

public class A1Adept {
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

		// store counting of points for each rectangle into array
		int[] number_of_points_in_rect = new int[number_of_rect];

		// read in value of rectangle labels and corners
		for(int i = 0; i < number_of_rect; i++){
			rect_label[i] = s.next(); // labeled "A"
			rect_x1[i] = s.nextInt();	
			rect_y1[i] = s.nextInt();	// point 1: (0,0)
			rect_x2[i] = s.nextInt();
			rect_y2[i] = s.nextInt();	// point 2: (10, 10)		
		}

		// then read in value of number of points
		int number_of_points = s.nextInt();

		// read in value of coordinates of points
		for(int j = 0; j < number_of_points; j++){
			int px = s.nextInt();
			int py = s.nextInt(); // p(1,1)

			// for each rectangle, check whether the point resides strictly inside it
			for(int i = 0; i < number_of_rect; i++){
				if ( (rect_x1[i] < px && px < rect_x2[i] &&
						rect_y1[i] < py && py < rect_y2[i] )
						|| (rect_x2[i] < px && px < rect_x1[i] &&
								rect_y2[i] < py && py < rect_y1[i]) ) {
					// if the point is in rect i, then counting of rect i increase by 1
					// else, just check the next rectangle
					number_of_points_in_rect[i] += 1;
				}
			}

		}

		// Output:
		for(int i = 0; i < number_of_rect; i++){
			System.out.println(rect_label[i]+" contains "+number_of_points_in_rect[i]+" points");
		}

	}
}
