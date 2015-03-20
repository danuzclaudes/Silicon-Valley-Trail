package a2;

import java.util.Scanner;

public class A2Jedi {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		process_input(s);
	}

	public static void process_input(Scanner s) {
		// first read in the value of number of rectangles
		int number_of_rect = s.nextInt();

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
		
		int count_of_intersection;
		// for each rect i, check if the rest rect j is NOT OVERLAPPING:
		for(int i=0;i<rect_array.length;i++){
			count_of_intersection = 0;
			System.out.print(rect_array[i].getLabel()+" intersects ");
			for(int j=0; j<rect_array.length; j++){
				if(j==i) continue; 
				if(rect_array[i].intersects(rect_array[j])){
					count_of_intersection++;
					System.out.print(rect_array[j].getLabel()+" ");
				}
			}
			if(count_of_intersection == 0) System.out.print("nothing");
			System.out.println();
		}
	}
}
