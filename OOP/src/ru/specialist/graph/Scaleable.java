package ru.specialist.graph;

public interface Scaleable {

	/*public static final (автоматом)*/ double DEFAULT_FACTOR = 2D;

	public static void test() {

	}

	void scale(double factor);
	
	default void scale() { // Дефолтная реализация метода
		scale(DEFAULT_FACTOR);
	}

}
