package apis;

import assist.Difference;
import circularorbit.CircularOrbit;

public class CircularOrbitApis<L, E> {

  /**
   * �������ϵͳ�и����������ֲ�����ֵ.
   * 
   * @param c Multi-track system
   * @return ����ϵͳ�и����������ֲ�����ֵ
   */
  public double getObjectDistributionEntropy(CircularOrbit<L, E> c) {
    double entropy = 0;
    for (int i = 0; i < c.getorbits().size(); i++) {
      if (c.getorbits().get(i).getthingsintrack().size() > 0) {
        double p = (double) 1 / c.getorbits().get(i).getthingsintrack().size();
        for (int j = 0; j < c.getorbits().get(i).getthingsintrack().size(); j++) {
          entropy += p * Math.log(p);
        }
      }
    }
    return entropy;
  }

  /**
   * ����������������֮�������߼�����.
   * 
   * @param c Multi-track system
   * @param e1 Orbital object
   * @param e2 Orbital object
   * @return e1��e2֮�������߼�����
   */
  public int getLogicalDistance(CircularOrbit<L, E> c, E e1, E e2) {
    return c.getlogicdistance(e1, e2);
  }

  /**
   * ����������������֮����������.
   * 
   * @param c Multi-track system
   * @param e1 Orbital object
   * @param e2 Orbital object
   * @return e1��e2֮����������
   */
  public double getPhysicalDistance(CircularOrbit<L, E> c, E e1, E e2) {
    return c.getphysicaldistance(e1, e2);
  }

  /**
   * ������������ϵͳ֮��Ĳ���.
   * 
   * @param c1 Multi-track system
   * @param c2 Multi-track system
   * @return ��ʾ�������ϵͳ�����Different��
   */
  public Difference<E> getDifference(CircularOrbit<L, E> c1, CircularOrbit<L, E> c2) {
    return new Difference<E>(c1.getorbits(), c2.getorbits());
  }

}
