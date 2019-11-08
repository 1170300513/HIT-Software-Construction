package physicalobject;

import thingintrack.ThinginTrack;
import track.Track;

public class Efactory {

  private static Efactory factory;

  public static Efactory getfactory() {
    if (factory == null)
      factory = new Efactory();
    return factory;
  }

  /**
   * ����������Ӧ�����������(flyweightģʽ).
   */
  public ThinginTrack<PhysicalObject> gete(PhysicalObject e, Track t) {
    ThinginTrack<PhysicalObject> connect = ThinginTrack.creator(t, "Basics");
    connect.addobject(e);
    return connect;
  }

}
