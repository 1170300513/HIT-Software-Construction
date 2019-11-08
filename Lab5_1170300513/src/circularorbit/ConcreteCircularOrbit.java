package circularorbit;

import assist.Position;
import exceptions.ReadFileFailException;
import exceptions.TheSameTagRException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.logging.Logger;
import physicalobject.PhysicalObject;
import relationship.RelationshipBetweenco;
import relationship.RelationshipBetweenoo;
import relationship.Socialtie;
import thingintrack.ThinginTrack;
import track.Track;


/**
 * һ��CircularOrbit�ӿڵĳ�����.
 * 
 * @author junbaba
 *
 */
public abstract class ConcreteCircularOrbit<L, E> implements CircularOrbit<L, E>, Cloneable {

  // Abstraction function:
  // tracks������ÿ��Ԫ�ض�Ӧһ�������
  // center�������ֻ����һ��Ԫ�أ����ڱ�ʾ���ĵ㡣
  // orbitscontainobjects���ڱ�ʾ�������������Ĺ�ϵ��
  // relbetweenoo�ϵ�ÿ��Ԫ�����ڱ�ʾĳ������ϵĵ�����������ϵĵ�����ϵ��
  // relbetweenco�ϵ�Ԫ�ر�ʾ���ĵ�����������ϵĵ�����ϵ��
  // positions��Ԫ�����ڱ�ʾ���������ļ����꣨��������λ��ʱ��Ҫʹ�ã�

  // Representation invariant:
  // tracks != null
  // center != null
  // objects != null
  // orbitscontainobjects != null
  // relbetweenco != null
  // relbetweenoo != null
  // positions != null


  // Safety from rep exposure:
  // ͨ��protectedʹ�����Ǽ̳������޷���֪�����е�rep.

  protected final List<Track> tracks = new ArrayList<>();
  protected final List<L> center = new ArrayList<>();
  protected final List<E> objects = new ArrayList<>();
  protected final List<ThinginTrack<E>> orbitscontainobjects = new ArrayList<>();
  protected final List<RelationshipBetweenoo<E>> relbetweenoo = new ArrayList<>();
  protected final List<RelationshipBetweenco<L, E>> relbetweenco = new ArrayList<>();
  protected final List<Position<E>> positions = new ArrayList<>();
  public static Logger log = Logger.getLogger("CircularOrbit");

  // TODO checkRep
  /**
   * checkRep.
   */
  public void checkRep() {
    assert tracks != null;
    assert center != null;
    assert orbitscontainobjects != null;
    assert relbetweenco != null;
    assert relbetweenoo != null;
    assert positions != null;
  }


  // TODO constructor
  public ConcreteCircularOrbit() {
    // TODO Auto-generated constructor stub
  }



  @Override
  public void addorbit(Track neworbit) throws TheSameTagRException {
    assert neworbit != null;

    // for (Track t : tracks) {
    // if (t.equals(neworbit)) {
    // log.warning("Failure to add track");
    // throw new TheSameTagRException(neworbit);
    // }
    // }

    tracks.add(neworbit);
    orbitscontainobjects.add(ThinginTrack.creator(neworbit, "Basics"));
    log.info("Successful addition with " + neworbit);
    // sort(tracks, orbitscontainobjects);
    checkRep();
    return;
  }



  @Override
  public void removeorbit(Track deletedorbit) {
    assert deletedorbit != null;
    int i = 0;
    int j = 0;
    int k = 0;
    for (i = 0; i < tracks.size(); i++) {
      Track t1 = tracks.get(i);
      if (t1.equals(deletedorbit)) {
        tracks.remove(t1);
        for (j = 0; j < orbitscontainobjects.size(); j++) {
          ThinginTrack<E> t2 = orbitscontainobjects.get(j);
          if (t2.gettrack().equals(deletedorbit)) {
            for (k = 0; k < t2.getthingsintrack().size(); k++) {
              E o1 = t2.getthingsintrack().get(k);
              deleteorbitobj(o1);
            }
            orbitscontainobjects.remove(t2);
            log.info("Successful track deletion.");
            checkRep();
            return;
          }
        }
      }
    }
    log.warning("Delete track failed.");
    checkRep();
    return;
  }



