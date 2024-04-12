import java.util.ArrayList;
import java.text.SimpleDateFormat;

public class Orders{
   //datatype time her
   SimpleDateFormat date = new SimpleDateFormat("Y/MM/dd HH:mm");
   String name;
   ArrayList<Pizza> pizzaList = new ArrayList<Pizza>();
   
   public Orders(String name){
      this.date = new SimpleDateFormat("Y/MM/dd HH:mm");
      this.name = name;
   }
}