package exceptions;

/**
 * ������������ϳ��ֱ�ǩ��ͬ������쳣.
 * 
 * @author junbaba
 *
 */
public class TheSameTagRException extends Exception {
  private Object obj = null;

  public TheSameTagRException(Object o) {
    this.obj = o;
  }

  /**
   * չʾ����.
   */
  public String showwrong() {
    StringBuilder str = new StringBuilder();
    str.append(obj.toString() + " is already in the CircularOrbit System!");
    return str.toString();
  }
}
