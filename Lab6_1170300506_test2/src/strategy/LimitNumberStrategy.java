package strategy;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import ladder.Ladder;

/**
 * ����ѡ��������������Һ�������С�������Ƶ�����. ����ȴ���
 *
 */
public class LimitNumberStrategy extends VacantBestStrategy {
  private final int limit;

  /**
   * construct super class.
   * 
   * @param newLadders - ladders
   */
  public LimitNumberStrategy(List<Ladder> newLadders, int limit) {
    super(newLadders);
    this.limit = limit;

  }
  
  @Override
  public Ladder getLadder(String direction) {

    // ��÷�����ͬ���޷��������
    Ladder first = null;

    Iterator<Map.Entry<Integer, Ladder>> iterator = ladders.entrySet().iterator();
    while (iterator.hasNext()) {
      first = iterator.next().getValue();
      if (first.getNumMonkeys() >= limit) {
        return null;
      }
      // �޺��ӻ���һ��
      if (first.getNumMonkeys() == 0 || first.getDirection().equals(direction)) {
        iterator.remove();
        return first;
      }
    }
    return null;
  }
}