  @Override
  public void deleteorbitobj(E obj) {
    assert obj != null;
    int i = 0;
    int j = 0;
    int flag = 0;
    for (i = 0; i < objects.size(); i++) {
      E o = objects.get(i);
      if (o.equals(obj)) {
        flag = 1;
        objects.remove(o);
        deleteinrelco(obj, relbetweenco);
        deleteinreloo(obj, relbetweenoo);
        for (i = 0; i < orbitscontainobjects.size(); i++) {
          for (j = 0; j < orbitscontainobjects.get(i).getthingsintrack().size(); j++) {
            if (orbitscontainobjects.get(i).getthingsintrack().get(j).equals(obj)) {
              orbitscontainobjects.get(i).deleteobject(obj);
            }
          }
        }
        log.info("Delete " + obj.toString() + "'s operation succeeded.");
      }
    }
    if (flag != 1) {
      log.warning("Delete operation failed.");
    }
    checkRep();
  }



  @Override
  public void deletecentralobj(L obj) {
    assert obj != null;
    if (center.get(0).equals(obj)) {
      center.remove(0);
      if (relbetweenco.get(0).getc().equals(obj)) {
        relbetweenco.remove(0);
        log.info("Delete " + obj.toString() + "'s operation succeeded.");
        checkRep();
        return;
      }
    }
    log.warning("Delete operation failed.");
    checkRep();
    return;
  }


  @Override
  public boolean addcenterobject(L object) {
    assert object != null;
    if (center.size() == 0) {
      center.add(object);
      relbetweenco.add(RelationshipBetweenco.creator(object, "Basics"));
      log.info("Successful addition with " + object);
      checkRep();
      return true;
    } else {
      checkRep();
      return false;
    }
  }



  @Override
  public void addtoorbit(E object, Track orbit) throws TheSameTagRException {

    assert object != null;
    assert orbit != null;

    // for (E o : objects) {
    // if (o.equals(object)) {
    // log.warning("Failed to add operation.");
    // throw new TheSameTagRException(object);
    // }
    // }

    for (ThinginTrack<E> t : orbitscontainobjects) {
      if (t.gettrack().equals(orbit)) {
        t.addobject(object);
        relbetweenoo.add(RelationshipBetweenoo.creator(object, "Basics"));
        objects.add(object);
        log.info("Successful addition for " + object.toString() + ".");
        checkRep();
        return;
      }
    }
    checkRep();
    return;
  }



  @Override
  public void addcontactco(L c, E object, Number intimacy) {
    assert c != null;
    assert object != null;
    assert intimacy != null;
    int flag = 0;
    for (RelationshipBetweenoo<E> rel : relbetweenoo) {
      if (rel.geto().equals(object)) {
        flag++;
      }
    }
    for (RelationshipBetweenco<L, E> rel : relbetweenco) {
      if (rel.getc().equals(c) && flag == 1) {
        rel.addconnection(object, intimacy);
        flag++;
      }
    }
    checkRep();
    if (flag == 2) {
      log.info("Successful addition with" + c.toString() + " and " + object.toString() + ".");
    } else {
      log.warning("Add operation fail.");
    }
  }


  @Override
  public void deletecontactco(L c, E object) {
    throw new UnsupportedOperationException();
  }


  @Override
  public void addcontactoo(E object1, E object2, Number intimacy) {
    assert object1 != null;
    assert object2 != null;
    assert intimacy != null;
    int flag = 0;
    for (RelationshipBetweenoo<E> rel : relbetweenoo) {
      if (rel.geto().equals(object1)) {
        rel.addconnection(object2, intimacy);
        flag++;
      }
      if (rel.geto().equals(object2)) {
        rel.addconnection(object1, intimacy);
        flag++;
      }
    }
    checkRep();
    if (flag == 2) {
      log.info(
          "Successful addition with" + object1.toString() + " and " + object2.toString() + ".");
    } else {
      log.warning("Add operation fail.");
    }
  }

  @Override
  public void deletecontactoo(E object1, E object2) {
    throw new UnsupportedOperationException();
  }


  @Override
  public abstract void readfile(String filename, int num) throws IOException, ReadFileFailException;


  @Override
  public abstract void writefile(int num) throws IOException;

  @Override
  public void transit(E object, Track t) {
    assert object != null;
    assert t != null;
    int flag = 0;
    int i = 0;
    int j = 0;
    for (i = 0; i < orbitscontainobjects.size(); i++) {
      ThinginTrack<E> orbit = orbitscontainobjects.get(i);
      for (j = 0; j < orbit.getthingsintrack().size(); j++) {
        E o = orbit.getthingsintrack().get(j);
        if (o.equals(object)) {
          orbit.deleteobject(o);
          flag = 1;
        }
      }
    }

    for (i = 0; i < orbitscontainobjects.size(); i++) {
      ThinginTrack<E> orbit = orbitscontainobjects.get(i);
      if (orbit.gettrack().equals(t) && flag == 1) {
        orbit.addobject(object);
        flag++;
      }
    }
    if (flag == 2) {
      log.info("Successful transition.");
    } else {
      log.warning("Transfer failure.");
    }
    checkRep();
    return;
  }



