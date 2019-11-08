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
 * ����ѡ��û�к��ӵ����ӣ����к��ӣ���ѡ��ǰ��������������.
 * 
 */
public class SpeedBestStrategy implements ChooseLadderStrategy {
  /**
   * ������ǰ�����ٶȶ����ӽ�������.
   */
  private SortedMap<Integer, Ladder> ladders = Collections
      .synchronizedSortedMap(new TreeMap<Integer, Ladder>(new Comparator<Integer>() {
        public int compare(Integer int1, Integer int2) {
          if (int1 == int2) {
            return 1;
          } else {
            return int2 - int1;
          }
        }
      }));

  /**
   * add ladders to tree map.
   * 
   * @param newLadders - to be sorted.
   */
  public SpeedBestStrategy(List<Ladder> newLadders) {
    for (Ladder ladder : newLadders) {
      returnLadder(ladder);
    }
    System.out.println("----------init------------");
    System.out.println(ladders.size());
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
    return ladders.put(ladder.getFirstSpeed(), ladder) != null;
  }
}
