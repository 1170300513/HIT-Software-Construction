package track;



/**
 * immutable��ADT������ģ������
 * @author junbaba
 *
 */
 public interface Track
{
	/**
	 * ��̬��������������һ��Բ���
	 * @param �뾶ridus
	 * @return Բ���
	 */
	 public static Track Roundcreator(Number ridus)
	 {
		 return new RoundTrack(ridus);
	 }
	 
	 
	 /**
	  *  ��̬��������������һ����Բ���
	  * @param ��Բ����a
	  * @param ��Բ����b
	  * @return ��Բ���
	  */
	 public static Track Ovalcreator(Number a, Number b)
	 {
		 return new OvalTrack(a, b);
	 }
	 
	 
	 
	 /**
	   * �����ж��Ƿ���ȵķ���
	   * @param obj
	   * @return ���Լ�������ͬ���Ϸ���true,���򷵻�false
	   */
	public boolean equals(Track obj);
	 
	 
    /**
     * �ṩ��clients��֪����뾶�ķ���
     * @return ����뾶ridus
     */
	public Number getridus();
	

	/**
	 * �ṩ��clients��֪��Բ����a�ķ���
	 * @return ��Բ����a
	 */
	public Number geta();
 
	
	/**
	 * �ṩ��clients��֪��Բ����b�ķ���
	 * @return ��Բ����b
	 */
	public Number getb();
}
