import java.util.ArrayList;
import java.text.SimpleDateFormat;

public class Orders{
   static SimpleDateFormat date = new SimpleDateFormat("Y/MM/dd HH:mm");
   String completedTime; 
   String startTime;
   int name;
   ArrayList<Pizza> pizzaList = new ArrayList<Pizza>();
   
   public Orders(int name){
      this.date = new SimpleDateFormat("Y/MM/dd HH:mm:ss");
      this.name = name;
   }
}