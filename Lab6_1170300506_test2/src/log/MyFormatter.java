package log;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/**
 * �Զ��������ʽ ��Recorder�е���.
 * 
 */
public class MyFormatter extends Formatter {
  // a��ʾ��ʾ������
  // hh��12Сʱ�� HH��24Сʱ��
  public final SimpleDateFormat sdf = new SimpleDateFormat(Recorder.dateFormat);

  /**
   * ��ǰ�����༰������Thread�е�λ��.
   */

  @Override
  public String format(LogRecord record) {
    @SuppressWarnings("unused")
    String currentTime = sdf.format(new Date());
    String message = record.getMessage();
    return message;
  }

}
