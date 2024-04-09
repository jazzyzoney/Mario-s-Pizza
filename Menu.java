import java.util.*;

public class Menu{

   static ArrayList<Pizza> menu = new ArrayList<>();

//name, price, number
   public Menu(){
      Menu.add(new Pizza("Vesuvio", 57, 1));
      Menu.add(new Pizza("Amerikaner", 53, 2));
      Menu.add(new Pizza("Cacciatore", 57, 3));
      
      
   }
}