  @Override
  public void move(E object, double sitha) {
    assert object != null;
    int i;
    for (i = 0; i < positions.size(); i++) {
      if (positions.get(i).getobject().equals(object)) {
        positions.get(i).changeangle(sitha);
      }
    }
  }


  @Override
  public L getcenter() {
    if (center.size() > 0) {
      return center.get(0);
    } else {
      System.out.println("No central object exists.");
      throw new UnsupportedOperationException();
    }
  }

  @Override
  public int getlogicdistance(E e1, E e2) {
    assert e1 != null;
    assert e2 != null;
    int mycounter = 0;
    int pre = 0;
    int last = 1;
    int mid = 1;
    Queue<Integer> queue = new LinkedList<>();
    boolean[] visit = new boolean[objects.size()];
    int e1num = find(objects, e1);
    int e2num = find(objects, e2);
    queue.offer(e1num);
    while (queue.peek() != null) {
      int i = queue.poll();
      visit[i] = true;
      if (visit[e2num] == true) {
        break;
      }
      pre++;
      E e = objects.get(i);
      for (Socialtie<E> obj : getlist(relbetweenoo, e)) {
        int m = find(objects, obj.getobj());
        if (visit[m] != true) {
          queue.offer(m);
          last++;
        }
      }
      if (pre == mid) {
        mid = last;
        mycounter++;
      }
    }
    checkRep();
    if (visit[e2num] == true) {
      return mycounter;
    } else {
      return -1;
    }
  }


  @Override
  public double getphysicaldistance(E e1, E e2) {
    assert e1 != null;
    assert e2 != null;
    int i = 0;
    int j = 0;
    int flag = 0;
    for (i = 0; i < positions.size(); i++) {
      if (positions.get(i).getobject().equals(e1)) {
        flag++;
        break;
      }
    }
    for (j = 0; j < positions.size(); j++) {
      if (positions.get(j).getobject().equals(e2)) {
        flag++;
        break;
      }
    }
    if (flag == 2) {
      double r1 = positions.get(i).getridus().doubleValue();
      double r2 = positions.get(j).getridus().doubleValue();
      double deltaangle = positions.get(i).getangle().doubleValue() / 180 * Math.PI
          - positions.get(j).getangle().doubleValue() / 180 * Math.PI;
      double result =
          Math.sqrt(Math.pow(r1, 2) + Math.pow(r2, 2) - 2 * r1 * r2 * Math.cos(deltaangle));
      return result;
    } else {
      return -1;
    }
  }

  @Override
  public double getdistancefromco(E e) {
    assert e != null;
    int i;
    double dis = -1;
    for (i = 0; i < positions.size(); i++) {
      if (positions.get(i).getobject().equals(e)) {
        dis = positions.get(i).getridus().doubleValue();
      }
    }
    return dis;
  }


  @Override
  public List<ThinginTrack<E>> getorbits() {
    return List.copyOf(orbitscontainobjects);
  }



  @Override
  public void getvpositions(Number t, String choice) {
    assert t != null;
    assert choice != null;
    for (E obj : objects) {
      for (Position<E> p : positions) {
        if (p.getobject().equals(obj)) {
          PhysicalObject planet = (PhysicalObject) obj;
          double length = t.doubleValue() * planet.getv().doubleValue();
          double newangle = 0;
          int flag = 0;
          double tempangle = ((length / p.getridus().doubleValue()) * 180 / Math.PI) % 360;
          if (planet.getdirection().equals("CW")) {
            newangle = (p.getangle().doubleValue() + tempangle) % 360;
            flag = 1;
          } else if (planet.getdirection().equals("CCW")) {
            if (p.getangle().doubleValue() >= tempangle) {
              newangle = p.getangle().doubleValue() - tempangle;
            } else {
              newangle = p.getangle().doubleValue() - tempangle + 360;
            }
            flag = 1;
          }
          if (flag == 1) {
            p.changeangle(newangle);
          }
          if (choice.equals("Y")) {
            System.out.println(p);
          }
        }
      }
    }
  }


  @Override
  public Position<E> getpositions(E obj) {
    assert obj != null;
    for (Position<E> p : positions) {
      if (p.getobject().equals(obj)) {
        return p;
      }
    }
    throw new UnsupportedOperationException();
  }



  @Override
  public List<RelationshipBetweenoo<E>> getrelbetweenoo() {
    return List.copyOf(relbetweenoo);
  }


  @Override
  public List<RelationshipBetweenco<L, E>> getrelbetweenco() {
    return List.copyOf(relbetweenco);
  }



