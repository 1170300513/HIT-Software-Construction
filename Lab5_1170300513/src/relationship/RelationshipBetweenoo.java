package relationship;

import java.util.List;


/**
 * mutable�Ŀɸ�����ӿ�relationshipbetweenoo�����ڱ�ʾ����ϵͳ�й����������͹������Ĺ�ϵ.
 * 
 * @author junbaba
 *
 * @param <E> ������������
 */
public interface RelationshipBetweenoo<E> {

  /**
   * ����һ��ʵ��relationshipbetweenoo�ӿڵĶ���ľ�̬��������.
   * 
   * @return ʵ�� relationshipbetweenoo�ӿڵĶ���
   */
  public static <E> RelationshipBetweenoo<E> creator(E object, String choice) {
    if (choice.equals("Basics")) {
      return new Basicrelationshipbetweenoo<E>(object);
    } else {
      throw new UnsupportedOperationException();
    }
  }


  /**
   * ���ظù������.
   * 
   * @return �������
   */
  public E geto();

  /**
   * ������ù�����������ϵ�Ĺ��������б�.
   * 
   * @return ���������б�
   */
  public List<Socialtie<E>> getrel();


  /**
   * �����ù�����������ϵ�Ĺ������.
   * 
   * @param newobejct ��Ҫ�����ϵ�Ĺ������
   * @param intimacy ���ܶ�
   */
  public void addconnection(E newobejct, Number intimacy);
}


