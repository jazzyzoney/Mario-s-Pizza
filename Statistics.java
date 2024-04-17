import java.util.*;
import java.io.*;
import java.io.EOFException;

public class Statistics{

   static ArrayList <Orders> completedOrders = new ArrayList <Orders>();
   static Scanner scanner;
   
   static public void loadsavefile(){
      try {
         OrderList.file = new File("Pizza Info");
         scanner = new Scanner(OrderList.file);
         
         while (scanner.hasNext()){
            Orders order = new Orders(1);
            scanner.next();
            
            order.name = scanner.nextInt();
            String time = scanner.nextLine();
            System.out.println(time);
            
            while (scanner.hasNextInt()){
               int pizzaNo = scanner.nextInt();
               if (pizzaNo <= Menu.menu.size()){
                  order.pizzaList.add(Menu.menu.get(pizzaNo - 1));
               }
            }
            completedOrders.add(order);
            
         } 
         
         
      }catch (Exception e) {
         System.out.println("fejl: " + e);
      }  
      scanner.close();
      
      //OrderList.printOrders(completedOrders);  
   } //end of load save file()  
   
   public static int totalTurnover(){
      int turnover = 0;
      for(Orders o : completedOrders){
         for (Pizza p : o.pizzaList){
            System.out.println(p.name + " " + p.price);
            turnover += p.price;
         }
      }
      return turnover;
   }
   
   public static void printCompletedOrders(){
      OrderList.printOrders(completedOrders);
   }
   
   public static void mostSold(){
      int [] mostSoldList = new int[Menu.menu.size()];
      
      for(Orders o : completedOrders){
         for(Pizza p: o.pizzaList){
            mostSoldList[p.number - 1] ++;
         }
      }//end of orders loop.
   }
   
}