package circularOrbit;


import java.io.IOException;
import java.util.List;

import Exceptions.ReadFileFailException;
import Exceptions.TheSameTagRException;
import assist.Position;
import relationship.relationshipbetweenco;
import relationship.relationshipbetweenoo;
import thinginTrack.ThinginTrack;
import track.Track;



/**
 * mutable�Ŀɸ�����ӿ�CircularOrbit<L,E>������ģ�����ϵͳ��
 * @author junbaba
 *
 * @param ����ϵͳ�����ĵ���������<L>
 * @param ������������<E>
 */
public interface CircularOrbit<L,E> 
{
	
	/**
	 * ����һ��ʵ�� CircularOrbit�ӿڵĶ���ľ�̬��������
	 * @return ʵ�� CircularOrbit�ӿڵĶ���
	 */
	public static <L,E> CircularOrbit<L,E> empty(String choice)
	{
		if(choice.equals("Q2"))
			return new StellarSystem<L,E>();
		else if(choice.equals("Q3"))
			return new AtomStructure<L,E>();
		else if(choice.equals("Q5"))
			return new SocialNetworkCircle<L,E>();
		else
			throw new UnsupportedOperationException();
	}
	
	
	/**
	 * ����һ�����
	 * @param ��Ҫ���ӵ��µ�һ�����neworbit
	 */
	public void addorbit(Track neworbit) throws TheSameTagRException;

	
	/**
	 * �Ƴ�һ�����
	 * @param ��Ҫ���Ƴ��Ĺ��deletedorbit
	 * @return ɾ���ɹ�����true��ʧ���򷵻�false
	 */
	public void removeorbit(Track deletedorbit);
	
	
	/**
	 * �������ĵ�����
	 * @param ��Ҫ���ӵ�����object
	 * @return ��ӳɹ�����true�����򷵻�false
	 */
	public boolean addcenterobject(L object);
	
	
	/**
	 * ���ض���������һ������
	 * @param ����ӵ�����object
	 * @param �ض����orbit
	 */
	public void addtoorbit(E object , Track orbit) throws TheSameTagRException;
	
	
	/**
	 * �������ĵ������һ���������֮��Ĺ�ϵ
	 * @param ��������c
	 * @param �������object
	 * @param ���ܶ�intimacy
	 */
	public void addcontactco(L c , E object , Number intimacy);
	
	
	/**
	 * ɾ�����ĵ������һ���������֮��Ĺ�ϵ
	 * @param ��������c
	 * @param �������object
	 */
	public void deletecontactco(L c , E object);
	
	
	/**
	 * ���������������֮��Ĺ�ϵ
	 * @param �������object1
	 * @param �������object2
	 */
	public void addcontactoo(E object1 , E object2 , Number intimacy);
	
	/**
	 * ɾ�������������֮��Ĺ�ϵ
	 * @param �������object1
	 * @param �������object2
	 */
	public void deletecontactoo(E object1 , E object2);
	
	/**
	 * ���ⲿ�ļ���ȡ���ݹ�����ϵͳ����
	 * @param �ⲿ�ļ��ļ���filename
	 * @throws IOException
	 */
	public void readfile(String filename) throws IOException , ReadFileFailException; 
	
	
	/**
	 * �� object �ӵ�ǰ���ڹ��Ǩ�Ƶ���� t��
	 * @param �������object
	 * @param Ŀ����t
	 */
	public void transit (E object, Track t);
	
	
	/**
	 * Ѱ�����������������߼�����
	 * @param �������e1
	 * @param �������e2
	 * @return ���e1��e2֮�����������򷵻�������߼����룬���򷵻�-1.
	 */
	public int getlogicdistance(E e1 , E e2);

	
	/**
	 * �ı�ĳ������Ĺ���Ƕ�
	 * @param object
	 * @param sitha
	 */
	public void move(E object, double sitha);
	
	
	/**
	 * ���������������������
	 * @param e1
	 * @param e2
	 * @return �����������������
	 */
	public double getphysicaldistance(E e1 , E e2);
	
	
	/**
	 *  �ṩ���ͻ��鿴���ϵͳ�й�������������һ������
	 * @return ������������������һ�����飨���ɸĶ���
	 */
	public List<ThinginTrack<E>> getorbits();
	
	
	/**
	 * �ӹ��ϵͳ��ɾ��ĳ���������
	 * @param obj
	 */
	public void deleteorbitobj(E obj);
	
	
	/**
	 * �ӹ��ϵͳ��ɾ��ĳ����������
	 * @param obj
	 */
	public void deletecentralobj(L obj);
	
	
	/**
	 * �����жϹ��ϵͳ�Ƿ�Ϸ������StellarSystem��
	 * @return �Ϸ�����true�����Ϸ��򷵻�false
	 */
	public boolean islegal();
	
	
	/**
	 * ����ĳ�����������������ľ��루���Social Network Circle��
	 * @param ����e
	 * @return ����e�������������ľ���
	 */
	public double getdistancefromco(E e);
	
	
	/**
	 * �ṩ���ͻ��˹����������ķ���
	 * @return �����������
	 */
	public L getcenter();
	
	/**
	 * ������� t ʱ�̸����ǵ�λ�ã����StellarSystem��
	 * @param ʱ��t
	 * @param ѡ��choice����Ϊy��Y���ӡ�����򲻴�ӡ
	 */
	public void getvpositions(Number t , String choice);
	
	/**
	 * ������Ϣ��ɢ�ȵķ��������Social Network Circle��
	 * @param ����friend
	 * @return ͨ��friend����ʶ��������
	 */
	public int getinfodiffu(E friend);
	
	
	/**
	 * �ṩ���ͻ���ѯĳ����λ�õķ���
	 * @param ����obj
	 * @return ��ʾ����objλ�õ�Position��
	 */
	public Position<E> getpositions(E obj);
	
	
	/**
	 * �ṩ���ͻ���֪�Ĺ��������ϵ�б�ֻ�ܲ鿴�޷��޸ģ�
	 * @return
	 */
	public List<relationshipbetweenoo<E>> getrelbetweenoo();
	
	
	/**
	 * �ṩ���ͻ���֪�������������������Ĺ�ϵ�б�ֻ�ܲ鿴�޷��޸ģ�
	 * @return
	 */
	public List<relationshipbetweenco<L, E>> getrelbetweenco();
}
