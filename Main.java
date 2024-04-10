import java.util.Scanner;
import javax.swing.*;

public class Main{
static Scanner scanner = new Scanner(System.in);

   public static void main(String[] args){
      Menu.addPizzamenu();
      Menu.printMenu();

      //Orders.addOrder();
      //Orders.completeOrder();
      //Orders.deleteOrder();
      
      //Orders.printOrders();
      SwingUtilities.invokeLater(()->{ 
         new UI();
      });
   }
}