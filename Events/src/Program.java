
public class Program {

	public static void fireFighters(Object s) {
		System.out.println("Пожарные приехали");
	}

	public static void main(String[] args) {

		Switcher sw = new Switcher();

		Lamp lamp = new Lamp();

		TvSet tv = new TvSet();

		AirCondition ac = new AirCondition();

		sw.addElectricityListener(lamp);
		sw.addElectricityListener(tv);
		// sw.addElectricityListener( e-> ac.on(e));
		sw.addElectricityListener(ac::on); // Сокращение лямбды при точном совпадении сигнатуры метода
		//sw.addElectricityListener(e-> Program.fireFighters(e));
		sw.addElectricityListener(Program::fireFighters); // Можно засунуть местный статический метод
		
		/* final */ String message = "Пожар";

		sw.addElectricityListener(new ElectricityListener() {

			public void electricity(Object sourse) {
				System.out.println(message);
			}
		}); // Ниже Лямбда выражение от этого

		sw.addElectricityListener(s -> System.out.println("Fire!")); // Лямбда выражение
		// s - без скобок т.к. 1 параметр
		// нет фигур. скобок т.к. 1 оператор
		sw.switchOn();
	}

}
