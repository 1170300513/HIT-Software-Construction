package relationship;

/**
 * ���ڸ�����ʾ��ϵimmutable����.
 * 
 * @author junbaba
 *
 */
public class Socialtie<E> {
  protected final E object;
  protected final Number intimacy;

  // Abstraction function:
  // object��Ӧ���壬intimacy��Ӧ���ܶ�

  // Representation invariant:
  // object != null
  // intimacy != null

  // Safety from rep exposure:
  // ͨ��protectedʹ�������������޷���֪�����е�rep,����get�������õ��ķ���ֵ����ֻ�ܲ鿴�޷��޸�.

  // TODO checkRep
  /**
   * checkRep.
   */
  public void checkRep() {
    assert object != null;
    assert intimacy != null;

  }

  // TODO constructor
  public Socialtie(E object, Number intimacy) {
    this.object = object;
    this.intimacy = intimacy;
  }


  /**
   * �ṩ��ʹ���ߵĵ�֪object�ķ���.
   * 
   * @return object
   */
  public E getobj() {
    checkRep();
    return object;
  }


  /**
   * �ṩ��ʹ���ߵ�֪���ܶ�intimacy�ķ���.
   * 
   * @return ���ܶ�intimacy
   */
  public Number getIntimacy() {
    checkRep();
    return intimacy;
  }
}
