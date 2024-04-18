import java.util.Scanner;
import javax.swing.*;

public class Main{
   
   public static void main (String [] args){
      Menu.addPizzamenu(); 
      //Scanner scanner = new Scanner(System.in);
      //int menuChoice = scanner.nextInt();
      //Menu.pizzaMenuCard(menuChoice);
   
      //OrderList.addOrder(2);
      //OrderList.printOrders();
      //OrderList.completeOrder(1);
      //TextUI.textUI();
      
      SwingUtilities.invokeLater(()->{ 
        new UI();  
      });
     /*
     Statistics.loadsavefile();
     System.out.println(Statistics.totalTurnover());
     Statistics.mostSold();
     Statistics.printCompletedOrders();*/
     //System.out.println(Statistics.mostSold());
     //TextUI.textUI ();
     
   }
}