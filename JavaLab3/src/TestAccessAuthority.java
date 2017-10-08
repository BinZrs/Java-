
public class TestAccessAuthority {	
	/**
	 * 同在默认包中测试不同访问权限
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AccessAuthority obj = new AccessAuthority();
		System.out.println(obj.x); 
		System.out.println(obj.y);
		System.out.println(obj.z);
		//System.out.println(obj.flag); //错误
		/**
		 * 编译器提示错误信息
		 * Error: Unresolved compilation problems: 
			The field AccessAuthority.flag is not visible
		 */
		obj.printX();
		obj.printY();
		obj.printZ();
		//obj.printFlag();  //错误
		/**
		 * printFlag() 为private 只能在本类中访问
		 * 编译器：提示错误信息如下
		 * The method printFlag() from the type AccessAuthority is not visible
		 */
		
	}

}
