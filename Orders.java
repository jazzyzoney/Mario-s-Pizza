import java.util.ArrayList;
import java.util.Scanner;

public class Orders{
   static ArrayList<ArrayList<Pizza>> orderList = new ArrayList <ArrayList<Pizza>>(); 
   
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
   int i = 0;
      for (ArrayList order : orderList){
                  
         int j = 0;
         for (Pizza p : orderList.get(i)){
            System.out.println(orderList.get(i).get(j).name);
            j ++;      
         }//end of inner loop
         i ++;
      }//end of outer loop
   }
}