package assist;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NumBerTest {


  // Testing strategy:
  // ���˹�ȷ�ϵĽ����ִ�з����Ľ�����жԱȣ��жϷ�������ȷ�ԡ�

  @Test
  public void testIntValue() {
    NumBer num = new NumBer("23");
    assertEquals(23, num.intValue());
  }

  @Test
  public void testDoubleValue() {

    NumBer num = new NumBer("2E7");
    double answer = 2.0E7;
    assertEquals(0, (int) (answer - num.doubleValue()));
  }

}
