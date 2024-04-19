import java.util.*;
import java.io.*;
import java.io.EOFException;

public class Statistics{

   static ArrayList <Orders> completedOrders = new ArrayList <Orders>();
   static int [] mostSoldList;
   static Scanner scanner;
   static int maxSold = 0;
   static int totalSold;
   static int mostSoldPizza;
   static boolean fileDoesNotExist = false;
   
   static public void loadsavefile(){
      try {
         OrderList.file = new File("Pizza Info");
         scanner = new Scanner(OrderList.file);
         
         completedOrders.clear();
         
         while (scanner.hasNext()){
            Orders order = new Orders(1);
            scanner.next();
            
            order.name = scanner.nextInt();
            order.completedTime = scanner.nextLine();
            //System.out.println(order.time);
            
            while (scanner.hasNextInt()){
               int pizzaNo = scanner.nextInt();
               if (pizzaNo <= Menu.menu.size()){
                  order.pizzaList.add(Menu.menu.get(pizzaNo - 1));
               }
            }
            completedOrders.add(order);
            
         }   
         scanner.close();
      }catch (Exception e) {
         //System.out.println(e);
         fileDoesNotExist = true;
      }  
   } //end of load save file()  
   
   public static int totalTurnover(){
      int turnover = 0;
      for(Orders o : completedOrders){
         for (Pizza p : o.pizzaList){
            //System.out.println(p.name + " " + p.price);
            turnover += p.price;
         }
      }
      return turnover;
   }
   
   public static void printCompletedOrders(){
      OrderList.printOrders(completedOrders, true);
   }
   
   public static void mostSold(){
      mostSoldList = new int[Menu.menu.size()];
      
      
      for(Orders o : completedOrders){
         for(Pizza p: o.pizzaList){
            mostSoldList[p.number - 1] ++;
         }
      }
      
      totalSold = 0;
      for(int i = 0; i < mostSoldList.length ; i++){
         totalSold += mostSoldList[i];
         if (mostSoldList[i] > maxSold){
            maxSold = mostSoldList[i];
            mostSoldPizza = i;
         }
      }//end of for loop.
   }
}