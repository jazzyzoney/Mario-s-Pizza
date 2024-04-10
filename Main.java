import java.util.Scanner;
import javax.swing.*;

public class Main{
   static Scanner scanner = new Scanner (System.in);
   public static void main (String [] args){
      String Letters = ""; 
      System.out.print("Mamma mia velkommen til Mario's pizza order system");
      Menu.addPizzamenu();
      Menu.printMenu();
      System.out.print("du har nu fire valgmuligheder");
            System.out.print("add" + "" + "som tilf�jer en ny order" + "" + "done" + ""+ "done som f�rdigg�r orderen"+ "" + "view" + "hvor man kan se ordre"+ "" + "q" + "som lukker programet");
      
      Letters = scanner.next();
      switch (Letters){
      
         case "add":
         int ordernumber = scanner.nextInt();
         Orders.addOrder(ordernumber);
         break; 
         
         case "done":
         int sletnummer = scanner.nextInt();
         Orders.completeOrder(sletnummer);
         break; 
         
         case "delete":
          int deletenumber = scanner.nextInt();
         Orders.deleteOrder(deletenumber);
         break;
         
         case "view":         
        Orders.printOrders();
         break;

         case "Q":
         System.exit(0); 
}

      
      

      //Orders.addOrder();
      //Orders.completeOrder();
      //Orders.deleteOrder();
      
      //Orders.printOrders();
      SwingUtilities.invokeLater(()->{ 
         new UI();
      });
   }
}