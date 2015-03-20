package a2;

import java.util.Scanner;

public class A2Adept {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		process_input(s);
	}

	public static void process_input(Scanner s) {
		// first read in the value of number of rectangles
		int number_of_rect = s.nextInt();

		// store counting of points for each rectangle into array
		int[] number_of_points_in_rect = new int[number_of_rect];

		// store rectangles into array
		Rectangle[] rect_array = new Rectangle[number_of_rect];



		// read in value of rectangle labels and corners
		for(int i = 0; i < number_of_rect; i++){
			String type_of_rect = s.next(); // labeled "A"
			int x1 = s.nextInt();	
			int y1 = s.nextInt();	// point 1: (0,0)
			int x2 = s.nextInt();
			int y2 = s.nextInt();	// point 2: (10, 10)	

			// initialize rectangles
			Rectangle rect = new Rectangle(x1,y1,x2,y2,type_of_rect);
			rect_array[i] = rect;

		}

		// then read in value of number of points
		int number_of_points = s.nextInt();

		// read in value of coordinates of points
		for(int j = 0; j < number_of_points; j++){
			int px = s.nextInt();
			int py = s.nextInt(); // p(1,1)

			Point p = new Point(px,py);

			// for each rectangle, check whether the point resides strictly inside it
			for(int i = 0; i < number_of_rect; i++){
				if ( rect_array[i].testPoint(p) ) {
					// if the point is in rect i, then counting of rect i increase by 1
					// else, just check the next rectangle
					number_of_points_in_rect[i] += 1;
				}
			}
		}

		// Output:
		for(int i = 0; i < number_of_rect; i++){
			System.out.println(rect_array[i].getLabel()+" contains "+number_of_points_in_rect[i]+" points");
		}
	}
}
