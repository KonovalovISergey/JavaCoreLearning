package ru.specialist;

import ru.specialist.stuff.Person;
import ru.specialist.graph.*;

public class Program {

	public static void main(String[] args) {
		{

			Person.showCounter();

			Person p1 = Person.create("������", 23);
			// new Person("������", 23);
			// p1.name = "������";
			// p1.age = 23;
			
			Person p3 = Person.create("������", 22);
			
			Person p2 = Person.create("����", 24);
			// new Person("����", 24);
			// p2.name = "����";
			// p2.age = 24;

			//Person p3 = Person.create("������", 22);
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

			Shape s1 = p1; // ������� �������������� �� ��������� ������ � ��������
			
			if (s1 instanceof Point) { // �������� �� ����������� ���������� ������ � ������ (true)
				Point p3 = (Point) s1; // ����� �������������� �� ������������� ������ � ���������
				p3.moveBy(1, 1);
			}
			
			Circle c1 = new Circle(100, 200, 50, "pink");
			//c1.scale(1.5);
			c1.setR(50);;
			
			s1 = c1;
			System.out.println(c1.getR());
			
			if (s1 instanceof Point) { // �������� �� ����������� ���������� ������ � ������ (fals)
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
