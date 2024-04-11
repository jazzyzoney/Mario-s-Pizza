import java.util.Scanner;
import javax.swing.*;

public class Main{
   public static void main (String [] args){
      TextUI.textUI();
      
      SwingUtilities.invokeLater(()->{ 
         new UI();
      });
   }
}