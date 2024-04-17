import java.util.*;
import java.io.*;
import java.io.EOFException;

public class Statistics{

   static ArrayList <Orders> completedOrders = new ArrayList <Orders>();
   
   static public void loadsavefile(){
      try {
         OrderList.file = new File("Pizza Info.txt");
         Scanner scan = new Scanner(OrderList.file);
         //for (int i = 0 ; i < 10 ; i++){
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
            
            //System.out.println("ny ordre.");
            
         //System.out.println(scan.next());
         //}
         
      } 
      scan.close();
      }
      catch (Exception e) {
         e.printStackTrace();
      }  
      
      OrderList.printOrders(completedOrders);
         
   }   
    
   ArrayList<Integer> pizzaNumbers = new ArrayList<>();
   ArrayList<Integer> prices = new ArrayList<>();

}