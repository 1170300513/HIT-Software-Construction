package assist;

/**
 * ���ڸ�����ͼʹ�õ����ݽṹ������RI,AF��.
 * 
 * @author junbaba
 *
 * @param <E> �����������
 */
public class DrawPosition<E> {
  public int xpos;
  public int ypos;
  public E object;

  /**
   * ���췽��.
   */
  public DrawPosition(E object, int x, int y) {
    this.xpos = x;
    this.ypos = y;
    this.object = object;
  }
}
