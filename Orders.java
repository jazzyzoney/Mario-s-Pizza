import java.util.ArrayList;
import java.util.Scanner;

public class Orders{
   static ArrayList<ArrayList> orderList = new ArrayList <ArrayList>(); 
   
   static Scanner scanner = new Scanner(System.in);
   
   public static void addOrder(int addPizzas){
      
      ArrayList <Pizza> order = new ArrayList <Pizza>();
      for(int i = 0; i < addPizzas; i++){
         System.out.println("Pizza nr: ");
         int pizzaNo = scanner.nextInt();
         
         order.add(Menu.menu.get(pizzaNo));
      }
      orderList.add(order);
   }
   
   public static void printOrders(){
      for (ArrayList order: orderList){ 
         System.out.println("hej");
         System.out.println(order);
         
         for(Pizza p : order){
            System.out.println(p);
         }//end of inner loop
      }//end of outer loop
   }
}