package physicalobject;


/**
 * һ��PhysicalObject�ӿڵľ���ʵ�֣�����StellarSystem��.
 * 
 * @author junbaba
 *
 */
public class Planet implements PhysicalObject {


  private final String name;
  private final String form;
  private final String color;
  private final Number planetr;
  private final Number velocity;
  private final String direction;

  // Abstraction function:
  // name��Ӧ�������ƣ�form��Ӧ������̬��color��Ӧ������ɫ��planetr��Ӧ���ǰ뾶��
  // v��Ӧ���ǹ�ת�ٶȣ�direction��Ӧ���ǹ�ת����

  // Representation invariant:
  // name != null
  // form != null
  // color != null
  // planetr > 0 , v > 0
  // direction != null

  // Safety from rep exposure:
  // ͨ��privateʹ���������޷���֪�����е�rep


  // TODO checkRep
  /**
   * checkRep.
   */
  public void checkRep() {
    assert name != null;
    assert form != null;
    assert color != null;
    assert planetr.doubleValue() > 0;
    assert velocity.doubleValue() > 0;
    assert direction != null;

  }


  // TODO constructor
  /**
   * ���췽��.
   */
  public Planet(String name, String form, String color, Number planetr, Number v,
      String direction) {
    this.name = name;
    this.form = form;
    this.color = color;
    this.planetr = planetr;
    this.velocity = v;
    this.direction = direction;
    checkRep();
  }

  @Override
  public String getform() {
    return form;
  }

  @Override
  public String getcolor() {
    return color;
  }

  @Override
  public Number getplanetr() {
    checkRep();
    return planetr;
  }



  @Override
  public Number getv() {
    checkRep();
    return velocity;
  }


  @Override
  public String getdirection() {
    return direction;
  }

  @Override
  public String getname() {
    return name;
  }

  @Override
  public String getsex() {
    throw new UnsupportedOperationException();
  }

  @Override
  public Number getages() {
    throw new UnsupportedOperationException();
  }

  @Override
  public boolean equals(Object obje) {
    if (obje == null) {
      return false;
    }
    PhysicalObject obj = (PhysicalObject) obje;
    if (this.name.equals(obj.getname()) && this.form.equals(obj.getform())
        && this.color.equals(obj.getcolor()) && this.direction.equals(obj.getdirection())
        && this.planetr.doubleValue() == obj.getplanetr().doubleValue()) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public int hashCode() {
    return name.length() + form.length() + color.length() + direction.length() + planetr.intValue();
  }

  @Override
  public String toString() {
    StringBuilder str = new StringBuilder();
    str.append("<" + name + ": " + form + "," + color + "," + planetr.doubleValue() + "km,"
        + velocity.doubleValue() + "km/s," + direction + ">");
    return str.toString();
  }

}
