import java.util.*;

public class Menu{

   static ArrayList<Pizza> menu = new ArrayList<>();

   public static void addPizzamenu(){
      menu.add(new Pizza("Vesuvio", 57, 1));
      menu.add(new Pizza("Amerikaner", 53, 2));
      menu.add(new Pizza("Cacciatore", 57, 3));
   }
   public static void printMenu() {
       System.out.println("Mario's Menu:");
       for (Pizza pizza : menu) {
         pizza.printPizzas();
      }
   }
}