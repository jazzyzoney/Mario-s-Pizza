import java.util.*;
import java.io.*;
import java.io.EOFException;

public class Statistics{

   static ArrayList <Orders> completedOrders = new ArrayList <Orders>();
   
   static public void loadsavefile(){
      try {
         OrderList.file = new File("Pizza Info");
         Scanner scan = new Scanner(OrderList.file);
         
         while (scan.hasNextLine()){
            Orders order = new Orders(1);
            scan.next();
            order.name = scan.nextInt();
            String time = scan.nextLine();
            System.out.println(time);
            
            while (scan.hasNextInt()){
               int pizzaNo = scan.nextInt();
               if (pizzaNo <= Menu.menu.size()){
                  order.pizzaList.add(Menu.menu.get(pizzaNo - 1));
               }
            } 
            completedOrders.add(order);
         } 
         scan.close();
         
      }catch (Exception e) {
         System.out.println("fejl: " + e);
      }  
      
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