  @Override
  public abstract boolean islegal();


  @Override
  public int getinfodiffu(E friend) {
    throw new UnsupportedOperationException();
  }


  @Override
  public Object clone() throws CloneNotSupportedException {
    // TODO Auto-generated method stub
    return super.clone();
  }

  /**
   * ���˶���ĸ�������������Ѱ��objects������object���±�.
   * 
   * @param objects �����б�
   * @param object ����
   * @return objects������object���±�
   */
  protected int find(List<E> objects, E object) {
    assert objects != null;
    assert object != null;
    int i;
    for (i = 0; i < objects.size(); i++) {
      if (objects.get(i).equals(object)) {
        return i;
      }
    }
    return -1;
  }


  /**
   * ���˶���ĸ���������������������object����ϵ�����й����������ɵ��б�.
   * 
   * @param relbetweenoo relationshipbetweenoo
   * @param object E
   * @return ��������object����ϵ�����й����������ɵ��б�
   */
  protected List<Socialtie<E>> getlist(List<RelationshipBetweenoo<E>> relbetweenoo, E object) {
    assert relbetweenoo != null;
    assert object != null;
    int i;
    for (i = 0; i < relbetweenoo.size(); i++) {
      if (relbetweenoo.get(i).geto().equals(object)) {
        return relbetweenoo.get(i).getrel();
      }
    }
    return null;
  }

  /**
   * ���˶���ĸ�������������������.
   * 
   * @param tracks List<Track>
   * @param orbitscontainobjects ThinginTrack
   */
  protected void sort(List<Track> tracks, List<ThinginTrack<E>> orbitscontainobjects) {
    assert tracks != null;
    assert orbitscontainobjects != null;
    int i = 0;
    int j = 0;
    for (i = 0; i < tracks.size(); i++) {
      for (j = i; j < tracks.size(); j++) {
        if (tracks.get(i).getridus().doubleValue() > tracks.get(j).getridus().doubleValue()) {
          Track t = tracks.get(i);
          tracks.set(i, tracks.get(j));
          tracks.set(j, t);

        }
      }
    }
    for (i = 0; i < orbitscontainobjects.size(); i++) {
      for (j = i; j < orbitscontainobjects.size(); j++) {
        if (orbitscontainobjects.get(i).gettrack().getridus().doubleValue() > orbitscontainobjects
            .get(j).gettrack().getridus().doubleValue()) {
          ThinginTrack<E> t = orbitscontainobjects.get(i);
          orbitscontainobjects.set(i, orbitscontainobjects.get(j));
          orbitscontainobjects.set(j, t);
        }
      }
    }

    return;
  }


  /**
   * ��������������������obj�йص�����������������Ĺ�ϵ.
   * 
   * @param obj E
   * @param relbetweenoo relationshipbetweenco
   */
  protected void deleteinrelco(E obj, List<RelationshipBetweenco<L, E>> relbetweenco) {
    assert obj != null;
    assert relbetweenco != null;
    int i;
    if (relbetweenco.size() != 0) {
      for (i = 0; i < relbetweenco.get(0).getrel().size(); i++) {
        Socialtie<E> s = relbetweenco.get(0).getrel().get(i);
        if (s.getobj().equals(obj)) {
          relbetweenco.get(0).getrel().remove(s);
        }
      }
    }
  }


  /**
   * ��������������������obj�йصĹ��������������Ĺ�ϵ.
   * 
   * @param obj E
   * @param relbetweenoo relationshipbetweenoo
   */
  protected void deleteinreloo(E obj, List<RelationshipBetweenoo<E>> relbetweenoo) {
    assert obj != null;
    assert relbetweenoo != null;
    int i = 0;
    int j = 0;
    int k = 0;
    int l = 0;
    List<Socialtie<E>> relative = new ArrayList<>();
    for (i = 0; i < relbetweenoo.size(); i++) {
      RelationshipBetweenoo<E> rel = relbetweenoo.get(i);
      if (rel.geto().equals(obj)) {
        relative = rel.getrel();
        relbetweenoo.remove(rel);
      }
    }
    for (j = 0; j < relative.size(); j++) {
      Socialtie<E> s = relative.get(j);
      for (k = 0; k < relbetweenoo.size(); k++) {
        RelationshipBetweenoo<E> rel = relbetweenoo.get(k);
        if (s.getobj().equals(rel.geto())) {
          for (l = 0; l < rel.getrel().size(); l++) {
            Socialtie<E> s2 = rel.getrel().get(l);
            if (s2.getobj().equals(obj)) {
              rel.getrel().remove(s2);
            }
          }
        }
      }
    }
  }
}
