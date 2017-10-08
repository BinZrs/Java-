
/**
 * ����ģʽʵ��ChocolateBoiler
 * @author Administrator
 *
 */
public class ChocolateBoiler {
	private static ChocolateBoiler uniqueInstance;
	private boolean empty = true; // ��ʼ��¯Ϊ��
	private boolean boiled = false; // δ���

	private ChocolateBoiler() {}

	public static ChocolateBoiler getuniqueInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new ChocolateBoiler();
		}
		return uniqueInstance;
	}

	public boolean isEmpty() {
		return empty;
	}

	public boolean isBoiled() {
		return boiled;
	}

	public void fill() {
		if (isEmpty() == true) {
			System.out.println("��������ɿ�����ţ�̻���");
			this.empty = false;
		} else {
			System.out.println("��¯�������޷���䣡");
		}
	}

	public void boil() {
		if (isEmpty() == false && isBoiled() == false) {
			System.out.println("����ִ����в�����");
			this.boiled = true;
		} else {
			System.out.println("��¯δ�����޷�ִ����в���");
		}

	}

	public void drain() {
		if (isEmpty() == false && isBoiled() == true) {
			System.out.println("�����ų������!");
			this.empty = true;
			this.boiled = false;
		} else {
			System.out.println("��¯δ����û����У��޷�ִ���ų�����!");
		}

	}

}
