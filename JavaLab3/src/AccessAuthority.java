
public class AccessAuthority {
	public int x; // public Ȩ��
	protected double y; // protected Ȩ��
	float z; // Ĭ��Ȩ��
	private boolean flag; // private Ȩ��
	public AccessAuthority() {
		x = 3;
		y = 4.66;
		z = 3.1f;
		flag = true;
			
	}
	
	public void printX() {
		System.out.println(x);
	}

	protected void printY() {
		System.out.print(y);
	}

	void printZ() {
		System.out.print(z);
	}

	private void printFlag() {
		System.out.print(flag);
	}
}
