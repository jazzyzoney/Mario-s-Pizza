import javax.swing.*;
import java.awt.Color;

public class UI{
   
   static JFrame aFrame;
   static JFrame mFrame;
   static JFrame sFrame;
   static JFrame doFrame;
   
   public UI(){
      alfonsoFrame();
      marioFrame();
   }
   
   public static void alfonsoFrame(){
      aFrame = new JFrame();
      aFrame.setSize(800,1080);
      aFrame.setTitle("Håndter Ordrer");//temporary name
      aFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      aFrame.setVisible(true);
      
      JPanel aPanel = new JPanel();
      aPanel.setBackground(new Color(70,70,70));
      
      
      JButton addButton = new JButton("Ny ordre");
      //addButton.
      JButton deleteButton = new JButton("slet");
      JButton completeButton = new JButton ("færdig");
      
      aPanel.add(addButton);
      aPanel.add(deleteButton);
      aPanel.add(completeButton);
      
      aFrame.add(aPanel);
   }
   
   public static void marioFrame(){
      statisticsFrame();
   }
   
   public static void statisticsFrame(){
   
   }
   
   public static void deleteOrderFrame(){
   }
}