package assist;

/**
 * �����࣬���ڽ������number���ַ���ת��Ϊjava�����е�Number��.
 * 
 * @author junbaba
 *
 */
public class NumBer {

  private final Number num;

  // Abstraction function:
  // ��

  // Representation invariant:
  // num != null

  // Safety from rep exposure:
  // ͨ��privateʹ���������޷���֪�����е�rep

  // TODO checkRep
  public void checkRep() {
    assert num != null;
  }


  // TODO constructor
  /**
   * constructor.
   * 
   * @param str String
   */
  public NumBer(String str) {
    String[] nums = str.split("e");
    if (nums.length == 1) {
      this.num = Double.valueOf(nums[0]);
    } else if (nums.length == 2) {
      double v1 = 0;
      double v2 = 0;
      if ((v1 = Double.valueOf(nums[0])) >= 1 && v1 <= 9 && (v2 = Double.valueOf(nums[1])) >= 3) {
        this.num = v1 * Math.pow(10, v2);
      } else {
        throw new UnsupportedOperationException();
      }
    } else {
      throw new UnsupportedOperationException();
    }
  }


  /**
   * ����num��int��ֵ.
   * 
   * @return num��int��ֵ
   */
  public int intValue() {
    return num.intValue();
  }

  /**
   * ����num��double��ֵ.
   * 
   * @return num��double��ֵ
   */
  public double doubleValue() {
    return num.doubleValue();
  }



}
