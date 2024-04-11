import java.util.*;

public class Menu{

   static ArrayList<Pizza> menu = new ArrayList<>();

   public static void addPizzamenu(){
      
      
      
      menu.add(new Pizza("Vesuvio", 57));
      menu.add(new Pizza("Amerikaner", 53));
      menu.add(new Pizza("Cacciatore", 57));
      menu.add(new Pizza("Carbona", 63));
      menu.add(new Pizza("Dennis", 65));
      menu.add(new Pizza("Bertil", 57));
      menu.add(new Pizza("Silvia", 61));
      menu.add(new Pizza("Victoria", 61));
      menu.add(new Pizza("Toronfo", 61));
      menu.add(new Pizza("Capricciosa", 61));
      menu.add(new Pizza("Hawaii", 61));
      menu.add(new Pizza("Le Blissola", 61));
      
      int i = 0;
      for(Pizza pizza : menu){
      pizza.number = i +1;
      i ++;
      }
   }
   
   public static void printMenu() {
       System.out.println("Mario's Menu:");
       for (Pizza pizza : menu) {
         pizza.printPizzas();
      }
   }
}