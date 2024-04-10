import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Orders{
   static ArrayList<ArrayList<Pizza>> orderList = new ArrayList <ArrayList<Pizza>>(); //nested arraylist. 
   static Scanner scanner = new Scanner(System.in);
   static File file;
   static FileWriter writer;

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
   
   public static void completeOrder(int orderNo){
      
      try{
         file = new File("Pizza Info");
         if (!file.exists()){
            file.createNewFile();
         }
         
         writer = new FileWriter("Pizza Info", true);
         writer.write(orderList.get(orderNo -1).get(0).name + "\n");
         writer.close();

      }catch(Exception e){
         System.out.println("fejl: " + e);
      }
      orderList.remove(orderNo -1);
   }
}