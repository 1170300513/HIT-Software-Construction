package relationship;

import java.util.List;



/**
 * mutable�Ŀɸ�����ӿ�relationshipbetweenco�����ڱ�ʾ����ϵͳ�����ĵ�����͹������Ĺ�ϵ.
 * 
 * @author junbaba
 *
 * @param <L> ����ϵͳ�����ĵ���������
 * @param <E> ������������
 */
public interface RelationshipBetweenco<L, E> {

  /**
   * ����һ��ʵ��relationshipbetweenco�ӿڵĶ���ľ�̬��������.
   * 
   * @return ʵ�� relationshipbetweenco�ӿڵĶ���
   */
  public static <L, E> RelationshipBetweenco<L, E> creator(L c, String choice) {
    if (choice.equals("Basics")) {
      return new Basicrelationshipbetweenco<L, E>(c);
    } else {
      throw new UnsupportedOperationException();
    }
  }

  /**
   * ���ع�ϵ�е����ĵ�����.
   * 
   * @return ���ĵ�����
   */
  public L getc();

  /**
   * ���������ĵ����������ϵ�Ĺ��������б�.
   * 
   * @return ��ϵ�б�
   */
  public List<Socialtie<E>> getrel();

  /**
   * ��������ĵ������ϵ�Ĺ������.
   * 
   * @param object ��Ҫ�����ϵ�Ĺ������
   */
  public void addconnection(E object, Number intimacy);
}


