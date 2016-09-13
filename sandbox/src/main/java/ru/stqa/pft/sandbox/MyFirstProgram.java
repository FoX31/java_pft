package ru.stqa.pft.sandbox;

public class MyFirstProgram {

	public static void main(String[] args) {
	  hello("world");
		hello("user");
		hello("Evgeniy");

		Square s = new Square(5);
		System.out.println("Площадь квадрата со стороной " + s.l + " = " + area(s));

    Rectangle r = new Rectangle(4, 6);
		System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + area(r));


		Point a = new Point(2, 2);

		Point b = new Point(1, 2);


		System.out.println("Расстояние между точками " + a.distance(a, b));
		System.out.println("Расстояние между точками " + distance(a, b));
	}

	public static void hello(String somebody) {
		System.out.println("Hello, " + somebody + "!");
	}


	public static double area(Square s) {
		return s.l * s.l;
	}

	public static double area(Rectangle r){
		return r.a * r.b;
	}
	public static double distance(Point p1, Point p2){
		return Math.sqrt((p1.x - p2.x)^2 + (p1.y - p2.y)^2 );
	}
}  