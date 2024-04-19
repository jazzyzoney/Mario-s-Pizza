import java.util.Scanner;
import javax.swing.*;

public class Main{
   
   public static void main (String [] args){
      Menu.addPizzamenu(); 
      
      SwingUtilities.invokeLater( //dette kører swing 
         ()->{ 
            new UI();  
         });
     
     //TextUI.textUI(); //dette kører tekstbaseret UI
   }
}