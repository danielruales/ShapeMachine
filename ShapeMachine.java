//Daniel Ruales
//11171801
//Section: 165B
//Project Number: Project 2
//Brief description of file contents: Shape Machine

import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.lang.Math;

public class ShapeMachine {
	public static void main(String[] args) {
		// Input the correct date in order to pass to the "Shape Machine".
		String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
		Scanner input = new Scanner(System.in);
		System.out.println("Shape Machine login");

		// Login with current date.
		for (int i = 1; i <= 3; i++) {
			System.out.println("");
			System.out.println("What is today's day?");
			int day = input.nextInt();
			System.out.println("What is today's month?");
			int month = input.nextInt();
			System.out.println("What is today's year?");
			int year = input.nextInt();
			String CurrentDate = day + "-" + month + "-" + year;
			if (CurrentDate.equals(date)) {
				System.out.println("Correct date. Welcome!");
				break;
			} else {
				if (i == 3) {
					System.out.println("#ERROR 3rd invalid login attempt. Terminating program.");
					System.exit(0);
				}
				System.out.println("#ERROR Login attempt #" + i + " Invalid input. Please try again.");
			}

		}

		// "Shape Machine" now initiates.

		while (true) {
			System.out.println("");
			System.out.println("---Welcome to the Shape Machine---");
			System.out.println("Available Options:");
			System.out.println("Circles");
			System.out.println("Rectangles");
			System.out.println("Triangles");
			System.out.println("Exit");

			String shape = input.next();

			if (shape.equals("Circles"))
				Circles();
			else if (shape.equals("Rectangles"))
				Rectangles();
			else if (shape.equals("Triangles"))
				Triangles();
			else if (shape.equals("Exit")) {
				System.out.println("Terminating the program. Have a nice day!");
				System.exit(0);
			} else {
				System.out.println("#ERROR Invalid option. Please try again.");
			}
		}
	}
	//Each method traces back to the menu in order to repeat the "Shape Machine"'s function.
	public static void Triangles() {
		Scanner input = new Scanner(System.in);
		System.out.println("Triangles selected. Please enter the 3 sides: ");
		double side1;
		double side2;
		double side3;
		while (true) {
			side1 = input.nextDouble();
			side2 = input.nextDouble();
			side3 = input.nextDouble();
			if (side1 < 0 || side2 < 0 || side3 < 0)
				System.out.println("#ERROR Negative input. Please input the 3 sides again: ");
			else
				break;
		}

		if (side1 + side2 < side3 || side1 + side3 < side2 || side2 + side3 < side1) {
			System.out.println("#ERROR Triangle is not valid. Returning to menu.");
		} else {
			if (side1 == side2 && side2 == side3)
				System.out.println("The triangle is: Equilateral");
			else if (side1 == side2 || side2 == side3 || side1 == side3)
				System.out.println("The triangle is: Isosceles");
			else
				System.out.println("The triangle is: Scalene");
			System.out.println("The perimeter is: " + (side1 + side2 + side3));
			// Area calculator
			double perimeter = side1 + side2 + side3;
			// halfP is half of perimeter
			double halfP = perimeter / 2;
			double area = Math.sqrt((halfP) * (halfP - side1) * (halfP - side2) * (halfP - side3));
			System.out.println("The area is: " + area);
			String perimS = Double.toString(perimeter);
			String areaS = Double.toString(area);
			int areaDigits = areaS.length() - 1;
			int perimDigits = perimS.length() - 1;
			System.out.println("Total number of digits in the perimeter is: " + perimDigits);
			System.out.println("Total number of digits in the area is: " + areaDigits);
		}
	}

	public static void Circles() {
		Scanner input = new Scanner(System.in);
		System.out.println("Circles selected. Please enter the radius: ");
		double radius;
		while (true) {
			radius = input.nextDouble();
			if (radius < 0)
				System.out.println("#ERROR Negative input. Please input the radius again: ");
			else
				break;
		}
		double circumference = 2 * radius * Math.PI;
		double area = Math.PI * radius * radius;
		System.out.println("The circumference is: " + circumference);
		System.out.println("The area is: " + area);

		String circumS = Double.toString(circumference);
		String areaS = Double.toString(area);
		int circumDigits = circumS.length() - 1;
		int areaDigits = areaS.length() - 1;
		System.out.println("Total number of digits in the circumference is: " + circumDigits);
		System.out.println("Total number of digits in the area is: " + areaDigits);
	}

	public static void Rectangles() {
		Scanner input = new Scanner(System.in);
		System.out.println("Rectangles selected. Please enter the 2 sides: ");
		double side1;
		double side2;

		while (true) {
			side1 = input.nextDouble();
			side2 = input.nextDouble();
			if (side1 < 0 || side2 < 0)
				System.out.println("#ERROR Negative input. Please input the 2 sides again: ");
			else
				break;
		}
		double area = side1 * side2;
		double perimeter = 2 * side1 + 2 * side2;

		System.out.println("The area is: " + area);
		System.out.println("The perimeter is: " + perimeter);

		String perimS = Double.toString(perimeter);
		String areaS = Double.toString(area);
		int areaDigits = areaS.length() - 1;
		int perimDigits = perimS.length() - 1;
		System.out.println("Total number of digits in the area is: " + areaDigits);
		System.out.println("Total number of digits in the perimeter is: " + perimDigits);
	}
}
