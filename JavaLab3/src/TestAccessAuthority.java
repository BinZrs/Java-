
public class TestAccessAuthority {	
	/**
	 * ͬ��Ĭ�ϰ��в��Բ�ͬ����Ȩ��
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AccessAuthority obj = new AccessAuthority();
		System.out.println("obj �����x="+obj.x); 
		System.out.println("obj �����y="+obj.y);
		System.out.println("obj �����z="+obj.z);
		//System.out.println(obj.flag); //����
		/**
		 * ��������ʾ������Ϣ
		 * Error: Unresolved compilation problems: 
			The field AccessAuthority.flag is not visible
		 */
		obj.printX();
		obj.printY();
		obj.printZ();
		//obj.printFlag(); //����
		/**
		 * printFlag() Ϊprivate ֻ���ڱ����з���
		 * ����������ʾ������Ϣ����
		 * The method printFlag() from the type AccessAuthority is not visible
		 */


	}
	

}
