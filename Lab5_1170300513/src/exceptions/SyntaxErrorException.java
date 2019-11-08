package exceptions;

/**
 * �����������ļ��е��﷨������쳣.
 * 
 * @author junbaba
 *
 */
public class SyntaxErrorException extends Exception {
  private int linenum;
  private String line;

  public SyntaxErrorException() {
    // TODO Auto-generated constructor stub
  }

  public SyntaxErrorException(int linenum, String line) {
    this.linenum = linenum;
    this.line = line;
  }


  public int getlinenum() {
    return linenum;
  }

  public String getline() {
    return line;
  }
}
