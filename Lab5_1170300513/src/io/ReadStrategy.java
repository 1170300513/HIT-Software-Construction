package io;

import java.io.File;
import java.io.IOException;

public interface ReadStrategy {


  /**
   * ��̬��������������һ��ʵ��ReadStrategy����.
   */
  public static ReadStrategy empty(File file, int choice) throws IOException {
    if (choice == 1) {
      return new ReaderRead(file);
    } else if (choice == 2) {
      return new StreamRead(file);
    } else if (choice == 3) {
      return new BufferRead(file);
    } else {
      throw new UnsupportedOperationException();
    }
  }


  /**
   * ���ж��ļ��ķ���.
   * 
   * @return �ļ���ĳһ��.
   */
  public String readLine() throws IOException;



  /**
   * �ر��ļ��ķ���.
   */
  public void close() throws IOException;

}
