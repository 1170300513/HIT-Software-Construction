package circularorbit;

import assist.Position;
import exceptions.ReadFileFailException;
import exceptions.TheSameTagRException;
import java.io.IOException;
import java.util.List;
import relationship.RelationshipBetweenco;
import relationship.RelationshipBetweenoo;
import thingintrack.ThinginTrack;
import track.Track;



/**
 * mutable�Ŀɸ�����ӿ�CircularOrbit������ģ�����ϵͳ.
 * 
 * @author junbaba
 *
 * @param <L> ����ϵͳ�����ĵ���������
 * @param <E> ������������
 */
public interface CircularOrbit<L, E> {
  /**
   * ����һ��ʵ�� CircularOrbit�ӿڵĶ���ľ�̬��������.
   * 
   * @param choice ѡ��
   * @return boolean
   */
  public static <L, E> CircularOrbit<L, E> empty(String choice) {
    if (choice.equals("Q2")) {
      return new StellarSystem<L, E>();
    } else if (choice.equals("Q3")) {
      return new AtomStructure<L, E>();
    } else if (choice.equals("Q5")) {
      return new SocialNetworkCircle<L, E>();
    } else {
      throw new UnsupportedOperationException();
    }
  }


  /**
   * ����һ�����.
   * 
   * @param neworbit ��Ҫ���ӵ��µ�һ�����
   */
  public void addorbit(Track neworbit) throws TheSameTagRException;


  /**
   * �Ƴ�һ�����.
   * 
   * @param deletedorbit ��Ҫ���Ƴ��Ĺ��
   */
  public void removeorbit(Track deletedorbit);


  /**
   * �������ĵ�����.
   * 
   * @param object ��Ҫ���ӵ�����
   * @return ��ӳɹ�����true�����򷵻�false
   */
  public boolean addcenterobject(L object);


  /**
   * ���ض���������һ������.
   * 
   * @param object ����ӵ�����
   * @param orbit �ض����
   */
  public void addtoorbit(E object, Track orbit) throws TheSameTagRException;


  /**
   * �������ĵ������һ���������֮��Ĺ�ϵ.
   * 
   * @param c ��������
   * @param object �������
   * @param intimacy ���ܶ�
   */
  public void addcontactco(L c, E object, Number intimacy);


  /**
   * ɾ�����ĵ������һ���������֮��Ĺ�ϵ.
   * 
   * @param c ��������
   * @param object �������
   */
  public void deletecontactco(L c, E object);


  /**
   * ���������������֮��Ĺ�ϵ.
   * 
   * @param object1 �������
   * @param object2 �������
   */
  public void addcontactoo(E object1, E object2, Number intimacy);

  /**
   * ɾ�������������֮��Ĺ�ϵ.
   * 
   * @param object1 �������
   * @param object2 �������
   */
  public void deletecontactoo(E object1, E object2);

  /**
   * ���ⲿ�ļ���ȡ���ݹ�����ϵͳ����.
   * 
   * @param filename �ⲿ�ļ��ļ���
   * @throws IOException if has error
   */
  public void readfile(String filename, int num) throws IOException, ReadFileFailException;


  /**
   * �����ϵͳ����д���ļ���.
   * 
   * @throws IOException if has error
   */
  public void writefile(int num) throws IOException;

  /**
   * �� object �ӵ�ǰ���ڹ��Ǩ�Ƶ���� t.
   * 
   * @param object �������
   * @param t Ŀ����
   */
  public void transit(E object, Track t);


  /**
   * Ѱ�����������������߼�����.
   * 
   * @param e1 �������
   * @param e2 �������
   * @return ���e1��e2֮�����������򷵻�������߼����룬���򷵻�-1.
   */
  public int getlogicdistance(E e1, E e2);


  /**
   * �ı�ĳ������Ĺ���Ƕ�.
   * 
   * @param object ����
   * @param sitha �Ƕ�
   */
  public void move(E object, double sitha);


  /**
   * ���������������������.
   * 
   * @param e1 �������
   * @param e2 �������
   * @return �����������������
   */
  public double getphysicaldistance(E e1, E e2);


  /**
   * �ṩ���ͻ��鿴���ϵͳ�й�������������һ������.
   * 
   * @return ������������������һ�����飨���ɸĶ���
   */
  public List<ThinginTrack<E>> getorbits();


  /**
   * �ӹ��ϵͳ��ɾ��ĳ���������.
   * 
   * @param obj �������
   */
  public void deleteorbitobj(E obj);


  /**
   * �ӹ��ϵͳ��ɾ��ĳ����������.
   * 
   * @param obj ��������
   */
  public void deletecentralobj(L obj);


  /**
   * �����жϹ��ϵͳ�Ƿ�Ϸ������StellarSystem��.
   * 
   * @return �Ϸ�����true�����Ϸ��򷵻�false
   */
  public boolean islegal();


  /**
   * ����ĳ�����������������ľ��루���Social Network Circle��.
   * 
   * @param e ����
   * @return ����e�������������ľ���
   */
  public double getdistancefromco(E e);


  /**
   * �ṩ���ͻ��˹����������ķ���.
   * 
   * @return �����������
   */
  public L getcenter();

  /**
   * ������� t ʱ�̸����ǵ�λ�ã����StellarSystem��.
   * 
   * @param t ʱ��
   * @param choice ѡ����Ϊy��Y���ӡ�����򲻴�ӡ
   */
  public void getvpositions(Number t, String choice);

  /**
   * ������Ϣ��ɢ�ȵķ��������Social Network Circle��.
   * 
   * @param friend ����
   * @return ͨ��friend����ʶ��������
   */
  public int getinfodiffu(E friend);


  /**
   * �ṩ���ͻ���ѯĳ����λ�õķ���.
   * 
   * @param obj ����
   * @return ��ʾ����objλ�õ�Position��
   */
  public Position<E> getpositions(E obj);


  /**
   * �ṩ���ͻ���֪�Ĺ��������ϵ�б�ֻ�ܲ鿴�޷��޸ģ�.
   * 
   * @return
   */
  public List<RelationshipBetweenoo<E>> getrelbetweenoo();


  /**
   * �ṩ���ͻ���֪�������������������Ĺ�ϵ�б�ֻ�ܲ鿴�޷��޸ģ�.
   * 
   */
  public List<RelationshipBetweenco<L, E>> getrelbetweenco();
}
