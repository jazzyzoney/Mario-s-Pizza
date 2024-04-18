import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.text.SimpleDateFormat;

public class OrderList{
   static ArrayList<Orders> orderList = new ArrayList <Orders>();
   static Scanner scanner = new Scanner(System.in);
   static File file;
   static FileWriter writer;
   static int orderCounter=0; 

   public static void addOrder(int addPizzas){// int addPizzas = the amount of pizzas to be added to the order.
      orderCounter++;
      int orderName = orderCounter;
      Orders order = new Orders(orderName);
      
      for(int i = 0; i < addPizzas; i++){//adding pizzas to order arraylist
         System.out.println("Pizza nr: " + (i+1));
         
         boolean sentinel;//sentinel
         do{
            try{
               int menuNo = scanner.nextInt() - 1;
                order.pizzaList.add(Menu.menu.get(menuNo));
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
   
   public static void printOrders(ArrayList <Orders> printList){
      Date currentDate = new Date();
      for(Orders order : printList){
         //System.out.println("Order Name: " + order.name + ", Date: " + order.date.format(currentDate));
         System.out.print(order.name + ": "); 
         
         for (Pizza pizza : order.pizzaList){
            System.out.print(pizza.name + ", ");
            System.out.println(pizza.number + ", " + pizza.price + " kr." + " " + order.time);
         }
      }
   }
   
   public static void completeOrder(int orderNo){
      orderNo --;
      //orderList.remove(orderNo);
      
      try{
         file = new File("Pizza Info");//creates new savefile if none exists
         if (!file.exists()){
            file.createNewFile();
         }
         
        // ArrayList<Orders> completedOrder = new ArrayList <Orders>();
        // completedOrder.add(orderList.get(orderNo)); 
        // F.saveStringArray(completedOrder, "pizza info");
         
        // writing to file:
        writer = new FileWriter("Pizza Info", true);
        Date currentDate = new Date();
        SimpleDateFormat date = new SimpleDateFormat(" Y/MM/dd, HH:mm:ss");
        writer.write("a\n" + orderList.get(orderNo).name + date.format(currentDate));//marks new order
        for (Pizza p : orderList.get(orderNo).pizzaList){
            writer.write("\n" + p.number);
         }
         writer.write("\n");
         writer.close();
      
      }catch(Exception e){
         System.out.println("fejl: " + e);
      }
      orderList.remove(orderNo);
   }
   
   public static void deleteOrder(int orderNo){
      orderNo--;
      orderList.remove(orderNo);
      //System.out.println("Ordre nr. " + (orderNo + 1) + " slettet.");
   }
}