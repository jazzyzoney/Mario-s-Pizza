import java.util.*;

public class Menu{

   static ArrayList<Pizza> menu = new ArrayList<>();

   public static void addPizzamenu(){
   
      menu.add(new Pizza("Vesuvio", 57));
      menu.add(new Pizza("Amerikaner", 54));
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
      menu.add(new Pizza("Blizz", 61));
      menu.add(new Pizza("Venezia", 61));
      menu.add(new Pizza("Mafia", 61));
      menu.add(new Pizza("Le Blissola", 61));
      menu.add(new Pizza("Frittelli", 52));
      menu.add(new Pizza("Mamma Mia!", 55));
      menu.add(new Pizza("Vino Buono", 57));
      menu.add(new Pizza("Ciao Bella", 120));
      menu.add(new Pizza("Pizzalocca", 56));
      menu.add(new Pizza("Salutiamo", 61));
      menu.add(new Pizza("Gelatoni", 57));
      menu.add(new Pizza("Il Tigre", 61));
      menu.add(new Pizza("Luigi", 62));
      menu.add(new Pizza("Wario", 55));
      menu.add(new Pizza("Cannolironi", 57));
      menu.add(new Pizza("Mozzarelloti", 54));
      menu.add(new Pizza("Pepperonata", 65));
      menu.add(new Pizza("Pomodorosso", 63));
      
      int i = 0;
      for(Pizza pizza : menu){
         pizza.number = i +1;
         i ++;
      }
      
      System.out.println("Page (1, 2, or 3): ");
      
   }
   
   public static void pizzaMenuCard(int menuChoice) {
      System.out.println("###############################################################################################");
      System.out.println("Mario's Menu:");
   
      if (!menu.isEmpty()) {
         int startIndex, endIndex;
         switch (menuChoice) {
            case 1:
               startIndex = 0;
               endIndex = 10;
               break;
            case 2:
               startIndex = 10;
               endIndex = 20;
               break;
            case 3:
               startIndex = 20;
               endIndex = 30;
               break;
            default:
               System.out.println("Invalid.");
               return;
         }
      
         for (int i = startIndex; i < endIndex; i++) {
            Pizza pizza = menu.get(i);
            System.out.println(pizza.number + ". " + pizza.name + " - " + pizza.price + "kr.");
         }
      } 
      System.out.println("###############################################################################################");
   }
}