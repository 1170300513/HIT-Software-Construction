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
     * �ṩ��clients��֪����뾶�ķ���
     * @return ����뾶ridus
     */
	public Number getridus();
	
 
}
