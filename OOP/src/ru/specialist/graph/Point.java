package ru.specialist.graph;

public class Point extends Shape { // extends Shape - наследование класса фигур
	public int x;
	public int y;

	public Point(int x, int y) {
		this(x, y, DEFAULT_COLOR);
	}

	public Point(int x, int y, String color) {
		super(color); // „тобы не дублировать код
						// ƒолжен вызыватьс€ первым
		this.x = x;
		this.y = y;
		// this.color = color;
	}

	public void moveBy(int dx, int dy) {
		x += dx;
		y += dy;
	}

	@Override // јннотаци€ переопределени€ (помогает не описатьс€, лучше всегда исользовать
				// дл€ нагладности)
	public void draw() {
		// super.draw(); // —сылаемс€ из класса наследника на класс родител€
		System.out.printf("Point (%d, %d). Color: %s\n", x, y, color);
	}

	@Override
	public String toString() {
		return String.format("Point (%d, %d). Color: %s\n", x, y, color);
	}

	@Override
	public Point clone() {
		return new Point(this.x, this.y, this.color);
	}
}
