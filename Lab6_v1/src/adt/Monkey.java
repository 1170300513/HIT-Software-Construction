package adt;


import java.util.logging.Logger;

import climbstrategy.ClimbStrategy;
import program.MonkeyThroughRiver;

public class Monkey extends Thread {

  Logger log = MonkeyThroughRiver.log;
  private final int id;
  private final String direction;
  private final int velocity;


  // Abstraction function:
  // id��Ӧ���ӱ�ţ�direction��Ӧ���ӹ��ӷ���velocity��Ӧ���������ӵ��ٶ�

  // Representation invariant:
  // direction != null
  // 1 <= velocity <= MV

  // Safety from rep exposure:
  // ͨ��privateʹ���������޷���֪�����е�rep

  // Thread safety:
  // ��run�����У��Թ���ġ����ܻᷢ���̼߳侺��������ʹ��ʱ���������⾺����ͬʱ�����ķ�ΧҪ������С�������ɴ���Ӱ�����ܣ�


  public Monkey(int id, String direction, int velocity) {
    this.id = id;
    this.direction = direction;
    this.velocity = velocity;
  }


  /**
   * ���id�ķ���.
   * 
   * @return id
   */
  public int getid() {
    return id;
  }

  /**
   * ����ٶ�v�ķ���.
   * 
   * @return v
   */
  public int getv() {
    return velocity;
  }

  /**
   * ��÷���direction�ķ���
   * 
   * @return direction
   */
  public String getdirection() {
    return direction;
  }


  @Override
  public String toString() {
    StringBuilder str = new StringBuilder();
    str.append("<monkey:" + id + "," + velocity + "step/s," + direction + ">");
    return str.toString();
  }



  @Override
  public void run() {
    ClimbStrategy strategy = ClimbStrategy.empty(MonkeyThroughRiver.strategynum);
    long start = System.currentTimeMillis();
    int from = 1;
    Ladder ladder = strategy.chooseladder(direction, this);
    int laddernum = MonkeyThroughRiver.ladders.indexOf(ladder);
    if (direction.equals("L->R")) {
      from = 1;
    } else {
      from = ladder.getladder().size();
    }
    while (true) {
      try {
        Thread.sleep(1000);
      } catch (Exception e) {
        e.printStackTrace();
      }
      int endplace = ladder.move(direction, from, velocity);
      long end = System.currentTimeMillis();
      long delta = (end - start) / 1000;
      if (endplace == -1) {
        String line = this.toString() + " arrived at the opposite bank " + "from the " + laddernum
            + " ladder." + "(" + delta + "s from the birth)";
        log.info(line);
        synchronized (MonkeyThroughRiver.loggings) {
          MonkeyThroughRiver.loggings.append(line + "\n");
        }
        break;
      } else {
        String line = this.toString() + " move from " + from + "step to " + endplace + "step "
            + "in the " + laddernum + " ladder." + "(" + delta + "s from the birth)";
        log.info(line);
        synchronized (MonkeyThroughRiver.loggings) {
          MonkeyThroughRiver.loggings.append(line + "\n");
        }
        from = endplace;
      }

    }
    synchronized (MonkeyThroughRiver.finishsum) {
      MonkeyThroughRiver.finishsum++;
    }
    synchronized (MonkeyThroughRiver.arriveorder) {
      MonkeyThroughRiver.arriveorder.add(this.id);

    }
  }
}
