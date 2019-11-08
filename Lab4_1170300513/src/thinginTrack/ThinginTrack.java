package thinginTrack;

import java.util.List;

import track.Track;

/**
 * mutable�Ŀɸ�����ӿ�ThinginTrack<E>������ģ��������������Ĺ�ϵ��
 * @author junbaba
 *
 * @param ������������<E>
 */
public interface ThinginTrack<E> 
{
	
	public static <E> ThinginTrack<E> creator(Track track , String choice)
	{
		if(choice.equals("Basics"))
			return new BasicThinginTrack<>(track);
		else
			throw new UnsupportedOperationException();
	}
	
	
	/**
	 * �õ��ù�ϵ�й��Track�ķ���
	 * @return ���Track
	 */
	public Track gettrack();
	
	/**
	 * ��ù�����������
	 * @param ����e
	 */
	public void addobject(E e);
	
	
	/**
	 * ɾ��λ�ڸù���ϵ�һ������
	 * @param e
	 */
	public void deleteobject(E e);
	
	
	/**
	 * �õ��ù������������Ĺ��ɵ��б�
	 * @return �������幹�ɵ��б�
	 */
	public List<E> getthingsintrack();
}
