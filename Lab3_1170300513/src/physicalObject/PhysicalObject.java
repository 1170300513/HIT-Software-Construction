package physicalObject;



/**
 * immutable�Ŀɸ�����ӿ�CentralObject������ģ�����ϡ�
 * @author junbaba
 *
 */
public interface PhysicalObject 
{
	/**
	 * ����һ��ʵ��PhysicalObject�ӿ���Ӧ����Q2�Ķ���ľ�̬��������
	 * 
	 * @param ������name
	 * @param ������̬form
	 * @param ������ɫcolor
	 * @param ���ǰ뾶planetr
	 * @param ���ǹ���뾶orbitr
	 * @param ���ǹ�ת�ٶ�v
	 * @param ���ǹ�ת�Ƕ�angle
	 * @param ���ǹ�ת����direction
	 * @return ʵ��PhysicalObject�ӿ���Ӧ����Q2�Ķ���
	 */
	public static PhysicalObject Q2creator(String name , String form , String color , Number planetr , 
			Number v , String direction)
	{
		return new Q2_Planet(name, form, color, planetr,  v,  direction);
	}
	
	
	/**
	 * ����һ��ʵ��PhysicalObject�ӿ���Ӧ����Q3�Ķ���ľ�̬��������
	 * @return ʵ��PhysicalObject�ӿ���Ӧ����Q3�Ķ���
	 */
	public static PhysicalObject Q3creator()
	{
		return new Q3_Electronics();
	}
	
	
	/**
	 * ����һ��ʵ��PhysicalObject�ӿ���Ӧ����Q5�Ķ���ľ�̬��������
	 * 
	 * @param ����name
	 * @param �Ա�sex
	 * @param ����ages
	 * @return ʵ��PhysicalObject�ӿ���Ӧ����Q5�Ķ���
	 */
	public static PhysicalObject Q5creator(String name, String sex , Number ages)
	{
		return new Q5_Friend(name, sex, ages);
	}
	
	
	/**
	 * �õ����������ơ�
	 * @return ���������ơ�
	 */
	public String getname() ;
	
	
	/**
	 * �õ����������̬�����Q2��
	 * @return ���������̬
	 */
	public String getform();
	
	
	/**
	 * �õ����������ɫ�����Q2��
	 * @return ��������ɫ
	 */
	public String getcolor();
	
	
	/**
	 * �õ����������ǰ뾶�����Q2��
	 * @return ���������ǰ뾶
	 */
	public Number getplanetr();
	

	
	/**
	 * �õ�������Ĺ�ת�ٶȣ����Q2��
	 * @return ������Ĺ�ת�ٶ�
	 */
	public Number getv();
	
	

	
	
	
	/**
	 * �õ�������Ĺ�ת�������Q2��
	 * @return ������Ĺ�ת����
	 */
	public String getdirection();
	
	
	
	/**
	 * �õ��������Ա����Q5��
	 * @return �������Ա�
	 */
	public String getsex();
	
	
	
	/**
	 * �õ����������䣨���Q5��
	 * @return ����������
	 */
	public Number getages();
	
	
	/**
	 * �����ж��Ƿ���ȵķ���
	 * @param obj
	 * @return ���Լ�������ͬ���Ϸ���true,���򷵻�false
	 */
	boolean equals(PhysicalObject obj);
	
}
