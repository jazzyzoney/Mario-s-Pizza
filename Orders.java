import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.io.*;

public class Orders{
   SimpleDateFormat date = new SimpleDateFormat("Y/MM/dd HH:mm");
   String completedTime; 
   String startTime;
   int name;
   ArrayList<Pizza> pizzaList = new ArrayList<Pizza>();
   
   public Orders(int name){
      this.date = new SimpleDateFormat("Y/MM/dd HH:mm:ss");
      this.name = name;
   }
}