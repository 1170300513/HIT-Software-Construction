package track;



/**
 * immutable��ADT������ģ����.
 * 
 * @author junbaba
 *
 */
public interface Track {
  /**
   * ��̬��������������һ��Բ���.
   * 
   * @param ridus �뾶
   * @return Բ���
   */
  public static Track roundcreator(Number ridus) {
    return new RoundTrack(ridus);
  }



  /**
   * �ṩ��clients��֪����뾶�ķ���.
   * 
   * @return ����뾶ridus
   */
  public Number getridus();


}
