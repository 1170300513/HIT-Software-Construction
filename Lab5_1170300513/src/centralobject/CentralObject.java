package centralobject;



/**
 * immutable�Ŀɸ�����ӿ�CentralObject������ģ�����ĵ�����.
 * 
 * @author junbaba
 *
 */
public interface CentralObject {
  /**
   * ����һ��ʵ��CentralObject�ӿ���Ӧ����Q2�Ķ���ľ�̬��������.
   * 
   * @param name ������
   * @param ridus ���ǰ뾶
   * @param quality ��������
   * @return ʵ��CentralObject�ӿ���Ӧ����Q2�Ķ���
   */
  public static CentralObject sunscreator(String name, Number ridus, Number quality) {
    return new Suns(name, ridus, quality);
  }


  /**
   * ����һ��ʵ��CentralObject�ӿ���Ӧ����Q3�Ķ���ľ�̬��������.
   * 
   * @param name ԭ�Ӻ���
   * @return ʵ��CentralObject�ӿ���Ӧ����Q3�Ķ���
   */
  public static CentralObject atomcreator(String name) {
    return new Atomicnucleus(name);
  }

  /**
   * ����һ��ʵ��CentralObject�ӿ���Ӧ����Q5�Ķ���ľ�̬��������.
   * 
   * @param name ����
   * @param sex �Ա�
   * @param ages ����
   * @return ʵ��CentralObject�ӿ���Ӧ����Q5�Ķ���
   */
  public static CentralObject centralusercreator(String name, String sex, Number ages) {
    return new CentralUser(name, sex, ages);
  }



  /**
   * �õ�����������.
   * 
   * @return ���������ơ�
   */
  public String getname();

  /**
   * �õ�������İ뾶�����Q2��.
   * 
   * @return ������뾶
   */
  public Number getridus();

  /**
   * �õ����������������Q2��.
   * 
   * @return ����������
   */
  public Number getquality();



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
