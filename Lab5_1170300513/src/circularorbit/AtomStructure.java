package circularorbit;

import applications.AtomStructureapp;
import atomicstructureexceptions.EnumNotIntException;
import atomicstructureexceptions.OrbitnumNotIntException;
import atomicstructureexceptions.OrbitsumNotIntException;
import centralobject.CentralObject;
import exceptions.ReadFileFailException;
import exceptions.SyntaxErrorException;
import exceptions.TheSameTagRException;
import io.OutStrategy;
import io.ReadStrategy;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import physicalobject.PhysicalObject;
import track.Track;

/**
 * һ��ʵ��CircularOrbit���̳���ConcreteCircularOrbit���࣬�������Q3��AtomStructure.
 * 
 * @author junbaba
 *
 * @param <L> ������������
 * @param <E> �����������
 */
public class AtomStructure<L, E> extends ConcreteCircularOrbit<L, E>
    implements CircularOrbit<L, E> {
  @Override
  public void readfile(String filename, int num) throws IOException, ReadFileFailException {
    Logger log = ConcreteCircularOrbit.log;
    log.addHandler(AtomStructureapp.fh);
    String[] filenames = filename.split(" ");
    String pathname;
    if (filenames.length == 1) {
      pathname = "src\\txt\\" + filename;
    } else {
      pathname = "test\\txt\\" + filenames[1];
    }
    File file = new File(pathname);
    ReadStrategy br = ReadStrategy.empty(file, num);
    String format1 = "(ElementName ::= )([A-Z][a-z]*)";
    String format2 = "(NumberOfTracks ::= )([\\d|.]+)";
    String format3 = "(NumberOfElectron ::= )([\\d|.]+/[\\d|.]+;?)+";
    String elename = null;
    int orbitnum1 = 0;
    int orbitnum2 = 0;
    int flag1 = 0;
    int flag2 = 0;
    int eflag = 0;
    int linecounter = 1;
    String line;
    while ((line = br.readLine()) != null) {
      try {
        Matcher m1 = Pattern.compile(format1).matcher(line);
        Matcher m2 = Pattern.compile(format2).matcher(line);
        Matcher m3 = Pattern.compile(format3).matcher(line);
        while (m1.find()) {
          elename = m1.group(2);
          flag1 = 1;
        }
        while (m2.find()) {
          try {
            orbitnum1 = Integer.valueOf(m2.group(2));
          } catch (Exception e) {
            throw new OrbitsumNotIntException();
          }
          flag2 = 1;
        }
        while (m3.find()) {
          String[] couples = m3.group().split("NumberOfElectron ::= |;");
          orbitnum2 = couples.length - 1;
          for (int i = 1; i < couples.length; i++) {
            String[] numbers = couples[i].split("/");
            int num1 = 0;
            int num2 = 0;
            try {
              num1 = Integer.valueOf(numbers[0]);
            } catch (Exception e) {
              throw new OrbitnumNotIntException();
            }
            Track t = Track.roundcreator(num1);
            super.addorbit(t);
            try {
              num2 = Integer.valueOf(numbers[1]);
            } catch (Exception e) {
              throw new EnumNotIntException();
            }

            for (int j = 1; j <= num2; j++) {
              PhysicalObject p = PhysicalObject.electronicscreator();
              super.addtoorbit((E) p, t);
            }
          }
        }
        m1 = Pattern.compile(format1).matcher(line);
        m2 = Pattern.compile(format2).matcher(line);
        m3 = Pattern.compile(format3).matcher(line);
        if ((!m1.find()) && (!m2.find()) && (!m3.find())) {
          throw new SyntaxErrorException(linecounter, line);
        }
      } catch (TheSameTagRException e) {
        eflag = 1;
        log.severe("line " + linecounter + ": " + line + " : " + e.showwrong());
      } catch (SyntaxErrorException e) {
        eflag = 1;
        String suf = "line " + e.getlinenum() + ": " + e.getline() + " : ";
        String[] words = e.getline().split(" ");
        if (words[0].equals("ElementName")) {
          log.severe(suf + "Element names do not meet grammatical requirements.");
        } else if ((!words[0].equals("NumberOfTracks")) && (!words[0].equals("NumberOfElectron"))) {
          log.severe(suf + "Prefix name mismatch.");
        } else {
          log.severe(suf + "Suffix mismatch.");
        }
      } catch (OrbitsumNotIntException e) {
        eflag = 1;
        log.severe(
            "line " + linecounter + ": " + line + " : The number of orbits is not an integer.");
      } catch (OrbitnumNotIntException e) {
        eflag = 1;
        log.severe("line " + linecounter + ": " + line + " : Orbital number is not an integer.");
      } catch (EnumNotIntException e) {
        eflag = 1;
        log.severe(
            "line " + linecounter + ": " + line + ": The number of electrons is not an integer.");
      } finally {
        linecounter++;
      }
    }
    br.close();
    if (flag1 == 1) {
      CentralObject center = CentralObject.atomcreator(elename);
      super.addcenterobject((L) center);
    }
    if (flag2 == 0 || (orbitnum1 != orbitnum2)) {
      log.severe("NumberOfTracks defines the number of orbits that are inconsistent "
          + "with the number of orbits used in NumberOfElectron");
      throw new ReadFileFailException();
    }
    if (eflag == 1) {
      throw new ReadFileFailException();
    }


  }

  @Override
  public boolean islegal() {
    return true;
  }

  @Override
  public void writefile(int num) throws IOException {
    assert this.center.size() == 1;
    String pathname = "src\\writing\\AtomStructure.txt";
    File file = new File(pathname);
    if (!file.exists()) {
      file.createNewFile();
    }
    OutStrategy fw = OutStrategy.empty(file, num);
    CentralObject center = (CentralObject) getcenter();
    fw.write("ElementName ::= " + center.getname() + "\n");
    fw.write("NumberOfTracks ::= " + orbitscontainobjects.size() + "\n");
    fw.write("NumberOfElectron ::= ");
    for (int i = 0; i < orbitscontainobjects.size(); i++) {
      if (i == orbitscontainobjects.size() - 1) {
        fw.write((i + 1) + "/" + orbitscontainobjects.get(i).getthingsintrack().size());
      } else {
        fw.write((i + 1) + "/" + orbitscontainobjects.get(i).getthingsintrack().size() + ";");
      }
    }
    fw.close();
  }

}
