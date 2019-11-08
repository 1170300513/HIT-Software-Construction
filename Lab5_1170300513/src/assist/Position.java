package assist;

/**
 * ���ڱ�ʾ���ϵͳ�й�����������mutable����.
 * 
 * @author junbaba
 *
 * @param <E> �����������
 */
public class Position<E> {
  private final E object;
  private Number ridus;
  private Number angle;

  // Abstraction function:
  // object��Ӧ������壬ridus��Ӧ�伫����İ뾶����angle��Ӧ������ĽǶ�

  // Representation invariant:
  // object != null
  // ridus > 0
  // 0 < angle < pi

  // Safety from rep exposure:
  // ͨ��privateʹ�������������޷���֪�����е�rep


  // TODO checkRep
  /**
   * checkRep.
   */
  public void checkRep() {
    assert object != null;
    assert ridus.doubleValue() > 0;
    assert (angle.doubleValue() >= 0) && (angle.doubleValue() < 360);

  }

  // TODO constructor
  /**
   * constructor.
   * 
   * @param object ����
   * @param ridus �뾶
   * @param angle �Ƕ�
   */
  public Position(E object, Number ridus, Number angle) {
    this.ridus = ridus;
    this.object = object;
    this.angle = angle;
  }


  /**
   * �õ��������ķ���.
   * 
   * @return �������
   */
  public E getobject() {
    return object;
  }


  /**
   * �õ�������弫����뾶�ķ���.
   * 
   * @return ������弫����뾶
   */
  public Number getridus() {
    checkRep();
    return ridus;
  }


  /**
   * �õ�������弫����Ƕȵķ���.
   * 
   * @return ������弫����Ƕ�
   */
  public Number getangle() {

    checkRep();
    return angle;
  }


  /**
   * �ı������弫����Ƕ�.
   * 
   * @param newangle �µļ�����Ƕ�
   */
  public void changeangle(Number newangle) {
    this.angle = newangle;
  }

  /**
   * �ı������弫����뾶.
   * 
   * @param newridus �µİ뾶
   */
  public void changeridus(Number newridus) {
    this.ridus = newridus;
  }



  @Override
  public String toString() {
    StringBuilder str = new StringBuilder();
    str.append(this.object + ": ");
    str.append("(" + this.ridus.doubleValue() + "," + this.angle.doubleValue() + ")");
    return str.toString();
  }
}
