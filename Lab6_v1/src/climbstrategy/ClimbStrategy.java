package climbstrategy;



import adt.Ladder;
import adt.Monkey;

/**
 * Strategyģʽ�����ڱ�ʾ����ѡ����ݵĽӿ�.
 * 
 * @author junbaba
 *
 */
public interface ClimbStrategy {

  /**
   * ��̬��������.
   * 
   */
  public static ClimbStrategy empty(int choice) {
    if (choice == 1) {
      return new WaitUntilEmpty();
    } else if (choice == 2) {
      return new ChooseTheFastest();
    } else {
      throw new UnsupportedOperationException();
    }
  }


  /**
   * ����ѡ����ݵķ���.
   */
  public Ladder chooseladder(String direction, Monkey monkey);


}
