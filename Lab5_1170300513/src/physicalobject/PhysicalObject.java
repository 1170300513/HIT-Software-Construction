package physicalobject;



/**
 * immutable�Ŀɸ�����ӿ�CentralObject������ģ������.
 * 
 * @author junbaba
 *
 */
public interface PhysicalObject {
  /**
   * ����һ��ʵ��PhysicalObject�ӿ���Ӧ����Q2�Ķ���ľ�̬��������.
   * 
   * @param name ������
   * @param form ������̬
   * @param color ������ɫ
   * @param planetr ���ǰ뾶
   * @param v ���ǹ�ת�ٶ�
   * @param direction ���ǹ�ת����
   * @return ʵ��PhysicalObject�ӿ���Ӧ����Q2�Ķ���
   */
  public static PhysicalObject planetcreator(String name, String form, String color, Number planetr,
      Number v, String direction) {
    return new Planet(name, form, color, planetr, v, direction);
  }



  /**
   * ����һ��ʵ��PhysicalObject�ӿ���Ӧ����Q3�Ķ���ľ�̬��������.
   * 
   * @return ʵ��PhysicalObject�ӿ���Ӧ����Q3�Ķ���
   */
  public static PhysicalObject electronicscreator() {
    return new Electronics();
  }


  /**
   * ����һ��ʵ��PhysicalObject�ӿ���Ӧ����Q5�Ķ���ľ�̬��������.
   * 
   * @param name ����
   * @param sex �Ա�
   * @param ages ����
   * @return ʵ��PhysicalObject�ӿ���Ӧ����Q5�Ķ���
   */
  public static PhysicalObject friendcreator(String name, String sex, Number ages) {
    return new Friend(name, sex, ages);
  }


  /**
   * �õ�����������.
   * 
   * @return ���������ơ�
   */
  public String getname();


  /**
   * �õ����������̬�����Q2��.
   * 
   * @return ���������̬
   */
  public String getform();


  /**
   * �õ����������ɫ�����Q2��.
   * 
   * @return ��������ɫ
   */
  public String getcolor();


  /**
   * �õ����������ǰ뾶�����Q2��.
   * 
   * @return ���������ǰ뾶
   */
  public Number getplanetr();



  /**
   * �õ�������Ĺ�ת�ٶȣ����Q2��.
   * 
   * @return ������Ĺ�ת�ٶ�
   */
  public Number getv();



  /**
   * �õ�������Ĺ�ת�������Q2��.
   * 
   * @return ������Ĺ�ת����
   */
  public String getdirection();



  /**
   * �õ��������Ա����Q5��.
   * 
   * @return �������Ա�
   */
  public String getsex();



  /**
   * �õ����������䣨���Q5��.
   * 
   * @return ����������
   */
  public Number getages();



}
