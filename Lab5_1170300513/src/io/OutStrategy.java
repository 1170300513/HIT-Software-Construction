package io;

import java.io.File;
import java.io.IOException;

public interface OutStrategy {


  /**
   * ��̬��������������һ��ʵ��OutStrategy�ӿڵ���.
   */
  public static OutStrategy empty(File file, int choice) throws IOException {
    if (choice == 1) {
      return new OutWriter(file);
    } else if (choice == 2) {
      return new OutStream(file);
    } else if (choice == 3) {
      return new OutBuffer(file);
    } else {
      throw new UnsupportedOperationException();
    }
  }

  /**
   * д�ļ��ķ���.
   * 
   * @param line Ҫд����ַ���
   */
  public void write(String line) throws IOException;


  /**
   * �ر��ļ��ķ���.
   */
  public void close() throws IOException;

}
