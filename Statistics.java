import java.util.*;
import java.io.*;
import java.io.EOFException;

public class Statistics{

   static ArrayList <Orders> completedOrders = new ArrayList <Orders>();
   
   static public void loadsavefile(){
      try {
         OrderList.file = new File("Pizza Info.txt");
         Scanner scan = new Scanner(OrderList.file);
         
         while (scan.hasNextLine()){
            Orders order = new Orders(1);
            scan.next();
            //order.name = scan.nextInt();
            
            System.out.println(" hej ");
            if (scan.hasNextInt()){
               System.out.println("hallo");
               int pizzaNo = scan.nextInt();
               if (pizzaNo <= Menu.menu.size()){
                  order.pizzaList.add(Menu.menu.get(pizzaNo - 1));
               }
               System.out.println(pizzaNo + "goddag");
            } 
            completedOrders.add(order);
         } 
         scan.close();
         
      }catch (Exception e) {
         System.out.println("fejl: " + e);
      }  
      
      OrderList.printOrders(completedOrders);  
   } //end of load save file()  
   
   public static int totalTurnover(){
      int turnover = 0;
      for(Orders o : completedOrders){
         for (Pizza p : o.pizzaList){
            turnover += p.price;
         }
      }
      return turnover;
   }
   
   public static void printCompletedOrders(){
   }
   
   public static void mostSold(){
   }
   
   ArrayList<Integer> pizzaNumbers = new ArrayList<>();
   ArrayList<Integer> prices = new ArrayList<>();

}