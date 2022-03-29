package ru.specialist;

import ru.specialist.stuff.Person;
import ru.specialist.graph.*;

public class Program {

	public static void main(String[] args) {
		{

			Person.showCounter();

			Person p1 = Person.create("Сергей", 23);
			// new Person("Сергей", 23);
			// p1.name = "Сергей";
			// p1.age = 23;
			
			Person p3 = Person.create("Филипп", 22);
			
			Person p2 = Person.create("Саша", 24);
			// new Person("Саша", 24);
			// p2.name = "Саша";
			// p2.age = 24;

			//Person p3 = Person.create("Филипп", 22);
			//Person px = new Person();

			// p1.show(); //this == p1
			// p2.show(); //this == p2
			// p3.show();
			// px.show();
			Person.showAll();
			Person.showCounter();
		}

		{

			Point p1 = new Point(10, 20, "green");
			Point p2 = p1.clone();
			p1.color = "red";

			Shape s1 = p1; // Неявное преобразование от дочернего класса к родителю
			
			if (s1 instanceof Point) { // Проверка на возможность приведения ссылки к классу (true)
				Point p3 = (Point) s1; // Явное преобразование от родительского класса к дочернему
				p3.moveBy(1, 1);
			}
			
			Circle c1 = new Circle(100, 200, 50, "pink");
			//c1.scale(1.5);
			c1.setR(50);;
			
			s1 = c1;
			System.out.println(c1.getR());
			
			if (s1 instanceof Point) { // Проверка на возможность приведения ссылки к классу (fals)
				Point p3 = (Point)s1;
			}
			
			Shape.drawScene();
			// p1.draw();
			// p2.draw();

			// System.out.println( p1.toString() );
			// System.out.println( p1 );
		}
		
		{
			Singleton s1 = Singleton.getInstance();
			Singleton s2 = Singleton.getInstance();
			System.out.println(s1 == s2);
		}
	}
}
