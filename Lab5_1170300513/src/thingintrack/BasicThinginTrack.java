package thingintrack;

import java.util.ArrayList;
import java.util.List;
import track.Track;

/**
 * һ��ThinginTrack�ӿڵľ���ʵ��.
 * 
 * @author junbaba
 *
 * @param <E> ������������
 */
public class BasicThinginTrack<E> implements ThinginTrack<E> {
  protected final Track track;
  protected final List<E> orbitobjects = new ArrayList<>();

  // Abstraction function:
  // track��Ӧ�����orbitobjects��ÿһ��Ԫ�ض�Ӧ�����һ������

  // Representation invariant:
  // track != null
  // orbitobjects != null

  // Safety from rep exposure:
  // ͨ��protectedʹ�������������޷���֪�����е�rep.


  // TODO checkRep
  public void checkRep() {
    assert track != null;
    assert orbitobjects != null;
  }

  // TODO constructor
  public BasicThinginTrack(Track track) {
    this.track = track;
  }

  @Override
  public Track gettrack() {
    return track;
  }

  @Override
  public void addobject(E e) {
    orbitobjects.add(e);
  }

  @Override
  public List<E> getthingsintrack() {
    return orbitobjects;
  }

  @Override
  public void deleteobject(E e) {
    int i;
    for (i = 0; i < orbitobjects.size(); i++) {
      E object = orbitobjects.get(i);
      if (object.equals(e)) {
        orbitobjects.remove(object);
      }
    }

  }

}
