package relationship;

import java.util.ArrayList;
import java.util.List;

/**
 * һ��relationshipbetweenoo�ľ���ʵ��.
 * 
 * @author junbaba
 *
 */
public class Basicrelationshipbetweenoo<E> implements RelationshipBetweenoo<E> {
  protected final E object;
  protected final List<Socialtie<E>> contacts = new ArrayList<>();

  // Abstraction function:
  // object��Ӧһ������壬contacts�б���ÿһ��Ԫ�ض�Ӧ��ù�����������ϵ��һ���������

  // Representation invariant:
  // contacts != null

  // Safety from rep exposure:
  // ͨ��protectedʹ�������������޷���֪�����е�rep.

  // TODO constructor
  public Basicrelationshipbetweenoo(E object) {
    this.object = object;
  }


  // TODO checkRep
  public void checkRep() {
    assert contacts != null;

  }

  @Override
  public E geto() {
    return object;
  }

  @Override
  public List<Socialtie<E>> getrel() {
    return contacts;
  }

  @Override
  public void addconnection(E newobejct, Number intimacy) {
    Socialtie<E> s = new Socialtie<E>(newobejct, intimacy);
    contacts.add(s);
    checkRep();
  }
}


