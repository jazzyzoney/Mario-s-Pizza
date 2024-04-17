import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.io.*;

public class Orders implements Serializable{
   SimpleDateFormat date = new SimpleDateFormat("Y/MM/dd HH:mm");
   int name;
   ArrayList<Pizza> pizzaList = new ArrayList<Pizza>();
   
   public Orders(int name){
      this.date = new SimpleDateFormat("Y/MM/dd HH:mm:ss");
      this.name = name;
   }
}