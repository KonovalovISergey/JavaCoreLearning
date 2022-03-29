package ru.specialist.graph;

import java.util.ArrayList;

public /*
		 * final - Запрещает наследование от этого класса
		 */ abstract class Shape {

	public static final String DEFAULT_COLOR = "Black"; // Определение константы

	public String color;

	static ArrayList<Shape> sciene = new ArrayList<Shape>();

	public Shape() {
		this(DEFAULT_COLOR);
	}

	public Shape(String color) {
		this.color = color;
		sciene.add(this);
	}

	public static void drawScene() {
		for (Shape s : sciene)
			s.draw();
	}

	public static void scaleScene(double factor) {
		for (Shape s : sciene) {
			if (s instanceof Scaleable) {
				Scaleable sc = (Scaleable)s;
				sc.scale(1.5);
			}
		}
	}

	public abstract void draw(); /*
									 * { System.out.printf("Shape. Color: %s\n", color); }
									 */

}
