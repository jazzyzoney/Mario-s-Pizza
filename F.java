 import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.lang.Exception;
import java.io.IOException;

public class F {

  public static void saveObject(Object myObject, String filename) throws IOException {
    FileOutputStream fileOut = null;
    ObjectOutputStream out = null;
    try {
      fileOut = new FileOutputStream(filename + ".ser");
      out = new ObjectOutputStream(fileOut);
      out.writeObject(myObject);
      System.out.println("Serialized data is saved in " + filename);
    } finally {
      if (out != null) {
        out.close();
      }
      if (fileOut != null) {
        fileOut.close();
      }
    }
  }

  public static Object loadObject(String filename) throws IOException, ClassNotFoundException {
    FileInputStream fileIn = null;
    ObjectInputStream in = null;
    try {
      fileIn = new FileInputStream(filename + ".ser");
      in = new ObjectInputStream(fileIn);
      Object myObject = in.readObject();
      System.out.println("Serialized data loaded from " + filename);
      return myObject;
    } finally {
      if (in != null) {
        in.close();
      }
      if (fileIn != null) {
        fileIn.close();
      }
    }
  }
}
