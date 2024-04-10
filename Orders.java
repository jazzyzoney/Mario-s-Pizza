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
      
      for(int i = 0; i < addPizzas; i++){//adding pizzas to order arraylist
         System.out.println("Pizza nr: ");
         boolean sentinel;//sentinel
         
         do{
            try{
               int pizzaNo = scanner.nextInt() - 1;
               order.add(Menu.menu.get(pizzaNo));
               sentinel = true;
            }catch(Exception e){
               System.out.println("fejl: " + e);
               System.out.println("indtast et tal fra pizzamenuen");
               scanner.next();
               sentinel = false;
            }
         }while(sentinel == false); 
      }//end of for loop.
      
      orderList.add(order);//adding order arraylist to orderlist arraylist
   }//end of add pizzas method
   
   
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
         file = new File("Pizza Info");//creates new savefile if none exists
         if (!file.exists()){
            file.createNewFile();
         }
         
         writer = new FileWriter("Pizza Info", true);
         writer.write("a\n");//marks new order
         for (int i = 0; i < orderList.get(orderNo - 1).size(); i++){//writing index and price to file for each pizza
            writer.write(orderList.get(orderNo -1).get(i).number + " " + orderList.get(orderNo -1).get(i).price + "\n");//virker ikke :/
         }
         
         writer.close();

      }catch(Exception e){
         System.out.println("fejl: " + e);
      }
      orderList.remove(orderNo -1);
   }
}