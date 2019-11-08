package log;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import log.MyFormatter;

/**
 * ��־��¼
 *
 */
public class Recorder {
  private String name = Recorder.class.getName();
  private Handler handler;
  public static final String dateFormat = "yyyy-MM-dd HH:mm:ss";
  private Logger log;

  /**
   * log.
   * 
   * @param logPath - log Ŀ¼.
   */
  public Recorder(String logPath) {
    try {
      log = Logger.getLogger(name);
      // ָ��logĿ¼
      handler = new FileHandler(logPath);
      handler.setLevel(Level.INFO);
      handler.setFormatter(new MyFormatter());
      log.addHandler(handler);
    } catch (SecurityException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void log(String msg) {
    log.info(msg + "\n");
  }
}
