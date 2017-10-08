
public class AccessAuthority {
	public int x; // public 权限
	protected double y; // protected 权限
	float z; // 默认权限
	private boolean flag; // private 权限
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
