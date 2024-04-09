import java.util.ArrayList;
import java.util.Scanner;

public class Orders{
   static ArrayList<Pizza> orderList = new ArrayList <Pizza>();
   static Scanner scanner = new Scanner(System.in);
   
   public static void addOrder(int addPizzas){
      for(int i = 0; i <= addPizzas; i++){
         System.out.println("Pizza nr: ");
         int pizzaNo = scanner.nextInt();
         orderList.add(Menu.menu.get(pizzaNo));
      }
   }
}