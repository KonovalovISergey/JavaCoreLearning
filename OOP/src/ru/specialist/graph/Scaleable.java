package ru.specialist.graph;

public interface Scaleable {

	/*public static final (���������)*/ double DEFAULT_FACTOR = 2D;

	public static void test() {

	}

	void scale(double factor);
	
	default void scale() { // ��������� ���������� ������
		scale(DEFAULT_FACTOR);
	}

}
