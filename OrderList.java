import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class OrderList{
   static ArrayList<Orders> orderList = new ArrayList <Orders>();
   static Scanner scanner = new Scanner(System.in);
   static File file;
   static FileWriter writer;

   public static void addOrder(int addPizzas){
      String orderName = "";//add scanner here
      Orders order = new Orders(orderName);
      
      for(int i = 0; i < addPizzas; i++){//adding pizzas to order arraylist
         System.out.println("Pizza nr skal være?: " + (i+1));
         
         boolean sentinel;//sentinel
         do{
            try{
               int pizzaNo = scanner.nextInt() - 1;
               order.pizzaList.add(Menu.menu.get(pizzaNo));
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
      for(Orders order : orderList){
         for (Pizza pizza : order.pizzaList){
            System.out.print(pizza.name + ", ");
            System.out.println(pizza.number + ", " + pizza.price + " kr");
         }
      }      
   }
   
   public static void completeOrder(int orderNo){
      orderNo --;
      try{
         file = new File("Pizza Info");//creates new savefile if none exists
         if (!file.exists()){
            file.createNewFile();
         }
         
         writer = new FileWriter("Pizza Info", true);
         writer.write("a\n");//marks new order

         /*for (int i = 0; i < orderList.get(orderNo).size(); i++){//writing index and price to file for each pizza
            writer.write(orderList.get(orderNo).get(i).number + " " + orderList.get(orderNo).get(i).price + "\n");
         }*/
         
         writer.close();

      }catch(Exception e){
         System.out.println("fejl: " + e);
      }
      orderList.remove(orderNo);
   }
   
   public static void deleteOrder(int orderNo){
      orderNo--;
      orderList.remove(orderNo);
      System.out.println("Ordre nr. " + (orderNo + 1) + " slettet.");
   }

}