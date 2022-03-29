package ru.specialist.graph;

public class Point extends Shape { // extends Shape - ������������ ������ �����
	public int x;
	public int y;

	public Point(int x, int y) {
		this(x, y, DEFAULT_COLOR);
	}

	public Point(int x, int y, String color) {
		super(color); // ����� �� ����������� ���
						// ������ ���������� ������
		this.x = x;
		this.y = y;
		// this.color = color;
	}

	public void moveBy(int dx, int dy) {
		x += dx;
		y += dy;
	}

	@Override // ��������� ��������������� (�������� �� ���������, ����� ������ �����������
				// ��� �����������)
	public void draw() {
		// super.draw(); // ��������� �� ������ ���������� �� ����� ��������
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
