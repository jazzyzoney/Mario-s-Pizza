import java.util.Scanner;
import javax.swing.*;

public class Main{
   
   public static void main (String [] args){
      //TextUI.textUI();
      
      Statistics.turnover();
      Statistics.favoritePizza();
      //Statistics.updateStatistics();
      
      Menu.addPizzamenu(); 
      Scanner scanner = new Scanner(System.in);
      int menuChoice = scanner.nextInt();
      Menu.pizzaMenuCard(menuChoice);
      
      /*SwingUtilities.invokeLater(()->{ 
         new UI();
      });*/
   }
}