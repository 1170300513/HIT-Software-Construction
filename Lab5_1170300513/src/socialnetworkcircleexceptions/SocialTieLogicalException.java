package socialnetworkcircleexceptions;

public class SocialTieLogicalException extends Exception {
  private String obj;

  public SocialTieLogicalException(String o) {
    this.obj = o;
  }

  /**
   * չʾ����.
   * 
   * @return
   */
  public String showwrong() {
    StringBuilder str = new StringBuilder();
    str.append(obj + " is not defined in Friend and CentralUser.");
    return str.toString();
  }
}
