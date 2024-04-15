import java.util.Scanner;
import javax.swing.*;

public class Main{
   
   public static void main (String [] args){
      Menu.addPizzamenu(); 
      //Scanner scanner = new Scanner(System.in);
      //int menuChoice = scanner.nextInt();
      //Menu.pizzaMenuCard(menuChoice);
   
      OrderList.addOrder(8);
      //OrderList.addOrder(7);
     // OrderList.printOrders();
      //TextUI.textUI();q
      
      
      
      SwingUtilities.invokeLater(()->{ 
         new UI();  
      });
      //TextUI.textUI ();
   }
   
}