package strategy;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import ladder.Ladder;

/**
 * ����ѡ������������ٵ�����.
 *
 */
public class VacantBestStrategy implements ChooseLadderStrategy {
  /**
   * ���ݺ���������������������.
   */
  protected SortedMap<Integer, Ladder> ladders = Collections
      .synchronizedSortedMap(new TreeMap<Integer, Ladder>(new Comparator<Integer>() {
        public int compare(Integer int1, Integer int2) {
          if (int1 == int2) {
            return 1;
          } else {
            return int1 - int2;
          }
        }
      }));

  /**
   * add ladders to tree map.
   * 
   * @param newLadders - to be sorted.
   */
  public VacantBestStrategy(List<Ladder> newLadders) {
    for (Ladder ladder : newLadders) {
      returnLadder(ladder);
    }
  }

  @Override
  public Ladder getLadder(String direction) {

    // ��÷�����ͬ���޷��������
    Ladder first = null;

    Iterator<Map.Entry<Integer, Ladder>> iterator = ladders.entrySet().iterator();
    while (iterator.hasNext()) {
      first = iterator.next().getValue();
      // �޺��ӻ���һ��
      if (first.getNumMonkeys() == 0 || first.getDirection().equals(direction)) {
        iterator.remove();
        return first;
      }
    }

    return null;
  }

  @Override
  public boolean returnLadder(Ladder ladder) {
    if (ladder == null) {
      return false;
    }
    return ladders.put(ladder.getNumMonkeys(), ladder) != null;
  }
}