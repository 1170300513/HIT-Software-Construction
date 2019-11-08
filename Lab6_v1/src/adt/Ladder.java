package adt;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import program.MonkeyThroughRiver;

/**
 * ����ģ�����ӵ���.
 * 
 * @author junbaba
 *
 */
public class Ladder {

  private final Map<Integer, Monkey> ladder = Collections.synchronizedMap(new HashMap<>());
  private Logger log = MonkeyThroughRiver.log;

  // Abstraction function:
  // ladder��ÿһ��Ԫ�ض�Ӧ�����ϵ�һ��̨��.

  // Representation invariant:
  // ladder != null

  // Safety from rep exposure:
  // ͨ��privateʹ���������޷���֪�����е�rep

  // Thread safety:
  // �ڿ��ܷ��������ķ������Ը÷���������ʹ��ֻ��ĳ���߳��ܹ����ø÷�����ʹ���̰߳�ȫ������Collections.synchronizedMap.


  /**
   * ���췽��.
   */
  public Ladder(int h) {
    for (int i = 1; i <= h; i++) {
      ladder.put(i, null);
    }
  }


  /**
   * ���ر�ʾ���ӵ�Map.
   * 
   * @return ��ʾ���ӵ�Map.
   */
  public Map<Integer, Monkey> getladder() {
    return ladder;
  }


  /**
   * �ú��Ӵ�����¥�ݣ���ʱҪ�Ը÷���������.
   */
  public synchronized void upfromL(Monkey monkey) {
    if (ladder.get(1) == null) {
      ladder.replace(1, monkey);
      log.info(monkey + " climb the ladder from L.");
    }
  }

  /**
   * �ú��Ӵ��Ұ���¥�ݣ���ʱҪ�Ը÷���������.
   */
  public synchronized void upfromR(Monkey monkey) {
    if (ladder.get(ladder.size()) == null) {
      ladder.replace(ladder.size(), monkey);
      log.info(monkey + " climb the ladder from L.");
    }
  }

  /**
   * ģ������ڽ������ƶ��ķ���.
   * 
   * @return �ƶ����յ㣨����������ӷ�Χ����-1��.
   */
  public synchronized int move(String direction, int from, int distance) {
    int end = from;
    if (direction.equals("L->R")) {
      for (int i = 1; i <= distance; i++) {
        if (from + i > ladder.size()) {
          end = -1;
          break;
        } else if (ladder.get(from + i) != null) {
          end = from + i - 1;
          break;
        } else {
          end = from + i;
        }
      }
    } else {
      for (int i = 1; i <= distance; i++) {
        if (from - i <= 0) {
          end = -1;
          break;
        } else if (ladder.get(from - i) != null) {
          end = from - i + 1;
          break;
        } else {
          end = from - i;
        }
      }
    }
    if (end == -1) {
      ladder.replace(from, null);
    } else if (end != from) {
      ladder.replace(end, ladder.get(from));
      ladder.replace(from, null);
    }
    return end;
  }

  public synchronized boolean isempty() {
    int flag = 0;
    for (int i = 1; i <= this.ladder.size(); i++) {
      if (ladder.get(i) != null) {
        flag = 1;
      }
    }
    if (flag == 0) {
      return true;
    } else {
      return false;
    }
  }

}
