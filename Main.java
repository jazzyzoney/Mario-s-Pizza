import java.util.Scanner;
import javax.swing.*;

public class Main{
   
   public static void main (String [] args){
   Menu.addPizzamenu();
      OrderList.addOrder(2);
      OrderList.printOrders();
      //TextUI.textUI();
      
      /*SwingUtilities.invokeLater(()->{ 
         new UI();
      });*/
   }
}