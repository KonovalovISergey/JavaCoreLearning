
public class Program {

	public static void fireFighters(Object s) {
		System.out.println("�������� ��������");
	}

	public static void main(String[] args) {

		Switcher sw = new Switcher();

		Lamp lamp = new Lamp();

		TvSet tv = new TvSet();

		AirCondition ac = new AirCondition();

		sw.addElectricityListener(lamp);
		sw.addElectricityListener(tv);
		// sw.addElectricityListener( e-> ac.on(e));
		sw.addElectricityListener(ac::on); // ���������� ������ ��� ������ ���������� ��������� ������
		//sw.addElectricityListener(e-> Program.fireFighters(e));
		sw.addElectricityListener(Program::fireFighters); // ����� �������� ������� ����������� �����
		
		/* final */ String message = "�����";

		sw.addElectricityListener(new ElectricityListener() {

			public void electricity(Object sourse) {
				System.out.println(message);
			}
		}); // ���� ������ ��������� �� �����

		sw.addElectricityListener(s -> System.out.println("Fire!")); // ������ ���������
		// s - ��� ������ �.�. 1 ��������
		// ��� �����. ������ �.�. 1 ��������
		sw.switchOn();
	}

}
