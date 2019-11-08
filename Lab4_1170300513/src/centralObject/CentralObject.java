package centralObject;



/**
 * immutable�Ŀɸ�����ӿ�CentralObject������ģ�����ĵ����塣
 * @author junbaba
 *
 */
public interface CentralObject 
{
	/**
	 * ����һ��ʵ��CentralObject�ӿ���Ӧ����Q2�Ķ���ľ�̬��������
	 * 
	 * @param ������name
	 * @param ���ǰ뾶ridus
	 * @param ��������quality
	 * @return ʵ��CentralObject�ӿ���Ӧ����Q2�Ķ���
	 */
	public static CentralObject Q2creator(String name , Number ridus , Number quality)
	{
		return new Q2_Suns( name  , ridus ,  quality);
	}
	
	
	/**
	 * ����һ��ʵ��CentralObject�ӿ���Ӧ����Q3�Ķ���ľ�̬��������
	 * 
	 * @param ԭ�Ӻ���name
	 * @param �����orbitnum
	 * @return ʵ��CentralObject�ӿ���Ӧ����Q3�Ķ���
	 */
	public static CentralObject Q3creator(String name)
	{
		return new Q3_Atomic_nucleus(name);
	}
	
	/**
	 * ����һ��ʵ��CentralObject�ӿ���Ӧ����Q5�Ķ���ľ�̬��������
	 * 
	 * @param ����name
	 * @param �Ա�sex
	 * @param ����ages
	 * @return ʵ��CentralObject�ӿ���Ӧ����Q5�Ķ���
	 */
	public static CentralObject Q5creator(String name , String sex , Number ages)
	{
		return new Q5_CentralUser(name, sex, ages);
	}
	
	
	
	/**
	 * �õ����������ơ�
	 * @return ���������ơ�
	 */
	public String getname() ;
	
	/**
	 * �õ�������İ뾶�����Q2��
	 * @return ������뾶
	 */
	public Number getridus();
	
	/**
	 * �õ����������������Q2��
	 * @return ����������
	 */
	public Number getquality();
	
	

	
	
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

		
	

	
	
}
